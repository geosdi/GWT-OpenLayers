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

/**
 * Represents a longitude, latitude coordinate pair.
 * 
 * Longitude: east-west geographic coordinate.
 * Latitude: south-north geographic coordinate. 
 * 
 * @author Erdem Gunay
 *
 */
public class LonLat extends OpenLayersObjectWrapper {

	protected LonLat(JSObject element) {
		super(element);
	}

	public static LonLat narrowToLonLat(JSObject element)
	{
		return (element == null)?null:new LonLat(element);
	}
	
	public LonLat(double lon, double lat) {
		this (LonLatImpl.create(lon, lat));
	}
	
	public double lon() {
		return LonLatImpl.lon(getJSObject());
	}

	public double lat() {
		return LonLatImpl.lat(getJSObject());
	}
	
	public void transform(String src, String dst){
		LonLatImpl.transform(getJSObject(), src, dst);
	}
	
}
