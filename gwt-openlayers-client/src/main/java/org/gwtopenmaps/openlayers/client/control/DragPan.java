package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * DragPan control wrapper.
 *
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
public class DragPan extends Control
{
    protected DragPan(JSObject element)
    {
        super(element);
    }

    public DragPan()
    {
        this(DragPanImpl.create());
    }
    
    public DragPan(DragPanOptions options)
    {
        this(DragPanImpl.create(options.getJSObject()));
    }

}
