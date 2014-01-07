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

import java.util.Set;

import org.gwtopenmaps.openlayers.client.event.EventListener;
import org.gwtopenmaps.openlayers.client.event.EventListenerCollection;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * Wrapper object for OpenLayer objects.
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur
 * 
 */
public class OpenLayersEObjectWrapper extends OpenLayersObjectWrapper {
   
	protected EventListenerCollection eventListeners = new EventListenerCollection();

	protected OpenLayersEObjectWrapper(JSObject openLayersObject) {
		super(openLayersObject);
	}

	public static OpenLayersEObjectWrapper narrowToOpenLayersEObjectWrapper(JSObject element) {
		return (element == null)?null: new OpenLayersEObjectWrapper(element);
	}

	public void removeListener(EventListener listener){
		eventListeners.removeListener(this, listener);
	};

	public Set<EventListener> getListeners(){
		return eventListeners.getListeners();
	}
}
