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
package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 *
 */
public class PointHandler extends Handler {

    public static PointHandler narrowToHandler(JSObject element) {
        return (element == null) ? null : new PointHandler(element);
    }

    protected PointHandler(JSObject element) {
        super(element);
    }

    public PointHandler() {
        this(PointHandlerImpl.create());
    }

    public void setStyle(Style s) {
        PointHandlerImpl.setStyle(getJSObject(), s.getJSObject());
    }

}
