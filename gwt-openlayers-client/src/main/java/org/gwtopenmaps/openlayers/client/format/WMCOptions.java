package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.Map;


public class WMCOptions extends FormatOptions
{

    // TODO: create constructors that take map or id

    /**
     * Use this method to merge ... with the map
     * or
     * use setMapDomElementId to create a new map in that dom element.
     *
     *
     * @param map - the map to merge map elements with that are created
     *   on the basis of the WMC document
     */
    public void setMap(Map map)
    {
        getJSObject().setProperty("map", map.getJSObject());
    }

    /**
     *
     * @param id - the dom element id where to put the map created
     *   from reading a WMC document
     */
    public void setMapDomElementId(String id)
    {
        getJSObject().setProperty("map", id);
    }
}
