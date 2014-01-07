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
package org.gwtopenmaps.openlayers.client.feature;

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.popup.Popup;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 * @author Lukas Johansson
 *
 */
public abstract class Feature extends OpenLayersObjectWrapper {

    protected Feature(JSObject element) {
        super(element);
    }

    public void destroy() {
        FeatureImpl.destroy(getJSObject());
    }

    /**
     * @return a generated ID. Prefer the use of <code>getFID</code>, which
     * supports an OGC standard.
     */
    public String getFeatureId() {
        return FeatureImpl.getFeatureId(getJSObject());
    }

    public String getFID() {
        return FeatureImpl.getFID(getJSObject());
    }

    public Popup createPopup(boolean closeBox) {
        JSObject popupObj = FeatureImpl.createPopup(this.getJSObject(), closeBox);

        return Popup.narrowToOpenLayersPopup(popupObj);
    }

    public LonLat getCenterLonLat() {
        return Bounds.narrowToBounds(FeatureImpl.getBounds(this.getJSObject())).getCenterLonLat();
    }

    public void setPopup(final Popup popup) {
        FeatureImpl.setPopup(this.getJSObject(),
                popup == null ? null : popup.getJSObject());
    }

    public Popup getPopup() {
        return Popup.narrowToOpenLayersPopup(FeatureImpl.getPopup(
                this.getJSObject()));
    }

    public void resetPopup() {
        FeatureImpl.resetPopup(this.getJSObject());
    }

    public void setStyle(Style newStyle) {
        FeatureImpl.setStyle(this.getJSObject(), newStyle.getJSObject());
    }

    public Style getStyle() {
        return Style.narrowToOpenLayersStyle(FeatureImpl.getStyle(
                this.getJSObject()));
    }

    public Layer getLayer() {
        return Layer.narrowToLayer(FeatureImpl.getLayer(getJSObject()));
    }
}
