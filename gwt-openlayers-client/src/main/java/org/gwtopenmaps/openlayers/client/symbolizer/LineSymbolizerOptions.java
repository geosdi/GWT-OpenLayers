/**
 *
 */
package org.gwtopenmaps.openlayers.client.symbolizer;

/**
 * @author lorenzo
 *
 */
public class LineSymbolizerOptions extends SymbolizerOptions
{

    /**
    * APIProperty: strokeColor
    * {String} Color for line stroke.  This is a RGB hex value (e.g. "#ff0000"
    *     for red).
    */
    public void setStrokeColor(String color)
    {
        getJSObject().setProperty("strokeColor", color);
    }

    /**
     * APIProperty: strokeOpacity
     * {Number} Stroke opacity (0-1).
     */
    public void setStrokeOpacity(double opacity)
    {
        getJSObject().setProperty("strokeOpacity", opacity);
    }

    /**
     * APIProperty: strokeWidth
     * {Number} Pixel stroke width.
     */
    public void setStrokeWidth(int width)
    {
        getJSObject().setProperty("strokeWidth", width);
    }

    /**
     * APIProperty: strokeLinecap
     * {String} Stroke cap type ("butt", "round", or "square").
     */
    public void setStrokeLinecap(String linecap)
    {
        getJSObject().setProperty("strokeLinecap", linecap);
    }

    /**
     * Property: strokeDashstyle
     * {String} Stroke dash style according to the SLD spec. Note that the
     *     OpenLayers values for strokeDashstyle ("dot", "dash", "dashdot",
     *     "longdash", "longdashdot", or "solid") will not work in SLD, but
     *     most SLD patterns will render correctly in OpenLayers.
     */

    public void setStrokeDashstyle(String dashstyle)
    {
        getJSObject().setProperty("strokeDashstyle", dashstyle);
    }


}
