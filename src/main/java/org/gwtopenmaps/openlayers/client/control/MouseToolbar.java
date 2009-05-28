package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Erdem Gunay
 *
 */
public class MouseToolbar extends Control {

	protected MouseToolbar(JSObject element) {
		super(element);
	}

	public MouseToolbar() {
		this(MouseToolbarImpl.create());
	}

	public MouseToolbar(MouseToolbarOptions options) {
		this(MouseToolbarImpl.create(options.getJSObject()));
	}
}
