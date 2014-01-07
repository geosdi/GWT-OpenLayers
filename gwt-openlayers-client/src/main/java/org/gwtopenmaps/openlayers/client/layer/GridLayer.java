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

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * Wrapper of OpenLayers.Layer.Grid in OpenLayers. Renamed Grid to GridLayer in
 * order to avoid confusion around the generic term Grid.
 * 
* From OL API docs: Base class for layers that use a lattice of tiles.
 * 
* @author Edwin Commandeur - Atlis EJS
 * @author Michel Vitor A Rodrigues - Intec
 * 
*/
public class GridLayer extends HTTPRequestLayer {

    protected GridLayer(JSObject gridLayer) {
        super(gridLayer);
    }

    public GridLayer(String name, String url, WMSParams params,
            GridLayerOptions options) {

        this(GridLayerImpl.create(name, url, params.getJSObject(),
                options.getJSObject()));
    }

    public GridLayer(String name, String url, WMSParams params) {

        this(GridLayerImpl.create(name, url, params.getJSObject()));
    }

    /**
     * Gets the transition effect to use when the map is zoomed.
     *
     * @return transition effect
     */
    public TransitionEffect getTransitionEffect() {
        return TransitionEffect.fromValue(
                this.getJSObject().getPropertyAsString(
                        "transitionEffect"));
    }

    public GridLayer narrowToGridLayer(JSObject gridLayer) {
        return (gridLayer == null) ? null : new GridLayer(gridLayer);

    }

    public void setTitleSize(Integer tileSize) {
        GridLayerImpl.setTitleSize(getJSObject(), tileSize);
    }

    public void setSingleTile(boolean singleTile) {
        GridLayerImpl.setSingleTile(getJSObject(), singleTile);
    }

    public void setRatio(float ratio) {
        GridLayerImpl.setRatio(getJSObject(), ratio);
    }

    public void setBuffer(Integer buffer) {
        GridLayerImpl.setBuffer(getJSObject(), buffer);
    }

    public void setNumLoadingTiles(Integer numLoadingTiles) {
        GridLayerImpl.setNumLoadingTiles(getJSObject(), numLoadingTiles);
    }

    /**
     * Sets the transition effect to use when the map is zoomed. Two posible
     * values: "resize"	Existing tiles are resized on zoom to provide a visual
     * effect of the zoom having taken place immediately. As the new tiles
     * become available, they are drawn on top of the resized tiles (this is the
     * default setting). "map-resize"	Existing tiles are resized on zoom and
     * placed below the base layer. New tiles for the base layer will cover
     * existing tiles. This setting is recommended when having an overlay
     * duplicated during the transition is undesirable (e.g. street labels or
     * big transparent fills). null	No transition effect. Using "resize" on
     * non-opaque layers can cause undesired visual effects. Set
     * transitionEffect to null in this case.
     *
     * @param transition transition effect
     */
    public void setTransitionEffect(TransitionEffect transition) {
        this.getJSObject().setProperty("transitionEffect", transition.toString());
    }

}
