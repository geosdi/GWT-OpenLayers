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
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JStringArray;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class WMTSOptions extends GridLayerOptions {

    public enum RequestEncoding {

        KVP, REST;
    }

    /**
     *
     * <p>Required configuration properties: </p>
     * <ul>
     * <li>url - {String} The base url for the </li>
     * <li>layer - {String} The layer identifier.</li>
     * <li>style - {String} The layer style identifier.</li>
     * <li>matrixSet - {String} The tile matrix set identifier.</li>
     * </ul>
     */
    public WMTSOptions(String url, String layer, String style,
            String matrixSet) {
        super();
        setUrl(url);
        setLayer(layer);
        setStyle(style);
        setMatrixSet(matrixSet);
    }

    protected WMTSOptions(JSObject jsObject) {
        super(jsObject);
    }

    protected final void setUrl(String url) {
        getJSObject().setProperty("url", url);
    }

    protected final void setLayer(String layer) {
        getJSObject().setProperty("layer", layer);
    }

    protected final void setStyle(String style) {
        getJSObject().setProperty("style", style);
    }

    protected final void setMatrixSet(String matrixSet) {
        getJSObject().setProperty("matrixSet", matrixSet);
    }

    /**
     * APIProperty: requestEncoding {String} Request encoding. Can be "REST" or
     * "KVP". Default is "KVP".
     */
    public void setRequestEncoding(RequestEncoding requestEncoding) {
        getJSObject().setProperty("requestEncoding", requestEncoding.name());
    }

    /**
     * APIProperty: tileOrigin {<OpenLayers.LonLat>} The top-left corner of the
     * tile matrix in map units. If the tile origin for each matrix in a set is
     * different, the <matrixIds> should include a topLeftCorner property. If
     * not provided, the tile origin will default to the top left corner of the
     * layer <maxExtent>.
     */
    public void setTileOrigin(LonLat tileOrigin) {
        getJSObject().setProperty("tileOrigin", tileOrigin.getJSObject());
    }

    /**
     * APIProperty: tileFullExtent {<OpenLayers.Bounds>} The full extent of the
     * tile set. If not supplied, the layer's <maxExtent> property will be used.
     */
    public void setTileFullExtent(Bounds tileFullExtent) {
        getJSObject().setProperty("tileFullExtent", tileFullExtent.getJSObject());
    }

    /**
     * APIProperty: formatSuffix {String} For REST request encoding, an image
     * format suffix must be included in the request. If not provided, the
     * suffix will be derived from the <format> property.
     */
    public void setFormatSuffix(String formatSuffix) {
        getJSObject().setProperty("formatSuffix", formatSuffix);
    }

    public void setMatrixIds(String[] ids) {
        JStringArray a = JStringArray.create(ids);
        getJSObject().setProperty("matrixIds", a.getJSObject());
    }

    /**
     * APIProperty: zoomOffset {Number} If your cache has more levels than you
     * want to provide access to with this layer, supply a zoomOffset. This zoom
     * offset is added to the current map zoom level to determine the level for
     * a requested tile. For example, if you supply a zoomOffset of 3, when the
     * map is at the zoom 0, tiles will be requested from level 3 of your cache.
     * Default is 0 (assumes cache level and map zoom are equivalent).
     * Additionally, if this layer is to be used as an overlay and the cache has
     * fewer zoom levels than the base layer, you can supply a negative
     * zoomOffset. For example, if a map zoom level of 1 corresponds to your
     * cache level zero, you would supply a -1 zoomOffset (and set the
     * maxResolution of the layer appropriately). The zoomOffset value has no
     * effect if complete matrix definitions (including scaleDenominator) are
     * supplied in the <matrixIds> property. Defaults to 0 (no zoom offset).
     */
    public void setZoomOffset(int zoomOffset) {
        getJSObject().setProperty("zoomOffset", zoomOffset);
    }
    
    /** 
     * APIProperty: format
     * {String} The image MIME type.  Default is "image/jpeg".
     */
    public void setFormat(String format) {
        getJSObject().setProperty("format", format);
    }

}
