package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
* Wrapper of OpenLayers.Layer.Grid in OpenLayers. Renamed Grid to GridLayer
* in order to avoid confusion around the generic term Grid.
*
* From OL API docs:
* Base class for layers that use a lattice of tiles.
*
* @author Edwin Commandeur - Atlis EJS
*
*/
public class GridLayer extends HTTPRequestLayer {

	//TODO: properties that are specific to GridLayer

	protected GridLayer(JSObject element) {
		super(element);
	}


}
