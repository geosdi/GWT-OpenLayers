package com.eg.gwt.openLayers.client.layer;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class WMSLayerParams extends LayerOptions {


	/**
	 * Set the singleTile property to be true or false.
	 * By default singleTile is set to false.
	 * .
	 * If true, the map is served as a single tile instead of separate tiles.
	 *
	 * Why tile or not tile?
	 * At www.bostongis.com some guidelines can be found
	 *
	 *   Use untiled in the following scenarios:
	 *   -fairly lightweight (in file size) geometries that span huge areas
	 *   -a process constrained WMS server
	 *   -you find it annoying that half of your map paints, while the other half is loading
	 *   -high-bandwith servers and high-bandwith clients
	 *   -map images with embedded scales
	 *
	 *   Use tiled in the following scenarios:
	 *   -have heavy geometries that (in file size) that span small areas
	 *   -super fast WMS server or server with tile caching (built in)
	 *   -low band-width clients
	 *   -relatively long pauses of a completely blank map area that suddenly loads all at once annoys you
	 *    (remark: the blank map problem can be solved by setting a transition effect)
	 *
	 */
	public void setSingleTile(boolean b){
		setAttribute("singleTile", b);
	}


	/**
	 * Sets singleTile option to true.
	 */
	public void setUntiled(){
		setSingleTile(true);
	}


	public void setTransitionEffect(String transition){
		setAttribute("transitionEffect", transition);
	}

	/**
	 * From the OpenLayers examples: The 'resize' effect
	 * resamples the current tile and displays it stretched
	 * or compressed until the new tile is available.
	 */
	public void setTransitionEffectResize(){
		setTransitionEffect("resize");
	}

	/**
	 * To specify if the layer is a BaseLayer. Only one BaseLayer can be active at a time,
	 * and if a BaseLayer is active it cannot be made invisible {link @Layer}.
	 *
	 * If there is more than one BaseLayer then it is possible to choose between BaseLayers in the LayerSwitcher.
	 *
	 * By default isBaseLayer is set to true for WMS layers.
	 */
	public void setIsBaseLayer(boolean isBaseLayer){
		setAttribute("isBaseLayer", isBaseLayer);
	}

	/**
	 * To specify the opacity of a Layer.
	 *
	 * @param opacity - 1 = completely opaque, 0 = completely non-opaque
	 */
	public void setLayerOpacity(double opacity){
		setAttribute("opacity", opacity);
	}

	/**
	 * Set a non-default projection. Default projection is EPSG:4326.
	 *
	 * @param epsgCode - the EPSG code for the coordinate reference system
	 */
	public void setProjection(String epsgCode){
		setAttribute("projection", epsgCode);
	}

	/**
	 * e.g. "m", "km", ...
	 */
	public void setUnits(String units){
		setAttribute("units", units);
	}

	/**
	 * For tiled layers the buffer size can be set.
	 *
	 * The default buffer is 2.
	 */
	public void setBuffer(int buffer){
		setAttribute("buffer", buffer);
	}

	public void setRatio(int ratio){
		setAttribute("ratio", ratio);
	}

}
