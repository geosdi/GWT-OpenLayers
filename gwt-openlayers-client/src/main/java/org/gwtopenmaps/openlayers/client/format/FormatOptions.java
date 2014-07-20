/**
 *
 * Copyright 2014 sourceforge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 *
 */
public class FormatOptions extends JSObjectWrapper {

    protected FormatOptions(JSObject jsObject) {
        super(jsObject);
    }

    public FormatOptions() {
        this(JSObject.createJSObject());
    }

    /**
     * APIProperty: internalProjection {@link Projection}. When passed a
     * externalProjection and internalProjection, the format will reproject the
     * geometries it reads or writes. The internalProjection is the projection
     * used by the geometries which are returned by read or which are passed
     * into write. In order to reproject, a projection transformation function
     * for the specified projections must be available. This support may be
     * provided via proj4js or via a custom transformation function. See
     * {<OpenLayers.Projection.addTransform>} for more information on custom
     * transformations.
     *
     * @param projection
     */
    public void setInternalProjection(Projection projection) {
        getJSObject().setProperty("internalProjection", projection.getJSObject());
    }

    /**
     * APIProperty: externalProjection {@link Projection}. When passed a
     * externalProjection and internalProjection, the format will reproject the
     * geometries it reads or writes. The externalProjection is the projection
     * used by the content which is passed into read or which comes out of
     * write. In order to reproject, a projection transformation function for
     * the specified projections must be available. This support may be provided
     * via proj4js or via a custom transformation function. See
     * {<OpenLayers.Projection.addTransform>} for more information on custom
     * transformations.
     *
     * @param projection
     */
    public void setExternalProjection(Projection projection) {
        getJSObject().setProperty("externalProjection", projection.getJSObject());
    }

    /**
     * APIProperty: keepData {Object} Maintain a reference (data) to the most
     * recently read data. Default is false.
     *
     * @param keepData
     */
    public void setkeepData(Boolean keepData) {
        getJSObject().setProperty("keepData", keepData);
    }

}
