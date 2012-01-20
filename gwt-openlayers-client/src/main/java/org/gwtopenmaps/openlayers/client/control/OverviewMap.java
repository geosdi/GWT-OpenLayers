package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class OverviewMap extends Control
{

    protected OverviewMap(JSObject element)
    {
        super(element);
    }

    public OverviewMap()
    {
        this(OverviewMapImpl.create());
    }

    public OverviewMap(OverviewMapOptions options)
    {
        this(OverviewMapImpl.create(options.getJSObject()));
    }

    /**
     * The overview map control has a reference to a {@link org.gwtopenmaps.openlayers.client.Map} instance,
     * which is the actual overview map.
     *
     * @return map - instance of {@link org.gwtopenmaps.openlayers.client.Map}
     *   map will be null if the control is not added to any map yet
     */
    public Map getOverviewMap()
    {
        return Map.narrowToMap(getJSObject().getProperty("ovmap"));
    }

    /**
     * Turn on autoPan
     * @param autoPan
     */
    public void setAutoPan(boolean autoPan)
    {
        getJSObject().setProperty("autoPan", autoPan);
    }

    /**
     * Turn on autoPan
     * @return autoPan
     */
    public boolean getAutoPan()
    {
        return getJSObject().getPropertyAsBoolean("autoPan");
    }

}
