/**
 *
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class OverviewMapOptions extends ControlOptions
{


    /**
     * If no layers are set at the construction of the {@link OverviewMap} control then
     * the base layer of the map to which the {@link OverviewMap} control instance is added
     * is used as layer in the overviewmap.
     *
     * The default behaviour does not work if base layer opacity is less than 1 (known issue?).
     *
     * @param layers
     */
    public void setLayers(Layer[] layers)
    {
        JObjectArray array = new JObjectArray(layers);
        getJSObject().setProperty("layers", array.getJSObject());
    }


}
