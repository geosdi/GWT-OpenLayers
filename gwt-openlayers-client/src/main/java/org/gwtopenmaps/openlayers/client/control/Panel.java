package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Curtis Jensen
 *
 */
public class Panel extends Control
{

    protected Panel(JSObject element)
    {
        super(element);
    }

    public Panel(PanelOptions options)
    {
        this(PanelImpl.create(options.getJSObject()));
    }

    public void addControls(Control[] controls)
    {
        JObjectArray controlArray = new JObjectArray(controls);
        PanelImpl.addControls(this.getJSObject(), controlArray.getJSObject());
    }
}
