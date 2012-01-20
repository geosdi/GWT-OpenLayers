package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Curtis Jensen
 *
 */
public class MouseDefaults extends Control
{

    protected MouseDefaults(JSObject element)
    {
        super(element);
    }

    public MouseDefaults()
    {
        this(MouseToolbarImpl.create());
    }

    public MouseDefaults(MouseDefaultsOptions options)
    {
        this(MouseDefaultsImpl.create(options.getJSObject()));
    }

}
