package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.Projection;

/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Jon Britton - SpiffyMap Ltd.
 */
public class ArgParserOptions extends ControlOptions
{
    /**
     * Projection used when reading the coordinates from the URL, requires proj4js support.
     * 
     * This will reproject the map coordinates from the URL into the map’s projection. If 
     * you are using this functionality, be aware that any permalink which is added to the 
     * map will determine the coordinate type which is read from the URL, which means you 
     * should not add permalinks with different displayProjections to the same map.
     * (from OL docs)
     * @param displayProjection 
     */
    public void setDisplayProjection(Projection displayProjection) {
        getJSObject().setProperty("displayProjection", displayProjection.getJSObject());
    }

}
