/**
 *
 *   Copyright 2013 sourceforge.
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

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * GetFeature implementation that gets Vector Features use WFS
 *
 * @author davek<at>komacke<dot>com
 *
 */
public class GetFeature extends Control {

    public static GetFeature narrowToGetFeature(JSObject getFeature) {
        return (getFeature == null) ? null : new GetFeature(getFeature);
    }

    protected GetFeature(JSObject element) {
        super(element);
    }

    public GetFeature() {
        this(GetFeatureImpl.create());
    }

    public GetFeature(GetFeatureOptions options) {
        this(GetFeatureImpl.create(options.getJSObject()));
    }

    public void setSelectVectorFeature(VectorFeature feature) {
        getJSObject().setProperty("select", feature.getJSObject());
    }

    public void unselectAll() {
        GetFeatureImpl.unselectAll(getJSObject());
    }

    public void selectBox(Bounds bounds) {
        GetFeatureImpl.selectBox(getJSObject(), bounds.getJSObject());
    }

    public Bounds getBounds() {
        return Bounds.narrowToBounds(GetFeatureImpl.getBounds(getJSObject()));
    }
}
