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
package org.gwtopenmaps.openlayers.client.tile;

import org.gwtopenmaps.openlayers.client.layer.Params;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Niels Meijer
 *
 */
public class TileOptions extends Params {

	protected TileOptions(JSObject jsObject) {
		super(jsObject);
	}

	public TileOptions() {
		this(JSObject.createJSObject());
	}

	/**
	 * If set, requests that would result in GET urls with more characters than the number provided will be made using form-encoded HTTP POST.
	 * It is good practice to avoid urls that are longer than 2048 characters.
	 * @param maxGetUrlLength The max length of an URL, otherwise a POST is used.
	 */
    public void setMaxGetUrlLength(int maxGetUrlLength)
    {
        setParameter("maxGetUrlLength", Integer.toString(maxGetUrlLength));
    }
}