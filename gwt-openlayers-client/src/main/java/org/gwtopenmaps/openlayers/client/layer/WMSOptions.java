package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class WMSOptions extends GridLayerOptions {

    public WMSOptions() {
    }

    protected WMSOptions(JSObject jsObject) {
        super(jsObject);
    }

    // TODO: see which options should be moved to LayerOptions
    /**
     * Set the singleTile property to be true or false. By default singleTile is
     * set to false. . If true, the map is served as a single tile instead of
     * separate tiles.
     *
     * Why tile or not tile? At www.bostongis.com some guidelines can be found
     *
     * Use untiled in the following scenarios: -fairly lightweight (in file
     * size) geometries that span huge areas -a process constrained WMS server
     * -you find it annoying that half of your map paints, while the other half
     * is loading -high-bandwith servers and high-bandwith clients -map images
     * with embedded scales
     *
     * Use tiled in the following scenarios: -have heavy geometries that (in
     * file size) that span small areas -super fast WMS server or server with
     * tile caching (built in) -low band-width clients -relatively long pauses
     * of a completely blank map area that suddenly loads all at once annoys you
     * (remark: the blank map problem can be solved by setting a transition
     * effect)
     *
     */
    public void setSingleTile(boolean b) {
        getJSObject().setProperty("singleTile", b);
    }

    /**
     * Sets singleTile option to true.
     */
    public void setUntiled() {
        setSingleTile(true);
    }

    /**
     * From the OpenLayers examples: The 'resize' effect resamples the current
     * tile and displays it stretched or compressed until the new tile is
     * available.
     *
     * @deprecated - use setTransitionEffect(TransitionEffect) instead of this
     * convenience method.
     */
    public void setTransitionEffectResize() {
        setTransitionEffect("resize");
    }

    /**
     * Set a non-default projection. Default projection is EPSG:4326.
     *
     * @param epsgCode - the EPSG code for the coordinate reference system
     */
    @Override
    public void setProjection(String epsgCode) {
        getJSObject().setProperty("projection", epsgCode);
    }

    /**
     * e.g. "m", "km", ...
     */
    @Override
    public void setUnits(String units) {
        getJSObject().setProperty("units", units);
    }

    /**
     * Set whether or not to wrap at the international date line.
     *
     * @param wrap - true to wrap, false to not wrap
     */
    public void setWrapDateLine(boolean wrap) {
        getJSObject().setProperty("wrapDateLine", wrap);
    }

    /**
     * For tiled layers the buffer size can be set.
     *
     * The default buffer is 2.
     */
    @Override
    public void setBuffer(int buffer) {
        getJSObject().setProperty("buffer", buffer);
    }

    public void setRatio(int ratio) {
        getJSObject().setProperty("ratio", ratio);
    }

    public void setReproject(boolean reproject) {
        getJSObject().setProperty("reproject", reproject);
    }
}
