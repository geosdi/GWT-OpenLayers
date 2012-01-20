package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class EditingToolbar extends Panel
{

    protected EditingToolbar(JSObject element)
    {
        super(element);
    }

    public EditingToolbar(Vector vectorLayer)
    {
        this(EditingToolbarImpl.create(vectorLayer.getJSObject()));
    }

    public EditingToolbar(Vector vectorLayer, EditingToolbarOptions options)
    {
        this(EditingToolbarImpl.create(vectorLayer.getJSObject(), options.getJSObject()));
    }
}
