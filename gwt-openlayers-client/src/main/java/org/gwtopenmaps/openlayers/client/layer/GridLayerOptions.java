package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.Size;
import org.gwtopenmaps.openlayers.client.tile.TileOptions;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 *
 */
public class GridLayerOptions extends HTTPRequestLayerOptions {

    public GridLayerOptions() {
    }

    protected GridLayerOptions(JSObject jsObject) {
        super(jsObject);
    }

    public final void setTileSize(Size size) {
        getJSObject().setProperty("tileSize", size.getJSObject());
    }

    /**
     * For tiled layers the buffer size can be set.
     *
     * The default buffer is 2.
     */
    public void setBuffer(int buffer) {
        getJSObject().setProperty("buffer", buffer);
    }

    public void setTileOptions(TileOptions value) {
        getJSObject().setProperty("tileOptions", value.getJSObject());
    }
}
