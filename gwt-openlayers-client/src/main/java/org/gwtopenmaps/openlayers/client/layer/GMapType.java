package org.gwtopenmaps.openlayers.client.layer;

/**
 * @author Max Gensthaler
 */
public enum GMapType {
	/** This map type shows Google Earth satellite images. */
	G_SATELLITE_MAP(GMapTypeImpl.G_SATELLITE_MAP()),
	/** Normal street map type. */
	G_NORMAL_MAP(GMapTypeImpl.G_NORMAL_MAP()),
	/** This map type transposes street maps and labels over satellite images. */
	G_HYBRID_MAP(GMapTypeImpl.G_HYBRID_MAP()),
	/** A terrain map type. */
	G_TERRAIN_MAP(GMapTypeImpl.G_TERRAIN_MAP());

	private final String type;

	private GMapType(String type) {
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
