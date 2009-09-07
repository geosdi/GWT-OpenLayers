package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 * 
 */
public class Style extends OpenLayersObjectWrapper {

	public static final String STROKE_DASHSTYLE_SOLID = "solid";
	public static final String STROKE_DASHSTYLE_DASHDOT = "dashdot";

	protected Style(JSObject element) {
		super(element);
	}

	public Style() {
		this(StyleImpl.create());
	}

	/**
	 * @param c
	 *            - hexidecimal color code or a W3C standard color name
	 */
	public void setFillColor(String c) {
		StyleImpl.setFillColor(getJSObject(), c);
	}

	public String getFillColor() {
		return StyleImpl.getFillColor(getJSObject());
	}

	public void setFillOpacity(double o) {
		StyleImpl.setFillOpacity(getJSObject(), o);
	}

	public double getFillOpacity() {
		double o = StyleImpl.getFillOpacity(getJSObject());
		return o;
	}

	public void setPointRadius(double r) {
		StyleImpl.setPointRadius(getJSObject(), r);
	}

	public double getPointRadius() {
		return StyleImpl.getPointRadius(getJSObject());
	}

	/**
	 * @param c
	 *            - see setFillColor
	 */
	public void setStrokeColor(String c) {
		StyleImpl.setStrokeColor(getJSObject(), c);
	}

	public String getStrokeColor() {
		return StyleImpl.getStrokeColor(getJSObject());
	}

	public void setStrokeWidth(double w) {
		StyleImpl.setStrokeWidth(getJSObject(), w);
	}

	public double getStrokeWidth() {
		return StyleImpl.getStrokeWidth(getJSObject());
	}

	public void setExternalGraphic(String graphicURL) {
		StyleImpl.setExternalGraphic(getJSObject(), graphicURL);
	}

	public String getExternalGraphic() {
		return StyleImpl.getExternalGraphic(getJSObject());
	}

	public void setGraphicSize(int width, int height) {
		StyleImpl.setGraphicSize(getJSObject(), width, height);
	}

	public int getGraphicWidth() {
		return StyleImpl.getGraphicWidth(getJSObject());
	}

	public int getGraphicHeight() {
		return StyleImpl.getGraphicHeight(getJSObject());
	}

	public void setGraphicOffset(int xOffset, int yOffset) {
		StyleImpl.setGraphicOffset(getJSObject(), xOffset, yOffset);
	}

	public void setBackgroundGraphicSize(int backgroundWidth, int backgroundHeight) {
		StyleImpl.setBackgroundGraphicSize(getJSObject(), backgroundWidth, backgroundHeight);
	}

	public void setBackgroundHeight(int backgroundHeight) {
		StyleImpl.setBackgroundHeight(getJSObject(), backgroundHeight);
	}

	public int getBackgroundHeight() {
		return StyleImpl.getBackgroundHeight(getJSObject());
	}

	public void setBackgroundWidth(int backgroundWidth) {
		StyleImpl.setBackgroundWidth(getJSObject(), backgroundWidth);
	}

	public int getBackgroundWidth() {
		return StyleImpl.getBackgroundWidth(getJSObject());
	}

	public void setBackgroundGraphic(String graphicURL) {
		StyleImpl.setBackgroundGraphic(getJSObject(), graphicURL);
	}

	public String getBackgroundGraphic() {
		return StyleImpl.getBackgroundGraphic(getJSObject());
	}

	public void setBackgroundOffset(int backgroundXOffset, int backgroundYOffset) {
		StyleImpl.setBackgroundOffset(getJSObject(), backgroundXOffset, backgroundYOffset);
	}

	public void setGraphicZIndex(int graphicZIndex) {
		StyleImpl.setGraphicZIndex(getJSObject(), graphicZIndex);
	}

	public int getGraphicZIndex() {
		return StyleImpl.getGraphicZIndex(getJSObject());
	}

	public void setBackgroundGraphicZIndex(int backgroundGraphicZIndex) {
		StyleImpl.setBackgroundGraphicZIndex(getJSObject(), backgroundGraphicZIndex);
	}

	public int getBackgroundGraphicZIndex() {
		return StyleImpl.getBackgroundGraphicZIndex(getJSObject());
	}

}
