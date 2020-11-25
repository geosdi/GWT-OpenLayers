/*
 *
 *   Copyright 2015 GWT OpenLayers Team.
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
package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class EventObjectImpl
{

    public static native JSObject getElement(JSObject eventObject) /*-{
        return (eventObject.element)?(eventObject.element):null;
    }-*/;

    public static native String getType(JSObject eventObject) /*-{
        return (eventObject.type)?(eventObject.type):null;
    }-*/;

    public static native JSObject getObject(JSObject eventObject) /*-{
        return (eventObject.object)?(eventObject.object):null;
    }-*/;

}
