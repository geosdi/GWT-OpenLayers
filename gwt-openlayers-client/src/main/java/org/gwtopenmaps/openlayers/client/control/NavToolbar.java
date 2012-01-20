package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * Access the openlayers navtoolbar control.
 *
 * @author Emily Gouge - Refractions Research
 *
 */
public class NavToolbar extends Panel
{

    protected NavToolbar(JSObject element)
    {
        super(element);
    }

    public NavToolbar()
    {
        this(NavToolbarImpl.create());
    }

    public NavToolbar(NavToolbarOptions options)
    {
        this(NavToolbarImpl.create(options.getJSObject()));
    }

    /*
    //TODO: move to PanZoomBarOptions
            public NavToolBar(Element div){
                    super((JSObject)null);
                    Options options = new Options();
                    options.setAttribute("div", div);
                    setJSObject(NavToolBarImpl.create(options.getJSObject()));
            }
     */

}
