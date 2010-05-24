package org.gwtopenmaps.openlayers.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a transparent HTTP proxy written in Java that is similar to the proxy in
 * the OpenLayers examples, which is written in Python. These proxies are used
 * to circumvent browser restrictions on cross-domain requests with Javascript.
 * </p>
 * <p>
 * To use the proxy you need to 1) configure the proxy servlet in your web.xml
 * and 2) use OpenLayers.setProxyHost to set the url-path to the proxy. If the
 * proxy is configured to listen to the url-pattern '/gwtOpenLayersProxy/*' then
 * the proxy host should be set to 'gwtOpenLayersProxy?targetURL='.
 * </p>
 * Initial code for this proxy is based upon <a href=
 * "http://trac.openlayers.org/changeset/8099/sandbox?format=diff&new=8099">the
 * following code</a><br />
 * see also <a href=
 * "http://java.sun.com/docs/books/tutorial/networking/urls/readingWriting.html"
 * title="this networking tutorial">this networking tutorial</a>
 * <p>
 */
@SuppressWarnings("serial")
public class GwtOpenLayersProxyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpURLConnection connection = null;
		InputStream istream = null; //input to proxy
		OutputStream ostream = null; //output from proxy
		InputStream connectionIstream = null; //output for the target is input for the connection
		OutputStream connectionOstream = null; //input for the target is output for the connection

		//For some security reasons it should be possible to specify the allowedHosts.
		//The allowedHosts are the hosts that are allowed to use the Open Proxy.

		//request.getRemoteAddr(); // get IP address of client - for checking allowedIPs
		String remoteHost = request.getRemoteHost(); // get host address of client - for checking allowedHosts
		boolean allowedHost = isAllowedHost(remoteHost);
		//HTTP request should be copied 1:1 (that is essence transparent proxy)
		// GET request is determined by url, parameters, headers
		// if url is send then no need to copy params, but still need to copy headers

		try {
			// easy way to ignore case of param?
			if(request.getParameter("targetURL") != null && request.getParameter("targetURL") != "" && allowedHost) {

				// HTTPUrlConnection looks at http.proxyHost and http.proxyPort system properties.
				// Make sure these properties are set these if you are behind a proxy.

				//initialize
				String requestMethod = request.getMethod();

				URL targetURL = new URL(request.getParameter("targetURL"));
				connection = (HttpURLConnection) targetURL.openConnection();
				//TODO make sure all headers are copied to target, see for HTTP headers http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html
				//possibly: copyGenericRequestProperties
				// copyGETSpecificRequestProperties, copyPOSTSpecificRequestProperties
				//TODO set de-facto standard proxy headers (x-forwarded-for etc)
				connection.setRequestMethod(requestMethod);
				connection.setRequestProperty( "Content-Type",request.getContentType()); //also for GET??? Not according to http://en.wikipedia.org/wiki/List_of_HTTP_headers
				Map<String, List<String>> reqProps = connection.getRequestProperties();
				reqProps.isEmpty();
				//
				if (requestMethod.equals("GET")){
					//default for setDoInput is true
					//connection.setDoInput(true); //use connection only for output with GET
					connectionIstream = connection.getInputStream();
					//connection.get
				};
				if (requestMethod.equals("POST")){
					int clength = request.getContentLength();//clength is for checking if there is a POST body. Is that sufficient?

					if(clength > 0) {
						istream = request.getInputStream();
						connection.setDoOutput(true);//for POST we need to write to connection
						connection.setRequestProperty( "Content-Length",Integer.toString(clength)); //only valid for POST request
						connectionOstream = connection.getOutputStream();
						//copy the request body to remote outputStream
						copy(istream, connectionOstream);
					}
					connectionIstream = connection.getInputStream();
				}
				//can output be the same for GET/POST? or different return headers?
				//servlet may return 3 things: status code, headers, response body
				// status code and headers have to be set before response body
				response.setContentType(connection.getContentType());
				ostream = response.getOutputStream();
				copy(connectionIstream, ostream);
			}
			// if not targetURL send page that targetURL is required param
		} catch (Exception e){
			response.setStatus(500); //what will user get? default page for response code
			//WMS/WFS have specific responses to errors
			//response.getWriter();//will writing custom result help
			e.printStackTrace();
		} finally {
			if(istream != null) { istream.close(); }
			if(ostream != null) { ostream.close(); }
			if(connectionIstream != null) { connectionIstream.close(); }
			if(connectionOstream != null) { connectionOstream.close(); }
		}

	}

	private void copy(InputStream istream, OutputStream ostream) throws Exception {
		int bufferSize = 4*4*1024;//same buffer size as in Jetty utils (2*8192)
		byte[] buffer = new byte[bufferSize];
		int read;
		while ((read = istream.read(buffer)) != -1) {
			ostream.write(buffer, 0, read);
		}
	}

	private boolean isAllowedHost(String remoteHost){
		//TODO checking of host
		return true;
	}
}
