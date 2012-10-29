package org.gwtopenmaps.openlayers.client.popup;

import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.Pixel;
import org.gwtopenmaps.openlayers.client.Size;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @author Curtis Jensen
 * @author <a href="mailto:marten.karlberg@digpro.se">Marten Karlberg</a>, Digpro AB
 *
 */
public class Popup extends OpenLayersObjectWrapper
{

    public static Popup narrowToOpenLayersPopup(JSObject element)
    {
        return (element == null) ? null : new Popup(element);
    }

    protected Popup(JSObject element)
    {
        super(element);
    }

    /*
     * Constructor also taking a CloseListener callback as suggested by the original OpenLayers
     * JavaScript constructor.
     *
     * Added by Digpro.
     */
    public Popup(String id, LonLat lonlat, Size size, String html,
        boolean closeBox,
        CloseListener closeBoxCallback)
    {

        this(PopupImpl.create(id, lonlat.getJSObject(),
                (size != null) ? size.getJSObject() : null,
                html, closeBox,
                (closeBoxCallback != null) ? closeBoxCallback : null));
    }

    /**
     *
     * Use addCloseListener to respond to popup close event. (Beware! This does not work as
     * expected. Instead pass the CloseListener in the constructor for proper binding. /Digpro)
     *
     * @param id - String identifier for Popup. Used by ..?..
     * @param lonlat - {@link org.gwtopenmaps.openlayers.client.LonLat} where Popup should appear
     * @param size - {@link org.gwtopenmaps.openlayers.client.Size} that provides height and width for Popup
     * @param html - String with html content to appear in Popup
     * @param closeBox - Set to true to get close button in upper right corner of Popup
     */
    public Popup(String id, LonLat lonlat, Size size, String html,
        boolean closeBox)
    {
        this(PopupImpl.create(id,
                (lonlat != null) ? lonlat.getJSObject() : null,
                (size != null) ? size.getJSObject() : null,
                html,
                closeBox));
    }

    /**
     *
     * @deprecated add a close listener via the constructor instead
     *    this method uses a private method in OL and will not work as expected
     */
    public void addCloseListener(CloseListener callback)
    {
        PopupImpl.addCloseListener(this.getJSObject(), callback);
    }

    /**
     * autosize the popup
     *
     * @param autoSize
     *            - boolean
     */
    public void setAutoSize(boolean autoSize)
    {
        this.getJSObject().setProperty("autoSize", autoSize);
    }

    /**
     * Get the popup autoSize state
     *
     * @return autoSize - boolean
     */
    public boolean getAutoSize()
    {
        return this.getJSObject().getPropertyAsBoolean("autoSize");
    }

    /**
     * When drawn, pan map such that the entire popup is visible in the current
     * viewport (if necessary).
     *
     * @param panMapIfOutOfView
     *            - boolean
     */
    public void setPanMapIfOutOfView(boolean panMapIfOutOfView)
    {
        this.getJSObject().setProperty("panMapIfOutOfView", panMapIfOutOfView);
    }

    /**
     * Get the popup panMapIfOutOfView state
     *
     * @return panMapIfOutOfView - boolean
     */
    public boolean getPanMapIfOutOfView()
    {
        return this.getJSObject().getPropertyAsBoolean("panMapIfOutOfView");
    }

    /**
     * Set the popup backgroundColor. Sets the style
     *
     * @param color
     *            - String
     */
    public void setBackgroundColor(String color)
    {
        this.getJSObject().setProperty("backgroundColor", color);
    }

    /**
     * Get the popup backgroundColor
     *
     * @return backgroundColor - String
     */
    public String getBackgroundColor()
    {
        return this.getJSObject().getPropertyAsString("backgroundColor");
    }

    /**
     * Set the popup opacity
     *
     * @param opacity
     *            - double
     */
    public void setOpacity(double opacity)
    {
        this.getJSObject().setProperty("opacity", opacity);
    }

    /**
     * Get the popup opacity
     *
     * @return opacity - double
     */
    public double getOpacity()
    {
        return this.getJSObject().getPropertyAsDouble("opacity");
    }

    /**
     * Set the border style
     *
     * @param border
     *            - String
     */
    public void setBorder(String border)
    {
        this.getJSObject().setProperty("border", border);
    }

    /**
     * Get the border style as set by setBorder
     *
     * @return border CSS
     */
    public String getBorder()
    {
        return this.getJSObject().getPropertyAsString("border");
    }

    public void setContentHTML(String contentHTML)
    {
        this.getJSObject().setProperty("contentHTML", contentHTML);
    }

    public void setLonLat(LonLat lt)
    {
        this.getJSObject().setProperty("lonlat", lt.getJSObject());
    }

    public LonLat getLonLat()
    {
    	return LonLat.narrowToLonLat(this.getJSObject().getProperty("lonlat"));
    }

    /**
     * Method: show Makes the popup visible.
     */
    public void show()
    {
        PopupImpl.show(getJSObject());
    }

    /**
     * Method: hide Makes the popup invisible.
     */
    public void hide()
    {
        PopupImpl.hide(getJSObject());
    }

    /**
     * Method: updatePosition
     * if the popup has a lonlat and its map members set,
     * then have it move itself to its proper position
     */
    public void updatePosition()
    {
        PopupImpl.updatePosition(getJSObject());
    }

    /**
     * Method: moveTo
     *
     * @param px - {<OpenLayers.Pixel>} the top and left position of the popup div.
     */
    public void moveTo(Pixel px) {
        PopupImpl.moveTo(getJSObject(), px.getJSObject());
    }

    /**
     * Method: panIntoView
     * Pans the map such that the popup is totaly viewable (if necessary)
     */
    public void panIntoView() {
    	PopupImpl.panIntoView(getJSObject());
    }

    /**
     * APIMethod: updateSize
     * Auto size the popup so that it precisely fits its contents (as
     * determined by this.contentDiv.innerHTML). Popup size will, of
     * course, be limited by the available space on the current map
     */
    public void updateSize()
    {
        PopupImpl.updateSize(getJSObject());
    }


    /**
     * Method: setSize
     * Used to adjust the size of the popup.
     *
     * Parameters:
     * contentSize - {<OpenLayers.Size>} the new size for the popup's
     *     contents div (in pixels).
     */
    public void setSize(Size size) {
    	PopupImpl.setSize(getJSObject(), size.getJSObject());
    }

    /**
     * Method: destroy
     * nullify references to prevent circular references and memory leaks
     */
    public void destroy() {
    	PopupImpl.destroy(getJSObject());
    }

    public interface CloseListener
    {

        void onPopupClose(JSObject evt);
    }
}
