/**
 *
 *   Copyright 2014 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.Pixel;
import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JStringArray;


/**
 * @author Michel Vitor A Rodrigues - Intec
 */
public class ArcGIS93Rest extends GridLayer
{

    protected ArcGIS93Rest(JSObject element)
    {
        super(element);
    }

    /**
     * Constructor: ArcGIS93Rest
     * Create a new ArcGIS93Rest layer object.
     *
     * Example:
     * (code)
     * ArcGIS93Rest arcGIS93Rest = new ArcGIS93Rest("MyName",
     *                                    "http://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Specialty/ESRI_StateCityHighway_USA/MapServer/export",
     *                                    WMSParams,ArcGIS93RestOptions
     *                                    );
     * (end)
     *
     * Parameters:
     * name - {String} A name for the layer
     * url - {String} Base url for the ArcGIS server REST service
     * options - {Object} An object with key/value pairs representing the
     *                    options and option values.
     * Valid Options:
     *        format: {String} MIME type of desired image type.
     *        layers: {String} Comma-separated list of layers to display.
     *        srs: {String} Projection ID.
     */

    public ArcGIS93Rest(String name, String url, WMSParams params,
        ArcGIS93RestOptions options)
    {
        this(ArcGIS93RestImpl.create(name, url, params.getJSObject(), options.getJSObject()));
    }

    /**
     * Constructor: ArcGIS93Rest
     * Create a new ArcGIS93Rest layer object.
     *
     * Example:
     * (code)
     * ArcGIS93Rest arcGIS93Rest = new ArcGIS93Rest("MyName",
     *                                    "http://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Specialty/ESRI_StateCityHighway_USA/MapServer/export",
     *                                    WMSParams
     *                                    );
     * (end)
     *
     * Parameters:
     * name - {String} A name for the layer
     * url - {String} Base url for the ArcGIS server REST service
     */
    public ArcGIS93Rest(String name, String url, WMSParams params)
    {

        this(ArcGIS93RestImpl.create(name, url, params.getJSObject()));
    }

    /**
     * Constructor: ArcGIS93Rest
     * Create a new ArcGIS93Rest layer object.
     *
     * Example:
     * (code)
     * ArcGIS93Rest arcGIS93Rest = new ArcGIS93Rest("MyName",
     *                                    "http://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Specialty/ESRI_StateCityHighway_USA/MapServer/export",
     *                                    WMSParams
     *                                    );
     * (end)
     *
     * Parameters:
     * name - {String} A name for the layer
     * vetor url[] - {String} Base url for the ArcGIS server REST service
     * options - {Object} An object with key/value pairs representing the
     *                    options and option values.
     * Valid Options:
     *        format: {String} MIME type of desired image type.
     *        layers: {String} Comma-separated list of layers to display.
     *        srs: {String} Projection ID.
     */
    public ArcGIS93Rest(String name, String[] urls, WMSParams params)
    {
        this(ArcGIS93RestImpl.create(name, new JStringArray(urls).getJSObject(), params.getJSObject()));
    }

    /**
     * Constructor: ArcGIS93Rest
     * Create a new ArcGIS93Rest layer object.
     *
     * Example:
     * (code)
     * ArcGIS93Rest arcGIS93Rest = new ArcGIS93Rest("MyName",
     *                                    "http://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Specialty/ESRI_StateCityHighway_USA/MapServer/export",
     *                                    WMSParams
     *                                    );
     * (end)
     *
     * Parameters:
     * name - {String} A name for the layer
     * vetor url[] - {String} Base url for the ArcGIS server REST service
     *
     *
     */
    public ArcGIS93Rest(String name, String[] urls, WMSParams params, WMSOptions layerParams)
    {
        this(ArcGIS93RestImpl.create(name, new JStringArray(urls).getJSObject(), params.getJSObject(), layerParams.getJSObject()));
    }

    public ArcGIS93Rest narrowToArcGIS93Rest(JSObject arcgis93Rest)
    {
        return (arcgis93Rest == null) ? null : new ArcGIS93Rest(arcgis93Rest);
    }

    /**
     * APIProperty: isBaseLayer
     * {Boolean} Default is true for ArcGIS93Rest layer
     */
    public void setIsBaseLayer(boolean isBaseLayer)
    {
        ArcGIS93RestImpl.setIsBaseLayer(getJSObject(), isBaseLayer);
    }

    /**
     * Method: destroy
     * Destroy this layer
     */
    public void destroy()
    {
        ArcGIS93RestImpl.destroy(getJSObject());
    }

    /**
     * Method: clone
     * Create a clone of this layer
     *
     * Returns:
     * {<ArcGIS93Rest>} An exact clone of this layer
     */
    public ArcGIS93Rest clone(ArcGIS93Rest obj)
    {
        return new ArcGIS93Rest(ArcGIS93RestImpl.clone(getJSObject(), obj.getJSObject()));
    }

    /**
     * Method: getURL
     * Return an image url this layer.
     *
     * Parameters:
     * bounds - {<Bounds>} A bounds representing the bbox for the
     *                                request.
     *
     * Returns:
     * {String} A string with the map image's url.
     */
    public String getURL(Bounds bounds)
    {
        return ArcGIS93RestImpl.getURL(getJSObject(), bounds.getJSObject());
    }

    /**
     * Method: setLayerFilter
     * addTile creates a tile, initializes it, and adds it to the layer div.
     *
     * Parameters:
     * id - {String} The id of the layer to which the filter applies.
     * queryDef - {String} A sql-ish query filter, for more detail see the ESRI
     *                     documentation at http://sampleserver1.arcgisonline.com/ArcGIS/SDK/REST/export.html
     */
    public void setLayerFilter(String id, String queryDef)
    {
        ArcGIS93RestImpl.setLayerFilter(getJSObject(), id, queryDef);
    }

    /**
     * Method: clearLayerFilter
     * Clears layer filters, either from a specific layer,
     * or all of them.
     *
     * Parameters:
     * id - {String} The id of the layer from which to remove any
     *               filter.  If unspecified/blank, all filters
     *               will be removed.
     */
    public void clearLayerFilter(String id)
    {
        ArcGIS93RestImpl.clearLayerFilter(getJSObject(), id);
    }

    /**
     * APIMethod: mergeNewParams
     * Catch changeParams and uppercase the new params to be merged in
     *     before calling changeParams on the super class.
     *
     *     Once params have been changed, the tiles will be reloaded with
     *     the new parameters.
     *
     * Parameters:
     * newParams - {Object} Hashtable of new params to use
     */
    public boolean mergeNewParams(Params params)
    {
        return ArcGIS93RestImpl.mergeNewParams(getJSObject(), params.getJSObject());
    }

    /**
     * Method: addTile
     * addTile creates a tile, initializes it, and adds it to the layer div.
     *
     * Parameters:
     * bounds - {<Bounds>}
     * position - {<Pixel>}
     *
     * Returns:
     * {<Image>} The added OpenLayers.Tile.Image
     */
    public void addTile(Bounds bounds, Pixel position)
    {
        ArcGIS93RestImpl.addTile(getJSObject(), bounds.getJSObject(), position.getJSObject());
    }

    public int getNumLoadingTiles()
    {
        return WMSImpl.getNumLoadingTiles(this.getJSObject());
    }

}
