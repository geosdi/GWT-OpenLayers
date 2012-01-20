package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 *
 */
public class LayerSwitcher extends Control
{

    protected LayerSwitcher(JSObject element)
    {
        super(element);
    }

    public LayerSwitcher()
    {
        this(LayerSwitcherImpl.create());
    }

    public LayerSwitcher(LayerSwitcherOptions options)
    {
        this(LayerSwitcherImpl.create(options.getJSObject()));
    }
}
