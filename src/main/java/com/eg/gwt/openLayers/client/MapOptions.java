package com.eg.gwt.openLayers.client;

import com.eg.gwt.openLayers.client.util.JObjectArray;


/**
 * Properties of the map can be set via map options
 *
 * @author Erdem Gunay, Edwin Commandeur
 *
 */
public class MapOptions extends OptionsBase {

	public MapOptions() {

	}

	public void setNumZoomLevels(int numZoomLevels) {
		setAttribute("numZoomLevels", numZoomLevels);
	}

	public void setControls(JObjectArray controls) {
		setAttribute("controls", controls);
	}

	/**
	 * Use this method to change the default projection (EPSG:4326)
	 * to another projection.
	 *
	 * See http://spatialreference.org/ for EPSG codes for projections.
	 *
	 * Properties for default projection:
	 *   map.setProjection("EPSG:4326");
	 *   map.setMaxExtent(new Bounds(-180, -90, 180, 90));
	 *
	 * Some resources explaining map projections:
	 *   John P. Snyder (). Map Projections - A Working Manual
	 *   ISBN-13
	 *
	 * From the OpenLayers docs:
	 * Set in the map options to override the default projection on the map.
	 *  - also set maxExtent, maxResolution, and units if appropriate.
	 * @param projection
	 */
	public void setProjection(String projection) {
		setAttribute("projection", projection);
	}

	/**
	 * Use this method to change the display projection
	 * to another projection.
	 *
	 * @param projection
	 */
	public void setDisplayProjection(Projection projection) {
		setAttribute("displayProjection", projection.getJSObject());
	}

	/**
	 * The upper bounds of the spatial coordinate reference system, provided
	 * in the units that CRS.
	 * OR
	 * The upper bounds of the spatial data, provided in the units of the CRS
	 * in which the spatial data is served.
	 *
	 * @param maxExtent - a bounding rectangle
	 */
	public void setMaxExtent(Bounds maxExtent) {
		setAttribute("maxExtent", maxExtent.getJSObject());
	}


	/**
	 * The lower bounds of the spatial coordinate reference system, provided
	 * in the units that CRS.
	 * OR
	 * The lower bounds of the spatial data, provided in the units of the CRS
	 * in which the spatial data is served.
	 *
	 * @param minExtent - a bounding rectangle
	 */
	public void setMinExtent(Bounds minExtent) {
		setAttribute("minExtent", minExtent.getJSObject());
	}

	public void setRestrictedExtent(Bounds restrictedExtent) {
		setAttribute("restrictedExtent", restrictedExtent.getJSObject());
	}

	/**
	 *
	 * See also setMaxResolutionToAuto.
	 *
	 * From the OpenLayers docs:
	 * Default max is 360 deg / 256 px (or 1,40625), which corresponds to
	 * zoom level 0 on gmaps.
	 */
	public void setMaxResolution(float maxResolution){
		setAttribute("maxResolution", maxResolution);
	}

	/**
	 * Convenience method for setting max resolution to auto.
	 *
	 * ???Best option when the map can be resized?
	 *
	 */
	public void setMaxResolutionToAuto(){
		setAttribute("maxResolution", "auto");
	}

	public void setMinResolution(float minResolution){
		setAttribute("minResolution", minResolution);
	}

	/**
	 * The units used by the map to express geospatial coordinates. These units
	 * should be consistent with the projection used.
	 *
	 * Use constants from the worker class MapUnits as input parameter.
	 * For example:
	 *  setUnits(MapUnits.DEGREES);
	 *
	 * These units are also used by map controls.
	 *
	 * From the OpenLayers docs:
	 * Defaults to �degrees�. Possible values are �degrees� (or �dd�),
	 * �m�, �ft�, �km�, �mi�, �inches�.
	 */
	public void setUnits(String units){
		setAttribute("units", units);
	}


	public void setMaxScale(float maxScale){
		setAttribute("maxScale", maxScale);
	}

	public void setMinScale(float minScale){
		setAttribute("minScale", minScale);
	}

	public void setTileSize(Size size){
		setAttribute("tileSize", size.getJSObject());

	}

}
