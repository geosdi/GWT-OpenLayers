package com.eg.gwt.openLayers.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * See {@link Map}.
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur
 *
 */
public class MapWidget extends Widget {

	private Map map;
	private MapOptions options;

	/**
	 * Programmatically creates the element that will contain the map,
	 * with the given width and height.
	 *
	 * The map itself is instantiated upon calling {@link #getMap()}.
	 *
	 * @param width - a String with the width of the element that will contain the map in CSS units.
	 * @param height - a String with the height of the element that will contain the map in CSS units.
	 *
	 * @since GWT-OL 0.2
	 */
	public MapWidget(String width, String height) {
		this(width, height, null);
	}

	/**
	 * Programmatically creates the element that will contain the map,
	 * with the given width and height.
	 *
	 * The map itself is instantiated upon calling {@link #getMap()}.
	 *
	 * @param width - a String with the width of the element that will contain the map in CSS units.
	 * @param height - a String with the height of the element that will contain the map in CSS units.
	 * @param options - null if no options should be set upon map instantiation
	 *  	or a MapOptions object that is passed to the map upon instantiation.
	 *
	 * @since GWT-OL 0.2
	 */
	public MapWidget(String width, String height, MapOptions options) {
		Element e = DOM.createDiv();
		this.options = options;
		setElement(e);
		setWidth(width);
		setHeight(height);
	}

	/**
	 * Uses the elementId to obtain the element that will contain the map from
	 * the application html.
	 *
	 * For example, if the application html contains a div with the id "map":
	 * <pre>
	 *     MapWidget mapWidget = new MapWidget("map", null);
	 * </pre>
	 *
	 * The map itself is instantiated upon calling {@link #getMap()}.
	 *
	 * @param element - the element that should contain the map.
	 * @param options - null if no options should be set upon map instantiation
	 *  	or a MapOptions object that is passed to the map upon instantiation.
	 *
	 * @since GWT-OL 0.4
	 */
	public MapWidget(String elementId, MapOptions options) {
	    Element element = DOM.getElementById(elementId);
		if(element != null){
			this.options = options;
			setElement(element);
		} else {
			throw new RuntimeException("Mapwidget could not be instantiated. " +
				"Failed to get element by id " +  elementId + ".");
		}
	}

	/**
	 * The map is instantiated the first time it is returned.
	 *
	 * @return Map - see {@link Map}.
	 */
	public Map getMap()
	{
		//The preference here is lazy initalization
		if (map == null)
		{
			if (options == null)
				map = new Map(getElement());
			else
				map = new Map(getElement(), options);
		}
		return map;
	}

	//TODO do more sophisticated check if height is in CSS units
	public void setHeight(String height)
	{
		if (height.matches("^\\d+$"))
		{
			super.setHeight(height+"px");
		}
		else super.setHeight(height);
	}

	//TODO do more sophisticated check if width is in CSS units
	public void setWidth(String width)
	{
		if (width.matches("^\\d+$"))
		{
			super.setWidth(width+"px");
		}
		else super.setWidth(width);
	}

	/*
	 * Overrides onAttach method of Widget, which is called when the widget
	 * is attached to the browser's document.
	 */
	protected void onAttach() {
		super.onAttach();
	}

}
