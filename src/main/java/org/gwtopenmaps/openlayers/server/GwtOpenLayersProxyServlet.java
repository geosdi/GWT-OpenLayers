package org.gwtopenmaps.openlayers.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * OpenLayers contains an Open Proxy written in Python to circumvent browser restrictions on
 * cross-domain requests with Javascript. This proxy is included in the Examples. This is a similar Open Proxy written in Java.
 *
 * Parameter expected for GET/POST requests:
 *    targetURL - the full remote URL to proxy the request to
 *
 * In addition, a POST request should specify a body.
 *
 * What are the plans for OpenLayers 3.x with the Open Proxy?
 *
 * Initial code for this proxy is based upon the following code:
 * http://trac.openlayers.org/changeset/8099/sandbox?format=diff&new=8099
 * see also:
 * http://java.sun.com/docs/books/tutorial/networking/urls/readingWriting.html
 *
 */

//For some level of security it should be possible to specify the allowedHosts.
//The allowedHosts are the hosts that are allowed to use the Open Proxy.

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

		//request.getRemoteAddr(); // get IP address of client - for checking allowedIPs
		//request.getRemoteHost(); // get host address of client - for checking allowedHosts

		//HTTP request should be copied 1:1 (that is essence transparent proxy)
		// GET request is determined by url, parameters, headers
		// if url is send then no need to copy params, but still need to copy headers

		try {
			// easy way to ignore case of param?
			if(request.getParameter("targetURL") != null && request.getParameter("targetURL") != "") {

				// HTTPUrlConnection looks at http.proxyXxx properties
//				Properties systemProperties = System.getProperties();
//				systemProperties.setProperty("http.proxyHost", yourproxy);
//				systemProperties.setProperty("http.proxyPort", yourport);

				//initialize
				String requestMethod = request.getMethod();

				URL targetURL = new URL(request.getParameter("targetURL"));
				connection = (HttpURLConnection) targetURL.openConnection();
				connection.setRequestMethod(requestMethod);
				//possibly: copyGenericRequestProperties
				// copyGETSpecificRequestProperties, copyPOSTSpecificRequestProperties
				connection.setRequestProperty( "Content-Type",request.getContentType()); //also for GET???
				//What if proxy settings are set in environment
				//set x-header in forwarded request
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
						connectionOstream = connection.getOutputStream();

						connection.setDoOutput(true);//for POST we need to write to connection
						connection.setRequestProperty( "Content-Length",Integer.toString(clength)); //only valid for POST request

						//copy the request body to remote outputStream
						copy(istream, connectionOstream);
					}
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

		//Does it make sense to have resourceUrl for GET and targetURL for POST?
		//Why not expect url param and look at request method to decide upon action?
		//Or call them getUrl and postUrl?
//		try {
//			if(request.getParameter("resourceUrl") != null && request.getParameter("resourceUrl") != "") {
//				URL resourceUrl = new URL(request.getParameter("resourceUrl"));
//				connection = (HttpURLConnection)resourceUrl.openConnection();
//				connection.setDoInput(true); // is this necessary ??? NO, is default
//				connection.setRequestMethod(request.getMethod());
//				connection.setRequestProperty("Content-Type", "application/xml");
//				ristream = connection.getInputStream(); //is this where content is retrieved?
//				//why not get the content type from the connection here?
//				//is response specific to GET or build in the same was with POST
//				response.setContentType("application/vnd.google-earth.kml+xml");
//				rostream = response.getOutputStream();

	//				final int length = 5000;
//				byte[] bytes = new byte[length];
//				int bytesRead = 0;
//
//				int totalBytes = 0;
//				while ((bytesRead = ristream.read(bytes, 0, length)) > 0) {
//					rostream.write(bytes, 0, bytesRead);
//					totalBytes += bytesRead;
//				}
//			} else if(request.getParameter("targetUrl") != null && request.getParameter("targetUrl") != "") {
//				URL targetUrl = new URL(request.getParameter("targetUrl"));
//				connection = (HttpURLConnection)targetUrl.openConnection();
//				connection.setDoOutput(true);
//				connection.setRequestMethod(request.getMethod());
//
//				int clength = request.getContentLength();
//				if(clength > 0) {
//					connection.setDoInput(true);
//					istream = request.getInputStream();
//					ostream = connection.getOutputStream();
//					final int length = 5000;
//					byte[] bytes = new byte[length];
//					int bytesRead = 0;
//					while((bytesRead = istream.read(bytes, 0, length)) > 0) {
//						ostream.write(bytes, 0, bytesRead);
//					}
//				}
//
//				rostream = response.getOutputStream();
//				response.setContentType(connection.getContentType());
//				ristream = connection.getInputStream();
//				final int length = 5000;
//				byte[] bytes = new byte[length];
//				int bytesRead = 0;
//				while ((bytesRead = ristream.read(bytes, 0, length)) > 0) {
//					rostream.write(bytes, 0, bytesRead);
//				}
//			} else {
//				return;
//			}
//		} catch(Exception e) {
//			response.setStatus(500);
//			e.printStackTrace();
//		} finally {
//			if(istream != null) { istream.close(); }
//			if(ostream != null) { ostream.close(); }
//			if(ristream != null) { ristream.close(); }
//			if(rostream != null) { rostream.close(); }
//		}
//	}

	private void copy(InputStream istream, OutputStream ostream) throws Exception {
		int bufferSize = 4*4*1024;//same buffer size as in Jetty utils (2*8192)
		byte[] buffer = new byte[bufferSize];
		int read;
		while ((read = istream.read(buffer)) != -1) {
			ostream.write(buffer, 0, read);
		}
	}
}
