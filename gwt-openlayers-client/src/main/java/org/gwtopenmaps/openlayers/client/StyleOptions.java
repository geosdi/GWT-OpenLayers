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
package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 * Stores style options for the OpenLayersStyle class
 * @author Jon Britton, SpiffyMap Ltd (jonb@spiffymap.net)
 */
public class StyleOptions extends JSObjectWrapper {

	protected StyleOptions(JSObject jsObject) {
		super(jsObject);
	}

	public StyleOptions(){
		this(JSObject.createJSObject());
	}
    
    public void addContextStyleCallback(String id, ContextStyler styler) {
        JSObject context = getJSObject().getProperty("context");
        if (context == null) {
            getJSObject().setProperty("context", JSObject.createJSObject());
            context = getJSObject().getProperty("context");
        }
        context.setProperty(id, StyleOptionsImpl.createContextStylerCallback(styler));
    }
}
