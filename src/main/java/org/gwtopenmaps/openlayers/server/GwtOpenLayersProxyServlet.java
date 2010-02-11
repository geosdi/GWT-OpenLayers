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
 * OpenLayers contains an Open Proxy to circumvent browser restrictions on
 * cross-domain requests with Javascript. However, the OpenLayers proxy needs
 * Python to run. This is a port of the Open Proxy to Java.
 *
 * For extra security the allowedHosts should be specified.
 * The allowedHosts are the allowed target hosts to which the request may be proxied.
 *
 * Parameter expected for GET requests:
 *    url - an URL that is directly queried in a proxied GET
 *
 * Parameters expected for POST requests:
 *    url - see GET request
 *    body - body of the POST request
 *    headers - headers for the POST request (?GET can also have headers?)
 *
 * What are the plans for OpenLayers 3.x?
 *
 * Plan for GWT: do check on parameters, and only allow specific types of requests.
 * However: does this make it more secure in any way???
 *
 */

@SuppressWarnings("serial")
public class GwtOpenLayersProxyServlet extends HttpServlet {

//	private static final String PARAMETER_URL_LC = "url";
//	private static final String PARAMETER_URL_UC = "URL";
//	private static final String PARAMETER_BODY = "body";

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

//		HttpUtils httpUtils = new HttpUtils();
//		httpUtils.parsePostData(len, in); //should I use this for parsing POST data?

        HttpURLConnection connection = null;
        InputStream istream = null;
        OutputStream ostream = null;
        InputStream ristream = null;
        OutputStream rostream = null;
           
        try {
            if(request.getParameter("resourceUrl") != null && request.getParameter("resourceUrl") != "") {
                URL resourceUrl = new URL(request.getParameter("resourceUrl"));
                connection = (HttpURLConnection)resourceUrl.openConnection();
                connection.setDoInput(true);
                connection.setRequestMethod(request.getMethod());
                connection.setRequestProperty("Content-Type", "application/xml");
                ristream = connection.getInputStream();
                response.setContentType("application/vnd.google-earth.kml+xml");
                rostream = response.getOutputStream();
                final int length = 5000;
                byte[] bytes = new byte[length];
                int bytesRead = 0;

                int totalBytes = 0;
                while ((bytesRead = ristream.read(bytes, 0, length)) > 0) {
                    rostream.write(bytes, 0, bytesRead);
                    totalBytes += bytesRead;
                }
            } else if(request.getParameter("targetUrl") != null && request.getParameter("targetUrl") != "") {
                URL targetUrl = new URL(request.getParameter("targetUrl"));
                connection = (HttpURLConnection)targetUrl.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod(request.getMethod());

                int clength = request.getContentLength();
                if(clength > 0) {
                    connection.setDoInput(true);
                    istream = request.getInputStream();
                    ostream = connection.getOutputStream();
                    final int length = 5000;
                    byte[] bytes = new byte[length];
                    int bytesRead = 0;
                    while((bytesRead = istream.read(bytes, 0, length)) > 0) {
                        ostream.write(bytes, 0, bytesRead);
                    }
                }

                rostream = response.getOutputStream();
                response.setContentType(connection.getContentType());
                ristream = connection.getInputStream();
                final int length = 5000;
                byte[] bytes = new byte[length];
                int bytesRead = 0;
                while ((bytesRead = ristream.read(bytes, 0, length)) > 0) {
                    rostream.write(bytes, 0, bytesRead);
                }
            } else {
                return;
            }
        } catch(Exception e) {
            response.setStatus(500);
            e.printStackTrace();
        } finally {
            if(istream != null) { istream.close(); }
            if(ostream != null) { ostream.close(); }
            if(ristream != null) { ristream.close(); }
            if(rostream != null) { rostream.close(); }
        }
	}

		
//		String host = request.getRemoteHost();
//		String targetURL = request.getParameter(PARAMETER_URL_LC);
//		if(targetURL == null){
//			targetURL = request.getParameter(PARAMETER_URL_UC);
//		}
//
//		//read from configuration file
//		//String[] allowedHosts = {"", ""};
//
//
//		response.setContentType("text/plain");
//
//		//TODO: make serious implementation of proxy
//		PrintWriter writer = response.getWriter();
//		writer.println("Host: " + host);
//		writer.println("URL: " + targetURL);
//	}

}
