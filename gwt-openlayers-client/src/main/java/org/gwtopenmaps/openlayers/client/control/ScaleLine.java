package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * Displays a line indicator representing the map scale for the
 * state of the map.
 *
 * By default the scale is shown in kilometers/meters and in miles/feet.
 * Miles are English miles? (not sea miles; are those nmi)
 *
 * TODO: Find out if nmi are nautical miles, changing mi to nmi seemed to have
 *  little effect.
 *
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ScaleLine extends Control
{

    protected ScaleLine(JSObject element)
    {
        super(element);
    }

    public ScaleLine()
    {
        this(ScaleLineImpl.create());
    }

    public ScaleLine(ScaleLineOptions options)
    {
        this(ScaleLineImpl.create(options.getJSObject()));
    }
}
