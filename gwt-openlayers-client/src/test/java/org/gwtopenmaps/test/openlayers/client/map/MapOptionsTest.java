package org.gwtopenmaps.test.openlayers.client.map;

import org.gwtopenmaps.openlayers.client.ZIndexBase;
import org.gwtopenmaps.test.openlayers.client.BaseTestCase;

public class MapOptionsTest extends BaseTestCase{

	public void testMapOptions(){
		//MapOptions mapOptions = new MapOptions();
		ZIndexBase zIndexBase = new ZIndexBase();
		zIndexBase.setForBaseLayers(125);
		assertEquals(125, zIndexBase.getJSObject().getPropertyAsInt("BaseLayer"));
	}

}
