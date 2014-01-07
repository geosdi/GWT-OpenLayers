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
package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 *
 */
public class KMLImpl
{

    public static native JSObject create()
    /*-{
            return new $wnd.OpenLayers.Format.KML();
    }-*/;
    
    public static native JSObject create(JSObject formatOptions)
    /*-{
            return new $wnd.OpenLayers.Format.KML(formatOptions);
    }-*/;

    public static native JSObject read(JSObject kmlFormat, String kmlString) /*-{
        return kmlFormat.read(kmlString);
    }-*/;

    public static native String write(JSObject kmlFormat, JSObject feature, boolean pretty) /*-{
        return kmlFormat.write(feature, pretty);
    }-*/;

}
