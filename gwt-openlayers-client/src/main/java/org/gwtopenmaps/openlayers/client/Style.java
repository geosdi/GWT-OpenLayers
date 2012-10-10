package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * From OpenLayers documentation: "OpenLayers features can have a number of
 * style attributes. The 'default' style will typically be used if no other
 * style is specified. These styles correspond for the most part, to the styling
 * properties defined by the SVG standard. Information on fill properties:
 * http://www.w3.org/TR/SVG/painting.html#FillProperties Information on stroke
 * properties: http://www.w3.org/TR/SVG/painting.html#StrokeProperties"
 *
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 * @author Rafael Ceravolo - LOGANN
 * @author Lukas Johansson
 *
 */
//FIXME: This class does not wrap the OpenLayers.Style object, but a symbolizer
// with 'style' attributes! Move this to VectorStyle/VectorFeatureStyle or to symbolizer
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
	 * This constructor is to be used when you want to get an empty Style object, instead of a Style initialized to default.
	 * For example :
	 * <code>Style emptyStyle = new Style("{}");
	 * @param string
	 * 			The JSON representation of the properties used to initialize the Style object
	 */
	public Style(String string) {
		this(StyleImpl.create(string));
	}

	public String getId(){
		return StyleImpl.getId(getJSObject());
	}

	public String getName(){
		return StyleImpl.getName(getJSObject());
	}

	/**
	 * Hex fill color. Default is '#ee9900'.
	 *
	 * @param c
	 *            - hexidecimal color code or a W3C standard color name
	 */
	public void setFillColor(String c) {

		getJSObject().setProperty("fillColor", c);
	}

	/** Hex fill color. */
	public String getFillColor() {
		return getJSObject().getPropertyAsString("fillColor");
	}

	/** Fill opacity (0-1). Default is 0.4 */
	public void setFillOpacity(double o) {
		StyleImpl.setFillOpacity(getJSObject(), o);
	}

	/** Fill opacity (0-1). */
	public double getFillOpacity() {
		double o = StyleImpl.getFillOpacity(getJSObject());
		return o;
	}

	/** Pixel point radius. Default is 6. */
	public void setPointRadius(double r) {
		StyleImpl.setPointRadius(getJSObject(), r);
	}

	/** Pixel point radius. */
	public double getPointRadiusAsDouble() {
		return StyleImpl.getPointRadiusAsDouble(getJSObject());
	}

	/** Use getPointRadiusAsDouble() instead */
	@Deprecated
	public double getPointRadius() {
		return getPointRadiusAsDouble();
	}

	/**
	 * The passed String is the name of the attribute whose value will determine
	 * the point radius
	 */
	public void setPointRadius(String r) {
		StyleImpl.setPointRadius(getJSObject(), r);
	}

	/** The name of the attribute which value determines the point radius */
	public String getPointRadiusAsString() {
		return StyleImpl.getPointRadiusAsString(getJSObject());
	}

	/**
	 * Hex stroke color. Default is '#ee9900'.
	 *
	 * @param c
	 *            - see setFillColor
	 */
	public void setStrokeColor(String c) {
		StyleImpl.setStrokeColor(getJSObject(), c);
	}

	/** Hex stroke html color. */
	public String getStrokeColor() {
		return StyleImpl.getStrokeColor(getJSObject());
	}

	/** Pixel stroke width. Default is 1. */
	public void setStrokeWidth(double w) {
		StyleImpl.setStrokeWidth(getJSObject(), w);
	}

	/** Pixel stroke width. */
	public double getStrokeWidth() {
		return StyleImpl.getStrokeWidth(getJSObject());
	}

	/** Url to an external graphic that will be used for rendering points. */
	public void setExternalGraphic(String graphicURL) {
		StyleImpl.setExternalGraphic(getJSObject(), graphicURL);
	}

	/** Url to an external graphic that will be used for rendering points. */
	public String getExternalGraphic() {
		return StyleImpl.getExternalGraphic(getJSObject());
	}

	/** Url to an external graphic that will be used for rendering points. */
	public void setRotation(String rotation) {
		StyleImpl.setRotation(getJSObject(), rotation);
	}

	/** Url to an external graphic that will be used for rendering points. */
	public String getRotation() {
		return StyleImpl.getRotation(getJSObject());
	}

	/**
	 * Convenient method to set the pixel width and height for sizing an
	 * external graphic.
	 *
	 * @param width
	 *            The width (in pixels) to set
	 * @param height
	 *            The height (in pixels) to set
	 */
	public void setGraphicSize(int width, int height) {
		StyleImpl.setGraphicSize(getJSObject(), width, height);
	}

	/** Pixel width for sizing an external graphic. */
	public int getGraphicWidth() {
		return StyleImpl.getGraphicWidth(getJSObject());
	}

	/** Pixel height for sizing an external graphic. */
	public int getGraphicHeight() {
		return StyleImpl.getGraphicHeight(getJSObject());
	}

	/**
	 * Sets the offset for the displacement of the external graphic. The offset
	 * is from the top-lef of the image (which is considered the point 0,0).
	 *
	 * @param xOffset
	 *            Pixel offset along the positive x axis for displacing an
	 *            external graphic.
	 * @param yOffset
	 *            Pixel offset along the positive y axis for displacing an
	 *            external graphic.
	 */
	public void setGraphicOffset(int xOffset, int yOffset) {
		StyleImpl.setGraphicOffset(getJSObject(), xOffset, yOffset);
	}

	/**
	 * Sets the size of the background graphic. If none of the dimensions are
	 * set, the external graphic size is used.
	 *
	 * @param backgroundWidth
	 *            The width of the background width.
	 * @param backgroundHeight
	 *            The height of the background graphic.
	 */
	public void setBackgroundGraphicSize(int backgroundWidth,
			int backgroundHeight) {
		StyleImpl.setBackgroundGraphicSize(getJSObject(), backgroundWidth,
				backgroundHeight);
	}

	/**
	 * The height of the background graphic. If not provided, the graphicHeight
	 * will be used.
	 */
	public void setBackgroundHeight(int backgroundHeight) {
		StyleImpl.setBackgroundHeight(getJSObject(), backgroundHeight);
	}

	/** The height of the background graphic. */
	public int getBackgroundHeight() {
		return StyleImpl.getBackgroundHeight(getJSObject());
	}

	/**
	 * The width of the background width. If not provided, the graphicWidth will
	 * be used.
	 */
	public void setBackgroundWidth(int backgroundWidth) {
		StyleImpl.setBackgroundWidth(getJSObject(), backgroundWidth);
	}

	/** The width of the background width. */
	public int getBackgroundWidth() {
		return StyleImpl.getBackgroundWidth(getJSObject());
	}

	/** Url to a graphic to be used as the background under an externalGraphic. */
	public void setBackgroundGraphic(String graphicURL) {
		StyleImpl.setBackgroundGraphic(getJSObject(), graphicURL);
	}

	/** Url to a graphic to be used as the background under an externalGraphic. */
	public String getBackgroundGraphic() {
		return StyleImpl.getBackgroundGraphic(getJSObject());
	}

	/**
	 * Sets the offset for the displacement of the background graphic. The
	 * offset is from the top-left of the image (which is considered the point
	 * 0,0).
	 *
	 * @param backgroundXOffset
	 *            Pixel offset along the positive x axis for displacing an
	 *            background graphic.
	 * @param backgroundYOffset
	 *            Pixel offset along the positive y axis for displacing an
	 *            background graphic.
	 */
	public void setBackgroundOffset(int backgroundXOffset, int backgroundYOffset) {
		StyleImpl.setBackgroundOffset(getJSObject(), backgroundXOffset,
				backgroundYOffset);
	}

	/** The integer z-index value to use in rendering. */
	public void setGraphicZIndex(int graphicZIndex) {
		StyleImpl.setGraphicZIndex(getJSObject(), graphicZIndex);
	}

	/** The integer z-index value to use in rendering. */
	public int getGraphicZIndex() {
		return StyleImpl.getGraphicZIndex(getJSObject());
	}

	/**
	 * The integer z-index value to use in rendering the background graphic.
	 * Usually is a number smaller then the GraphicZIndex, so the background can
	 * be behind the feature graphic.
	 */
	public void setBackgroundGraphicZIndex(int backgroundGraphicZIndex) {
		StyleImpl.setBackgroundGraphicZIndex(getJSObject(),
				backgroundGraphicZIndex);
	}

	/** The integer z-index value to use in rendering the background graphic. */
	public int getBackgroundGraphicZIndex() {
		return StyleImpl.getBackgroundGraphicZIndex(getJSObject());
	}

	/** Stroke opacity (0-1). Default is 1. */
	public void setStrokeOpacity(double strokeOpacity) {
		StyleImpl.setStrokeOpacity(this.getJSObject(), strokeOpacity);
	}

	public double getStrokeOpacity() {
		return StyleImpl.getStrokeOpacity(this.getJSObject());
	}

	/**
	 * The text for an optional label. For browsers that use the canvas
	 * renderer, this requires either fillText or mozDrawText to be available.
	 * <p>
	 * Note: you can set a custom label for each feature added to a layer by
	 * using tags in the label, and setting attributes using
	 * {@link org.gwtopenmaps.openlayers.client.util.Attributes}. For example, set the style.label to
	 * "${customLabel}", then, for each feature added to the layer, add an
	 * "customLabel" attribute with
	 * <p>
	 * <code>attributes.setAttribute("customLabel","myLabel for this specific feature")</code>
	 * <p>
	 * Note: this can also be used in any style field of type String, such as
	 * fillColor, fontColor, etc
	 * */
	public void setLabel(String label) {
		StyleImpl.setLabel(this.getJSObject(), label);
	}

	/** The font color for the label, to be provided like CSS. */
	public void setFontColor(String fontColor) {
		StyleImpl.setFontColor(this.getJSObject(), fontColor);
	}

	/** The font size for the label, to be provided like in CSS. */
	public void setFontSize(String fontSize) {
		StyleImpl.setFontSize(this.getJSObject(), fontSize);
	}

	/** The font family for the label, to be provided like in CSS. */
	public void setFontFamily(String fontFamily) {
		StyleImpl.setFontFamily(this.getJSObject(), fontFamily);
	}

	/** The font weight for the label, to be provided like in CSS. */
	public void setFontWeight(String fontWeight) {
		StyleImpl.setFontWeight(this.getJSObject(), fontWeight);
	}

	/**
	 * Sets the Label alignment string directly. This specifies the insertion
	 * point relative to the text. It is a string composed of two characters.
	 * <p>
	 * The first character is for the horizontal alignment, the second for the
	 * vertical alignment.
	 * <p>
	 * Valid values for horizontal alignment: 'l'=left, 'c'=center, 'r'=right.
	 * Valid values for vertical alignment: 't'=top, 'm'=middle, 'b'=bottom.
	 * Example values: 'lt', 'cm', 'rb'. The canvas renderer does not support
	 * vertical alignment, it will always use 'b'.
	 */
	public void setLabelAlign(String align) {
		StyleImpl.setLabelAlign(this.getJSObject(), align);
	}

	/**
	 * Vertical Label alignment. This specifies the insertion point relative to
	 * the text.
	 */
	public String getLabelAlign() {
		return StyleImpl.getLabelAlign(this.getJSObject());
	}

	/** Stroke linecap. */
	public String getStrokeLinecap() {
		return StyleImpl.getStrokeLinecap(this.getJSObject());
	}

	/**
	 * Directly sets the StrokeLineCap string. Default is 'round'. [butt | round
	 * | square]
	 */
	public void setStrokeLinecap(String strokeLinecap) {
		StyleImpl.setStrokeLinecap(this.getJSObject(), strokeLinecap);
	}

	/**
	 * Directly sets the stroke dash style string. Default is Default is
	 * 'solid'. [dot | dash | dashdot | longdash | longdashdot | solid]
	 */
	public void setStrokeDashstyle(String strokeDashstyle) {
		StyleImpl.setStrokeDashstyle(this.getJSObject(), strokeDashstyle);
	}

	/**
	 * Stroke dash style.
	 */
	public String getStrokeDashstyle() {
		return StyleImpl.getStrokeDashstyle(this.getJSObject());
	}

	/** Set to false if no fill is desired. */
	public void setFill(boolean fill) {
		StyleImpl.setFill(this.getJSObject(), fill);
	}

	/** Set to false if no fill is desired. */
	public boolean getFill() {
		return StyleImpl.getFill(this.getJSObject());
	}

	/** Set to false if no stroke is desired. */
	public void setStroke(boolean stroke) {
		StyleImpl.setStroke(this.getJSObject(), stroke);
	}

	/** Set to false if no stroke is desired. */
	public boolean getStroke() {
		return StyleImpl.getStroke(this.getJSObject());
	}

	/** Set to false if no graphic is desired. */
	public void setGraphic(boolean graphic) {
		StyleImpl.setGraphic(this.getJSObject(), graphic);
	}

	/** Set to false if no graphic is desired. */
	public boolean getGraphic() {
		return StyleImpl.getGraphic(this.getJSObject());
	}

	/** Cursor. Default is ''. */
	public void setCursor(String cursor) {
		StyleImpl.setCursor(this.getJSObject(), cursor);
	}

	/** Cursor. */
	public String getCursor() {
		return StyleImpl.getCursor(this.getJSObject());
	}

	/**
	 * Directly sets the named graphic to use when rendering points. Default is
	 * 'circle'.
	 * <p>
	 * Supported values include 'circle' (default), 'square', 'star', 'x',
	 * 'cross', 'triangle'.
	 */
	public void setGraphicName(String graphicName) {
		StyleImpl.setGraphicName(this.getJSObject(), graphicName);
	}

	/**
	 * Named graphic to use when rendering points. Supported values include
	 * 'circle' (default), 'square', 'star', 'x', 'cross', 'triangle'.
	 */
	public String getGraphicName() {
		return StyleImpl.getGraphicName(this.getJSObject());
	}

	/**
	 * Tooltip for an external graphic. Only supported in Firefox and Internet
	 * Explorer.
	 */
	public void setGraphicTitle(String graphicTitle) {
		StyleImpl.setGraphicTitle(this.getJSObject(), graphicTitle);
	}

	/**
	 * Tooltip for an external graphic. Only supported in Firefox and Internet
	 * Explorer.
	 */
	public String getGraphicTitle() {
		return StyleImpl.getGraphicTitle(this.getJSObject());
	}

	/**
	 * Pixel offset along the positive x axis for displacing the label.  Not supported by the canvas renderer.
	 */
	public int getLabelXOffset() {
		return StyleImpl.getLabelXOffset(this.getJSObject());
	}

	/**
	 * Pixel offset along the positive x axis for displacing the label.  Not supported by the canvas renderer.
	 * @param offset
	 */
	public void setLabelXOffset(int offset) {
		StyleImpl.setLabelXOffset(this.getJSObject(), offset);
	}

	/**
	 * Pixel offset along the positive y axis for displacing the label.  Not supported by the canvas renderer.
	 */
	public int getLabelYOffset() {
		return StyleImpl.getLabelYOffset(this.getJSObject());
	}

	/**
	 * Pixel offset along the positive y axis for displacing the label.  Not supported by the canvas renderer.
	 * @param offset
	 */
	public void setLabelYOffset(int offset) {
		StyleImpl.setLabelYOffset(this.getJSObject(), offset);
	}

	/**
	 * If set to true, labels will be selectable using SelectFeature or similar controls.  Default is false.
	 */
	public void getLabelSelect() {
		StyleImpl.getLabelSelect(this.getJSObject());
	}

	/**
	 * If set to true, labels will be selectable using SelectFeature or similar controls.  Default is false.
	 * @param select
	 */
	public void setLabelSelect(boolean select) {
		StyleImpl.setLabelSelect(this.getJSObject(), select);
	}
	
	public double getGraphicOpacity() {
		return StyleImpl.getGraphicOpacity(this.getJSObject());
	}
	
	public void setGraphicOpacity(double opacity) {
		StyleImpl.setGraphicOpacity(this.getJSObject(), opacity);
	}

	public static Style narrowToOpenLayersStyle(JSObject element) {
		return (element == null) ? null: new Style(element);
	}
}
