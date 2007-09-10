package com.eg.gwt.openLayers.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class MapWidget extends Widget {

	private static VerticalPanel hiddenPanel;
	
	private Map map;
	private MapOptions options;
	
	public MapWidget(String width, String height) {
		this(width, height, null);
	}
	
	public MapWidget(String width, String height, MapOptions options) {
		Element e = DOM.createDiv();
		this.options = options; 
	    setElement(e);
		setWidth(width);
		setHeight(height);
	}
	
	private static VerticalPanel getHiddenPanel()
	{
		if (hiddenPanel == null)
		{
			hiddenPanel = new VerticalPanel();
			hiddenPanel.setHeight("1px");
			hiddenPanel.setWidth("1px");
//			hiddenPanel.setVisible(true);
			RootPanel.get().add(hiddenPanel);
		}
		
		return hiddenPanel;
	}

	public Map getMap()
	{
		//The preference here is lazy initalization
		if (map == null)
		{
			if (options == null)
				map = new Map(getElement());
			else
				map = new Map(getElement(), options);
//			gmap = new GMap2(getElement(), options);
//			gmap.setCenter(initialCenter, initialZoom);
//			gmap.checkResize();
		}
		return map;
	}
	
	public void setHeight(String height)
	{
		if (height.matches("^\\d+$"))
		{
			super.setHeight(height+"px");
		}
		else super.setHeight(height);
		
		//  If it's not initialized yet there is no need to do anything
//		if (gmap != null) gmap.checkResize();
	}

	public void setWidth(String width)
	{
		if (width.matches("^\\d+$"))
		{
			super.setWidth(width+"px");
		}
		else super.setWidth(width);
		
		//	If it's not initialized yet there is no need to do anything
//		if (gmap != null) gmap.checkResize();
	}
	
	protected void onAttach() {
		super.onAttach();
		//Corrects a centering issue when the map object is moved to another parent
		if (this.getParent() != getHiddenPanel())
		{
			//If it's not initialized yet there is no need to do anything
//			if (gmap != null)
//			{
//				GLatLng center = gmap.getCenter();
//				gmap.setCenter(center);
//				gmap.checkResize();
//			}
		}
	}
	
}
