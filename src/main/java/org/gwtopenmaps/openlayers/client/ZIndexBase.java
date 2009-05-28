package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 * <p>
 * Provides the base z-index for baselayers, overlays
 * features, popups and controls.
 * </p>
 * <p>
 * todo: Explain z-index concept here.
 * </p>
 *
 * Defaults taken from OL 2.7;
 *
 * @since GWT-OL 0.4
 * @author Edwin Commandeur - Atlis Information Systems
 */
public class ZIndexBase extends JSObjectWrapper {

	private final String BASE_LAYER_Z_INDEX_BASE = "BaseLayer";
	private final String OVERLAY_Z_INDEX_BASE = "Overlay";
	private final String FEATURE_Z_INDEX_BASE = "Feature";
	private final String POPUP_Z_INDEX_BASE = "Popup";
	private final String CONTROL_Z_INDEX_BASE = "Control";

	protected ZIndexBase(JSObject jsObject) {
		super(jsObject);
	}

	//Ideally this is initialized from OpenLayers, but it seems that
	// would require instantiating OpenLayers.Map to copy default Z_INDEX_BASE
	public ZIndexBase(){
		this(JSObject.createJSObject());
		setForBaseLayers(100);
		setForOverlays(325);
		setForFeatures(725);
		setForPopups(750);
		setForControls(1000);
	}

	public ZIndexBase(int baseLayerZIndexBase,
			int overlayZIndexBase,
			int featureZIndexBase,
			int popupZIndexBase,
			int controlZIndexBase){
		this(JSObject.createJSObject());
		setForBaseLayers(baseLayerZIndexBase);
		setForOverlays(overlayZIndexBase);
		setForFeatures(featureZIndexBase);
		setForPopups(popupZIndexBase);
		setForControls(controlZIndexBase);
	}

	/**
	 * Default base z-index for base layers is 100 (in OL 2.7).
	 */
	public void setForBaseLayers(int zIndexBase){
		getJSObject().setProperty(BASE_LAYER_Z_INDEX_BASE, zIndexBase);
	}

	/**
	 * Default base z-index for overlays is 325 (in OL 2.7).
	 */
	public void setForOverlays(int zIndexBase){
		getJSObject().setProperty(OVERLAY_Z_INDEX_BASE, zIndexBase);
	}

	/**
	 * Default base z-index for features is 725 (in OL 2.7).
	 */
	public void setForFeatures(int zIndexBase){
		getJSObject().setProperty(FEATURE_Z_INDEX_BASE, zIndexBase);
	}

	/**
	 * Default base z-index for popups is 750 (in OL 2.7).
	 */
	public void setForPopups(int zIndexBase){
		getJSObject().setProperty(POPUP_Z_INDEX_BASE, zIndexBase);
	}

	/**
	 * Default base z-index for controls is 1000 (in OL 2.7).
	 */
	public void setForControls(int zIndexBase){
		getJSObject().setProperty(CONTROL_Z_INDEX_BASE, zIndexBase);
	}
}
