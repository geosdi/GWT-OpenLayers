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
