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

import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.event.MarkerBrowserEventListener;
import org.gwtopenmaps.openlayers.client.event.MarkerBrowserEventListener.MarkerBrowserEvent;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Erdem Gunay
 * @author Michel Vitor - Intec
 * @author Sandor Forrai
 */
public class Marker extends OpenLayersEObjectWrapper {

	protected Marker(JSObject element) {
		super(element);
	}

	public Marker(LonLat lonlat) {
		this(MarkerImpl.create(lonlat.getJSObject()));
	}

	public Marker(LonLat lonlat, Icon icon) {
		this(MarkerImpl.create(lonlat.getJSObject(), icon.getJSObject()));
	}

	public static Marker narrowToMarker(JSObject element) {
		return (element == null) ? null : new Marker(element);
	}

	public LonLat getLonLat() {
		return LonLat.narrowToLonLat(MarkerImpl.getLonLat(getJSObject()));
	}

	/**
	 * Method setLonlat Change the lonlat of Icon lonlat (LonLat) the position of this marker
	 */
	public void setLonLat(LonLat lonlat) {
		MarkerImpl.setLonLat(getJSObject(), lonlat.getJSObject());
	}

	public Icon getIcon() {
		return Icon.narrowToIcon(MarkerImpl.getIcon(getJSObject()));
	}

	/**
	 * Method: setIcon Change the icon image. icon (Icon) the image of icon
	 */
	public void setIcon(Icon icon) {
		MarkerImpl.setIcon(getJSObject(), icon.getJSObject());
	}

	/**
	 * Method setImageUrl Change the Url of Icon imageUrl (Url) the url of this marker
	 */
	public void setImageUrl(String imageUrl) {
		MarkerImpl.setImageUrl(getJSObject(), imageUrl);
	}

	public void addBrowserEventListener(String browserEvent, final MarkerBrowserEventListener listener) {
		eventListeners.addListener(this, listener, browserEvent, new EventHandler() {
			public void onHandle(EventObject eventObject) {
				MarkerBrowserEvent e = new MarkerBrowserEvent(eventObject);
				listener.onBrowserEvent(e);
			}
		});
	}

	public void moveTo(Pixel where) {
		MarkerImpl.moveTo(getJSObject(), where.getJSObject());
	}
}

