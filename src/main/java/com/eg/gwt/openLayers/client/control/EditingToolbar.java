package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.layer.Vector;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class EditingToolbar extends Control{

	protected EditingToolbar(JSObject element){
		super(element);
	}

	public EditingToolbar(Vector vectorLayer){
		this(EditingToolbarImpl.create(vectorLayer.getJSObject()));
	}

	public EditingToolbar(Vector vectorLayer, EditingToolbarOptions options){
		this(EditingToolbarImpl.create(vectorLayer.getJSObject(), options.getJSObject()));
	}
}
