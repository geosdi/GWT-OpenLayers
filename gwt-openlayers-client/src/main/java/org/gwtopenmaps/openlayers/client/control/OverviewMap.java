/**
 *
 *   Copyright 2014 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
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
