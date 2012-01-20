package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Maciej Jezierski - Pinocchio
 * Create a symbolizer for rendering lines.
 */

public class SymbolizerLine extends Symbolizer
{

    public SymbolizerLine()
    {
        super(SymbolizerLineImpl.create());
    }

    protected SymbolizerLine(JSObject object)
    {
        super(object);
    }

    public void setStorkeColor(String color)
    {
        SymbolizerLineImpl.setStorkeColor(this.getJSObject(), color);
    }

    public String getStorkeColor()
    {
        return SymbolizerLineImpl.getStorkeColor(this.getJSObject());
    }

    public void setStorkeOpacity(double opacity)
    {
        SymbolizerLineImpl.setStorkeOpacity(this.getJSObject(), opacity);
    }

    public double getStorkeOpacity()
    {
        return SymbolizerLineImpl.getStorkeOpacity(this.getJSObject());
    }

    public void setStorkeWidth(int width)
    {
        SymbolizerLineImpl.setStorkeWidth(this.getJSObject(), width);
    }

    public int getStorkeWidth()
    {
        return SymbolizerLineImpl.getStorkeWidth(this.getJSObject());
    }

    /**
     *
     * @param linecap Stroke cap type (â€œbuttâ€?, â€œroundâ€?, or â€œsquareâ€?).
     */
    public void setLinecap(String linecap)
    {
        SymbolizerLineImpl.setLinecap(this.getJSObject(), linecap);
    }

    public String getLinecap()
    {
        return SymbolizerLineImpl.getLinecap(this.getJSObject());
    }


    /**
     * Stroke dash style according to the SLD spec.  Note that the OpenLayers values for strokeDashstyle (â€œdotâ€?, â€œdashâ€?, â€œdashdotâ€?, â€œlongdashâ€?, â€œlongdashdotâ€?, or â€œsolidâ€?) will not work in SLD, but most SLD patterns will render correctly in OpenLayers
     * @param dashstyle
     */
    public void setDashstyle(String dashstyle)
    {
        SymbolizerLineImpl.setDashstyle(this.getJSObject(), dashstyle);
    }

    public String getDashstyle()
    {
        return SymbolizerLineImpl.getDashstyle(this.getJSObject());
    }
}
