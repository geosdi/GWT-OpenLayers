package org.gwtopenmaps.demo.openlayers.server;

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
 * This is a transparent HTTP proxy written in Java that is similar to the proxy in
 * the OpenLayers examples, which is written in Python. These proxies are used
 * to circumvent browser restrictions on cross-domain requests with Javascript.
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
 *
 * @author gwtol/John Doe
 */
public class GwtOpenLayersProxyServlet extends HttpServlet
{
    private static final long serialVersionUID = -5577804552108661723L;

    @Override
    /*
     * (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    /*
     * (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     *
     * @param request req
     * @param response res
     * @throws ServletException se
     * @throws IOException ioe
     */
    private void processRequest(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    {
        HttpURLConnection connection = null;
        InputStream istream = null; // input to proxy
        OutputStream ostream = null; // output from proxy
        InputStream connectionIstream = null; // output for the target is input for the connection
        OutputStream connectionOstream = null; // input for the target is output for the connection

        String remoteHost = request.getRemoteHost(); // get host address of client - for checking allowedHosts
        boolean allowedHost = isAllowedHost(remoteHost); // The allowedHosts are the hosts that are allowed to use the Open Proxy.

        try
        {
            // easy way to ignore case of param?
            if ((request.getParameter("targetURL") != null) && (request.getParameter("targetURL") != "") && allowedHost)
            {
                // HTTPUrlConnection looks at http.proxyHost and http.proxyPort system properties.
                // Make sure these properties are set these if you are behind a proxy.

                // step 1: initialize
                String requestMethod = request.getMethod();

                URL targetURL = new URL(request.getParameter("targetURL"));
                connection = (HttpURLConnection) targetURL.openConnection();
                connection.setRequestMethod(requestMethod);
                transferHTTPRequestHeaders(connection, request);

                // step 2: proxy requests
                if (requestMethod.equals("GET"))
                {
                    // default for setDoInput is true
                    connectionIstream = connection.getInputStream();
                }

                if (requestMethod.equals("POST"))
                {
                    transferHTTPRequestHeadersForPOST(connection, request);

                    int clength = request.getContentLength(); // clength is for checking if there is a POST body. Is that sufficient?

                    if (clength > 0)
                    {
                        istream = request.getInputStream();
                        connection.setDoOutput(true); // for POST we need to write to connection
                        connection.setRequestProperty("Content-Length", Integer.toString(clength)); // only valid for POST request
                        connectionOstream = connection.getOutputStream();

                        // copy the request body to remote outputStream
                        copy(istream, connectionOstream);
                    }

                    connectionIstream = connection.getInputStream();
                }

                // step 3: return output
                // can output be the same for GET/POST? or different return headers?
                // servlet may return 3 things: status code, response headers, response body
                // status code and headers have to be set before response body
                response.setContentType(connection.getContentType());
                ostream = response.getOutputStream();
                copy(connectionIstream, ostream);
            }
            // if not targetURL send page that targetURL is required param
        }
        catch (Exception e)
        {
            response.setStatus(500); // what will user get? default page for response code

            // WMS/WFS have specific responses to errors
            // response.getWriter();//will writing custom result help
            e.printStackTrace();
        }
        finally
        {
            if (istream != null)
            {
                istream.close();
            }

            if (ostream != null)
            {
                ostream.close();
            }

            if (connectionIstream != null)
            {
                connectionIstream.close();
            }

            if (connectionOstream != null)
            {
                connectionOstream.close();
            }
        }

    }

    /**
     *
     * @param istream is
     * @param ostream os
     * @throws Exception ex
     */
    private void copy(InputStream istream, OutputStream ostream) throws Exception
    {
        int bufferSize = 4 * 4 * 1024; // same buffer size as in Jetty utils (2*8192)
        byte[] buffer = new byte[bufferSize];
        int read;

        while ((read = istream.read(buffer)) != -1)
        {
            ostream.write(buffer, 0, read);
        }
    }

    /**
     *
     * @param connection con
     * @param request req
     */
    private void transferHTTPRequestHeaders(HttpURLConnection connection, HttpServletRequest request)
    {
        // TODO make sure all headers are copied to target, see for HTTP headers http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html
        // Do request.getProperties to get request properties
        if (request.getHeader("Accept") != null)
        {
            connection.setRequestProperty("Accept", request.getHeader("Accept"));
        }

        if (request.getHeader("Accept-Charset") != null)
        {
            connection.setRequestProperty("Accept-Charset", request.getHeader("Accept-Charset"));
        }

        /*
        if (request.getHeader("Accept-Encoding") != null)
        {
            // TODO browsers accept gzipped, should proxy accept gzip and how to handle it?
            // connection.setRequestProperty("Accept-Encoding", request.getHeader("Accept-Encoding"));
        }*/

        if (request.getHeader("Authorization") != null)
        {
            connection.setRequestProperty("Authorization", request.getHeader("Authorization"));
        }

        /*
        if (request.getHeader("Connection") != null)
        {
            // TODO HTTP/1.1 proxies MUST parse the Connection header field before a message is forwarded and, for each connection-token in this field, remove any header field(s) from the message with the same name as the connection-token.
            // connection.setRequestProperty("Connection", request.getHeader("Connection"));
        }*/

        // set de-facto standard proxy headers (x-forwarded-for, others?s)
        if (request.getHeader("X-Forwarded-For") != null)
        {
            connection.setRequestProperty("X-Forwarded-For", request.getHeader("X-Forwarded-For")); // TODO append IP proxy
        }
        else
        {
            connection.setRequestProperty("X-Forwarded-For", request.getRemoteAddr()); // TODO append IP proxy
        }
    }

    /**
     *
     * @param connection con
     * @param request req
     */
    private void transferHTTPRequestHeadersForPOST(HttpURLConnection connection, HttpServletRequest request)
    {
        if (request.getHeader("Content-Type") != null)
        {
            connection.setRequestProperty("Content-Type", request.getContentType());
        }
        else
        {
            // throw exception?
        }
    }

    /**
     *
     * @param remoteHost rem
     * @return true
     */
    private boolean isAllowedHost(String remoteHost)
    {
        // TODO checking of host
        return true;
    }
}
