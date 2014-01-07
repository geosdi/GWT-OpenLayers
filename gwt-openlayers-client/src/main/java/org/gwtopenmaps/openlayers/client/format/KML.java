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

import org.gwtopenmaps.openlayers.client.feature.Feature;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * Brief explanation of Keyhole Markup Language (KML) vector format here.
 *
 * Reference to KML specification. KML 2.0 is OGC standard.
 *
 * See http://www.ogc.org/
 *
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 *
 */
public class KML extends VectorFormat {

    protected KML(JSObject kmlFormat) {
        super(kmlFormat);
    }

    public KML() {
        this(KMLImpl.create());
    }

    public KML(FormatOptions formatOptions) {
        super(KMLImpl.create(formatOptions.getJSObject()));
    }

    public String write(Feature features,
            boolean pretty) {
        return KMLImpl.write(this.getJSObject(), features.getJSObject(), pretty);
    }

    public void setExtractStyles(boolean b) {
        getJSObject().setProperty("extractStyles", b);
    }

    public void setExtractAttributes(boolean b) {
        getJSObject().setProperty("extractAttributes", b);
    }

    public void setMaxDepth(int n) {
        getJSObject().setProperty("maxDepth", n);
    }
}
