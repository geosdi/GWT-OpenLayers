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
package org.gwtopenmaps.openlayers.client.layer;

/**
 * @author Max Gensthaler
 */
public enum GoogleV3MapType {
	/** This map type shows Google Earth satellite images. */
	G_SATELLITE_MAP(GoogleV3MapTypeImpl.G_SATELLITE_MAP()),
	/** Normal street map type. */
	G_NORMAL_MAP(GoogleV3MapTypeImpl.G_NORMAL_MAP()),
	/** This map type transposes street maps and labels over satellite images. */
	G_HYBRID_MAP(GoogleV3MapTypeImpl.G_HYBRID_MAP()),
	/** A terrain map type. */
	G_TERRAIN_MAP(GoogleV3MapTypeImpl.G_TERRAIN_MAP());

	private final String type;

	private GoogleV3MapType(String type) {
		this.type = type;
	}

	/**
	 * Returns the type.
	 *
	 * @return the type
	 */
	public String getNativeType() {
		return type;
	}
}
