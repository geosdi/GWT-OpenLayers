package org.gwtopenmaps.openlayers.client.control;


/**
 * Set topInUnits and topOutUnits to an empty String to hide top units and
 * set bottomInUnits and bottomOutUnits to an empty String to hide bottom units.
 *
 * @author Edwin Commandeur - Atlis EJS
 */
public class ScaleLineOptions extends ControlOptions
{

    /**
     *
     * In refers to ..?zoomed in?...
     *
     * @param units - Index into OpenLayers.INCHES_PER_UNIT hashtable,
     *  default is m.
     */
    public void setTopInUnits(String units)
    {
        getJSObject().setProperty("topInUnits", units);
    }

    /**
     * Out refers to ..?zoomed out?...
     *
     * @param units - Index into OpenLayers.INCHES_PER_UNIT hashtable,
     *  default is km.
     */
    public void setTopOutUnits(String units)
    {
        getJSObject().setProperty("topOutUnits", units);
    }

    /**
     *
     * In refers to ..?zoomed in?...
     *
     * @param units - Index into OpenLayers.INCHES_PER_UNIT hashtable,
     *  default is mi.
     */
    public void setBottomInUnits(String units)
    {
        getJSObject().setProperty("bottomInUnits", units);
    }

    /**
     *
     * Out refers to ..?zoomed out?...
     *
     * @param units - Index into OpenLayers.INCHES_PER_UNIT hashtable,
     *  default is ft.
     */
    public void setBottomOutUnits(String units)
    {
        getJSObject().setProperty("bottomOutUnits", units);
    }

}
