/*
 * Copyright 2014 geoSDI.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtopenmaps.openlayers.client.format.GML.Base;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class Base extends JSObjectWrapper {

    protected Base(JSObject jsObject) {
        super(jsObject);
    }

    /**
     * There is no no-argument constructor for this class. The unique
     * constructor takes arguments that are absolutely required for the GML
     * parser to work.
     *
     * @param featureNS Feature namespace. For example :
     * "http://www.openplans.org/topp"
     * @param featureType Local (without prefix) feature typeName. For example :
     * "states"
     * @author Mikael Couzic
     */
    public Base(String featureNS, String featureType) {
        this(JSObject.createJSObject());
        setFeatureNS(featureNS);
        setFeatureType(featureType);
    }

    /**
     * APIProperty: featureNS {String} The feature namespace. Must be set in the
     * options at construction.
     *
     * @param featureNS
     */
    public final void setFeatureNS(String featureNS) {
        getJSObject().setProperty("featureNS", featureNS);
    }

    public final void setFeatureType(String featureType) {
        getJSObject().setProperty("featureType", featureType);
    }

    /**
     * APIProperty: geometry {String} Name of geometry element. Defaults to
     * "geometry". If null, it will be set on read when the first geometry is
     * parsed.
     *
     * @param geometryName
     */
    public void setGeometryName(String geometryName) {
        getJSObject().setProperty("geometryName", geometryName);
    }

    /**
     * APIProperty: extractAttributes {Boolean} Extract attributes from GML.
     * Default is true.
     *
     * @param extractAttributes
     */
    public void setExtractAttributes(Boolean extractAttributes) {
        getJSObject().setProperty("extractAttributes",
                extractAttributes);
    }

    /**
     * APIProperty: srsName {@link String} URI for spatial reference system.
     * This is optional for single part geometries and mandatory for collections
     * and multis. If set, the srsName attribute will be written for all
     * geometries. Default is null.
     *
     * @param srsName
     */
    public void setSrsName(String srsName) {
        getJSObject().setProperty("srsName", srsName);
    }

    /**
     * APIProperty: xy {@link Boolean} Order of the GML coordinate true:(x,y) or
     * false:(y,x) Changing is not recommended, a new Format should be
     * instantiated.
     * 
     * @param xy
     */
    public void setXY(Boolean xy) {
        getJSObject().setProperty("xy", xy);
    }

}
