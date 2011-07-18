/**
 * 
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 * 
 */
public class ModifyFeature extends Control {
    public static final int RESHAPE = 1;
    public static final int RESIZE = 2;
    public static final int ROTATE = 4;
    public static final int DRAG = 8;

	public static final String CLASS_NAME = "OpenLayers.Control.ModifyFeature";

    protected ModifyFeature(JSObject modifyFeature) {
	super(modifyFeature);
    }

    public ModifyFeature(Vector vectorLayer) {
	this(ModifyFeatureImpl.create(vectorLayer.getJSObject()));
    }

    public ModifyFeature(Vector vectorLayer,
	    ModifyFeatureOptions modifyFeatureOptions) {
	this(ModifyFeatureImpl.create(vectorLayer.getJSObject(),
		modifyFeatureOptions.getJSObject()));
    }

    /**
	 *
	 */
    public interface OnModificationStartListener {
	void onModificationStart(VectorFeature vectorFeature);
    }

    public interface OnModificationListener {
	void onModification(VectorFeature vectorFeature);
    }

    public interface OnModificationEndListener {
	void onModificationEnd(VectorFeature vectorFeature);
    }

    /**
     * Set the mode of the ModifyFeature. Can accept more than one mode at same
     * time.
     * 
     * @param modes
     *            One or more modes to set to this ModifyFeature
     */
    public void setMode(int... modes) {

	int modeValue = 0;

	if (modes != null) {
	    for (int mode : modes) {
		modeValue |= mode;
	    }
	}

	this.getJSObject().setProperty("mode", modeValue);
    }
    
	/**
	 * Property: modified {Boolean} The currently selected feature has been
	 * modified.
	 */
	public boolean isSelectedFeatureModified() {
		return ModifyFeatureImpl.isSelectedFeatureModified(getJSObject());
	}

}
