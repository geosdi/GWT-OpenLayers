package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


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
public class MousePosition extends Control
{

    protected MousePosition(JSObject element)
    {
        super(element);
    }

    public MousePosition()
    {
        this(MousePositionImpl.create());
    }

    /**
     *
     * @param options -
     * @since GWT-OL 0.4
     */
    public MousePosition(MousePositionOptions options)
    {
        this(MousePositionImpl.create(options.getJSObject()));
    }

    //
    // legacy
    //

    /*
    //TODO: move to MousePositionOptions
            public MousePosition(Element divId) {
                    super((JSObject)null);
                    Options options = new Options();
                    options.getJSObject().setProperty("element", divId);
                    setJSObject(MousePositionImpl.create(options.getJSObject()));
            }
     */

}
