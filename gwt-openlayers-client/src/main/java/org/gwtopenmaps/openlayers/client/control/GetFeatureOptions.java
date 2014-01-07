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
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.filter.SpatialFilter;
import org.gwtopenmaps.openlayers.client.protocol.WFSProtocol;

public class GetFeatureOptions extends ControlOptions {

    public enum GetFeatureValueKey {

        ALT_KEY("altKey"),
        SHIFT_KEY("shiftKey"),
        CTRL_KEY("ctrlKey");
        //
        private String value;

        GetFeatureValueKey(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

    }

    public void setProtocol(WFSProtocol protocol) {
//              getJSObject().setProperty("protocol", createGetFromWMSLayerProtocol(layer.getJSObject()));
        getJSObject().setProperty("protocol", protocol.getJSObject());
    }

    /**
     * APIProperty: multipleKey {String} An event modifier ('altKey' or
     * 'shiftKey') that temporarily sets the <multiple> property to true.
     * Default is null.
     */
    public void setMultipleKey(GetFeatureValueKey key) {
        getJSObject().setProperty("multipleKey", key.toString());
    }

    /**
     * APIProperty: toggleKey {String} An event modifier ('altKey' or
     * 'shiftKey') that temporarily sets the <toggle> property to true. Default
     * is null.
     */
    public void setToggleKey(GetFeatureValueKey key) {
        getJSObject().setProperty("toggleKey", key.toString());
    }

    /**
     * APIProperty: multiple {Boolean} Allow selection of multiple geometries.
     * Default is false.
     */
    public void setMultiple(boolean multiple) {
        getJSObject().setProperty("multiple", multiple);
    }

    /**
     * APIProperty: click {Boolean} Use a click handler for
     * selecting/unselecting features. If both <click> and <box> are set to
     * true, the click handler takes precedence over the box handler if a box
     * with zero extent was selected. Default is true.
     */
    public void setClick(boolean click) {
        getJSObject().setProperty("click", click);
    }

    /**
     * APIProperty: single {Boolean} Tells whether select by click should select
     * a single feature. If set to false, all matching features are selected. If
     * set to true, only the best matching feature is selected. This option has
     * an effect only of the <click> option is set to true. Default is true.
     */
    public void setSingle(boolean single) {
        getJSObject().setProperty("single", single);
    }

    /**
     * APIProperty: clickout {Boolean} Unselect features when clicking outside
     * any feature. Applies only if <click> is true. Default is true.
     */
    public void setClickout(boolean clickout) {
        getJSObject().setProperty("clickout", clickout);
    }

    /**
     * APIProperty: toggle {Boolean} Unselect a selected feature on click.
     * Applies only if
     * <click> is true. Default is false.
     */
    public void setToggle(boolean toggle) {
        getJSObject().setProperty("toggle", toggle);
    }

    /**
     * APIProperty: clickTolerance {Integer} Tolerance for the filter query in
     * pixels. This has the same effect as the tolerance parameter on WMS
     * GetFeatureInfo requests. Will be ignored for box selections. Applies only
     * if
     * <click> or <hover> is true. Default is 5. Note that this not only affects
     * requests on click, but also on hover.
     */
    public void setClickTolerance(int clickTolerance) {
        getJSObject().setProperty("clickTolerance", clickTolerance);
    }

    /**
     * APIProperty: hover {Boolean} Send feature requests on mouse moves.
     * Default is false.
     */
    public void setHover(boolean hover) {
        getJSObject().setProperty("hover", hover);
    }

    /**
     * APIProperty: box {Boolean} Allow feature selection by drawing a box. If
     * set to true set <click> to false to disable the click handler and rely on
     * the box handler only, even for "zero extent" boxes. See the description
     * of the <click> option for additional information. Default is false.
     */
    public void setBox(boolean box) {
        getJSObject().setProperty("box", box);
    }

    /**
     * APIProperty: maxFeatures {Integer} Maximum number of features to return
     * from a query in single mode if supported by the <protocol>. This set of
     * features is then used to determine the best match client-side. Default is
     * 10.
     */
    public void setMaxFeatures(int maxFeatures) {
        getJSObject().setProperty("maxFeatures", maxFeatures);
    }

    /**
     * Property: filterType {<String>} The type of filter to use when sending
     * off a request. Possible values:
     * OpenLayers.Filter.Spatial.<BBOX|INTERSECTS|WITHIN|CONTAINS>
     * Defaults to: OpenLayers.Filter.Spatial.BBOX
     */
    public void setFilterType(SpatialFilter filterType) {
        getJSObject().setProperty("filterType", filterType.getJSObject());
    }

}
