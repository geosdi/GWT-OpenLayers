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
package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 * @author T.Desjardins SRP
 *
 */
public class RefreshStrategyOptions extends JSObjectWrapper {

	protected RefreshStrategyOptions(JSObject jsObject) {
		super(jsObject);
	}	
	
	public  RefreshStrategyOptions() {
		this(JSObject.createJSObject());
	}
	
	public void setForce(boolean force){
		getJSObject().setProperty("force", force);
	}
}
