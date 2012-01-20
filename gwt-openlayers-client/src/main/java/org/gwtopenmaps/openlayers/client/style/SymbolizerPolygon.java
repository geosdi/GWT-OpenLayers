package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Maciej Jezierski - Pinocchio
 * Create a symbolizer for rendering polygons.
 */

public class SymbolizerPolygon extends SymbolizerLine
{

    public SymbolizerPolygon()
    {
        super(SymbolizerPolygonImpl.create());
    }

    protected SymbolizerPolygon(JSObject object)
    {
        super(object);
    }

    public void setFillColor(String color)
    {
        SymbolizerPolygonImpl.setFillColor(this.getJSObject(), color);
    }

    public String getFillColor()
    {
        return SymbolizerPolygonImpl.getFillColor(this.getJSObject());
    }

    public void setFillOpacity(double opacity)
    {
        SymbolizerPolygonImpl.setFillOpacity(this.getJSObject(), opacity);
    }

    public double getFillOpacity()
    {
        return SymbolizerPolygonImpl.getFillOpacity(this.getJSObject());
    }
}
