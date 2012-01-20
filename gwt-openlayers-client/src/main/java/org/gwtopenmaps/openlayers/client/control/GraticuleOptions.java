/**
 *
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.symbolizer.LineSymbolizer;
import org.gwtopenmaps.openlayers.client.symbolizer.TextSymbolizer;


/**
 * @author lorenzo
 *
 */
public class GraticuleOptions extends ControlOptions
{

    /**
     * APIProperty: displayInLayerSwitcher {Boolean} Allows the Graticule
     * control to be switched on and off. defaults to true.
     */
    public void setDisplayInLayerSwitcher(boolean isDisplay)
    {
        getJSObject().setProperty("displayInLayerSwitcher", isDisplay);
    }

    /**
     * APIProperty: visible {Boolean} should the graticule be initially visible
     * (default=true)
     */
    public void setVisible(boolean isVisible)
    {
        getJSObject().setProperty("visible", isVisible);
    }

    /**
     * APIProperty: labelled {Boolean} Should the graticule lines be labelled?.
     * default=true
     */
    public void setLabelled(boolean isLabelled)
    {
        getJSObject().setProperty("labelled", isLabelled);
    }

    /**
     * APIProperty: targetSize {Integer} The maximum size of the grid in pixels
     * on the map
     */
    public void setTargetSize(int size)
    {

        getJSObject().setProperty("targetSize", size);
    }

    /**
     * APIProperty: labelFormat {String} the format of the labels, default =
     * 'dm'. See <OpenLayers.Util.getFormattedLonLat> for other options.
     */
    public void setLabelFormat(String format)
    {
        getJSObject().setProperty("labelFormat", format);
    }

    /**
     * APIProperty: numPoints {Integer} The number of points to use in each
     * graticule line. Higher numbers result in a smoother curve for projected
     * maps
     */
    public void setNumPoints(int num)
    {
        getJSObject().setProperty("numPoints", num);
    }

    /**
     * APIProperty: layerName {String} the name to be displayed in the layer
     * switcher
     */
    public void setLayerName(String name)
    {
        getJSObject().setProperty("layerName", name);
    }

    /**
     * APIProperty: lineSymbolizer {symbolizer} the symbolizer used to render
     * lines
     *
     * IMPORTANT: when using a lineSymbolizer different from the default, the
     * minimal properties strokeColor, strokeWidth, strokeOpacity have to be set.
     */
    public void setLineSymbolyzer(LineSymbolizer line)
    {
        getJSObject().setProperty("lineSymbolizer", line.getJSObject());
    }

    /**
     * APIProperty: labelSymbolizer
     * {symbolizer} the symbolizer used to render labels
     */
    public void setLabelSymbolizer(TextSymbolizer text)
    {
        getJSObject().setProperty("labelSymbolizer", text.getJSObject());
    }

}
