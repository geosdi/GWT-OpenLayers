package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Rafael Ceravolo
 */
public class RendererOptions extends OpenLayersObjectWrapper {
	protected RendererOptions(JSObject element) {
		super(element);
	}

	public RendererOptions() {
		this(JSObject.createJSObject());

	}

	/**
	 * Whether to use yOrdering. If yOrdering is enabled, geometries with lower
	 * latitude will be draw on top of others geometries with bigger latitude.
	 * 
	 * @param yOrdering
	 *            The value of the property to set. Default is false.
	 */
	public void setYOrdering(boolean yOrdering) {
		this.getJSObject().setProperty("yOrdering", yOrdering);
	}

	/**
	 * Get the yOrdering property
	 * 
	 * @return The property value.
	 */
	public boolean getYOrdering() {
		return this.getJSObject().getPropertyAsBoolean("yOrdering");
	}

	/**
	 * Whether to use z-indexing. Will be ignored if yOrdering is set to true.
	 * 
	 * @param zIndexing
	 *            The value of the property to set. Default is false.
	 */
	public void setZIndexing(boolean zIndexing) {
		this.getJSObject().setProperty("zIndexing", zIndexing);
	}

	/**
	 * Get the yOrdering property
	 * 
	 * @return The property value
	 */
	public boolean getZIndexing() {
		return this.getJSObject().getPropertyAsBoolean("zIndexing");
	}
};
