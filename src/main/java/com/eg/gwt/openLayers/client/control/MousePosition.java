package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;
import com.eg.gwt.openLayers.client.util.Options;

/**
 * Displays the geographic coordinates of the position of the mouse cursor.
 *
 * To display the coordinates outside the map, the HTML element where the
 * coordinates should be displayed should be passed to the constructor.
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur
 * @since GWT-OL 0.2
 */
public class MousePosition extends Control {

	protected MousePosition(JSObject element) {
		super(element);
	}

	public MousePosition() {
		this(MousePositionImpl.create());
	}
/*
//TODO: move to MousePositionOptions
	public MousePosition(Element divId) {
		super((JSObject)null);
		Options options = new Options();
		options.getJSObject().setProperty("element", divId);
		setJSObject(MousePositionImpl.create(options.getJSObject()));
	}
*/
	/**
	 * Supported for backward compatibility.
	 */
	public MousePosition(Options options) {
		this(MousePositionImpl.create(options.getJSObject()));
	}

	/**
	 *
	 * @param options -
	 * @since GWT-OL 0.4
	 */
	public MousePosition(MousePositionOptions options) {
		this(MousePositionImpl.create(options.getJSObject()));
	}


}
