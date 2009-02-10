package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.Options;
import com.eg.gwt.openLayers.client.util.JSObject;
import com.google.gwt.user.client.Element;

/**
 * Access the openlayers navtoolbar control.
 * 
 * @author Emily Gouge - Refractions Research
 *
 */
public class NavToolBar extends Control{

	protected NavToolBar(JSObject element) {
		super(element);
	}
    
	public NavToolBar(){
		this(NavToolBarImpl.create());
	}
    
	public NavToolBar(Element div){
		super((JSObject)null);
		Options options = new Options();
		options.setAttribute("div", div);
		setJSObject(NavToolBarImpl.create(options.getJSObject()));
	}

	public NavToolBar(Options options) {
		this(NavToolBarImpl.create(options.getJSObject()));
	}

}
