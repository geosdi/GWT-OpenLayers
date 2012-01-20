package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * Options which control the behavior of the RegularPolygonHandler
 * @author rhs - Roland.Schweitzer@noaa.gov
 *
 */
public class RegularPolygonHandlerOptions extends HandlerOptions
{

    protected RegularPolygonHandlerOptions(JSObject jsObject)
    {
        super(jsObject);
    }

    public RegularPolygonHandlerOptions()
    {
        this(JSObject.createJSObject());
    }

    /**
     *
     * @param sides Number of sides for the regular polygon.  Needs to be greater than 2.  Defaults to 4.
     */
    public void setSides(int sides)
    {
        getJSObject().setProperty("sides", sides);
    }

    /**
     *
     * @param radius Optional radius in map units of the regular polygon.  If this is
     *     set to some non-zero value, a polygon with a fixed radius will be
     *     drawn and dragged with mose movements.  If this property is not
     *     set, dragging changes the radius of the polygon.  Set to null by
     *     default.

     */
    public void setRadius(float radius)
    {
        getJSObject().setProperty("radius", radius);
    }

    /**
     *
     * @param snapAngle If set to a non-zero value, the handler will snap the polygon
     *     rotation to multiples of the snapAngle.  Value is an angle measured
     *     in degrees counterclockwise from the positive x-axis.
     */
    public void setSnapAngle(float snapAngle)
    {
        getJSObject().setProperty("snapAngle", snapAngle);
    }

    /**
     *   @param snapToggle If set, snapToggle is checked on mouse events and will set
     *     the snap mode to the opposite of what it currently is.  To disallow
     *     toggling between snap and non-snap mode, set freehandToggle to
     *     null.  Acceptable toggle values are 'shiftKey', 'ctrlKey', and
     *     'altKey'. Snap mode is only possible if this.snapAngle is set to a
     *     non-zero value.
     */
    /**
     *
     */
    public void setSnapToggle(String snapToggle)
    {
        getJSObject().setProperty("snapToggle", snapToggle);
    }

    /**
     * @param persist Leave the feature rendered until clear is called.  Default
     *     is false.  If set to true, the feature remains rendered until
     *     clear is called, typically by deactivating the handler or starting
     *     another drawing.
     */
    public void setPersist(boolean persist)
    {
        getJSObject().setProperty("persist", persist);
    }

    /**
     *  @param irregular Draw an irregular polygon instead of a regular polygon.
     *     Default is false.  If true, the initial mouse down will represent
     *     one corner of the polygon bounds and with each mouse movement, the
     *     polygon will be stretched so the opposite corner of its bounds
     *     follows the mouse position.  This property takes precedence over
     *     the radius property.  If set to true, the radius property will
     *     be ignored.
     */
    public void setIrregular(boolean irregular)
    {
        getJSObject().setProperty("irregular", irregular);
    }

}
