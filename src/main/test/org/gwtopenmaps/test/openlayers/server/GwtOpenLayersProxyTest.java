package org.gwtopenmaps.test.openlayers.server;

import static org.junit.Assert.assertEquals;

import org.gwtopenmaps.openlayers.server.GwtOpenLayersProxyServlet;
import org.junit.Before;
import org.junit.Test;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

public class GwtOpenLayersProxyTest {

	ServletRunner servletRunner;
	ServletUnitClient servletUnitClient;
	String postBodyStates = "<wfs:GetFeature xmlns:wfs=\"http://www.opengis.net/wfs\" service=\"WFS\" version=\"1.0.0\" xsi:schemaLocation=\"http://www.opengis.net/wfs http://schemas.opengis.net/wfs/1.0.0/WFS-transaction.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><wfs:Query typeName=\"feature:states\" xmlns:feature=\"http://www.openplans.org/topp\"><ogc:Filter xmlns:ogc=\"http://www.opengis.net/ogc\"><ogc:BBOX><ogc:PropertyName>the_geom</ogc:PropertyName><gml:Box xmlns:gml=\"http://www.opengis.net/gml\" srsName=\"EPSG:4326\"><gml:coordinates decimal=\".\" cs=\",\" ts=\" \">-272.4,-52.2 87.6,127.8</gml:coordinates></gml:Box></ogc:BBOX></ogc:Filter></wfs:Query></wfs:GetFeature>";
	String postBodyTasmania ="<wfs:GetFeature xmlns:wfs=\"http://www.opengis.net/wfs\" service=\"WFS\" version=\"1.0.0\" xsi:schemaLocation=\"http://www.opengis.net/wfs http://schemas.opengis.net/wfs/1.0.0/WFS-transaction.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><wfs:Query typeName=\"feature:tasmania_roads\" xmlns:feature=\"http://www.openplans.org/topp\"><ogc:Filter xmlns:ogc=\"http://www.opengis.net/ogc\"><ogc:BBOX><ogc:PropertyName>the_geom</ogc:PropertyName><gml:Box xmlns:gml=\"http://www.opengis.net/gml\" srsName=\"EPSG:4326\"><gml:coordinates decimal=\".\" cs=\",\" ts=\" \">135.45,-47.425 157.95,-36.175</gml:coordinates></gml:Box></ogc:BBOX></ogc:Filter></wfs:Query></wfs:GetFeature>";

	@Before
	public void setup(){
		servletRunner = new ServletRunner();
		servletRunner.registerServlet("proxy", GwtOpenLayersProxyServlet.class.getName());
		servletUnitClient = servletRunner.newClient();
	}

	//bring servlet up with embedded Jetty?
	@Test
	public void wfsGetRequest() throws Exception {
		GetMethodWebRequest request = new GetMethodWebRequest( "http://localhost/proxy" );
		//TODO make actual request to http://demo.opengeo.org/geoserver/wfs
		request.setParameter("resourceUrl", "");
		WebResponse response = servletUnitClient.getResponse( request );
		assertEquals( "content type", "text/plain", response.getContentType());
	}

	@Test
	public void wfsPostRequest() throws Exception {
		PostMethodWebRequest request = new PostMethodWebRequest( "http://localhost/proxy" );
		//TODO make actual request to http://demo.opengeo.org/geoserver/wfs
		request.setParameter("targetUrl", "");
		WebResponse response = servletUnitClient.getResponse( request );
		assertEquals( "content type", "text/plain", response.getContentType());
	}
}
