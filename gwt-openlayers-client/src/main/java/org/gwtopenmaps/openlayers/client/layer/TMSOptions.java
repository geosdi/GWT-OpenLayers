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
package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Amr Alam - Refractions Research
 *
 */
public class TMSOptions extends LayerOptions
{

    public TMSOptions()
    {
    }

    public TMSOptions(String layername, String type)
    {
        // setting required options
        setLayername(layername);
        setType(type);
    }

    public void setLayers(String layers)
    {
        getJSObject().setProperty("layers", layers);
    }

    public String getLayers()
    {
        return getJSObject().getPropertyAsString("layers");
    }

    public void setStyles(String styles)
    {
        getJSObject().setProperty("styles", styles);
    }

    public String getStyles()
    {
        return getJSObject().getPropertyAsString("styles");
    }

    public void setFormat(String styles)
    {
        getJSObject().setProperty("format", styles);
    }

    public String getFormat()
    {
        return getJSObject().getPropertyAsString("format");
    }

    @Override
    public void setMaxExtent(Bounds bounds)
    {
        getJSObject().setProperty("maxExtent", bounds.getJSObject());
    }

    @Override
    public Bounds getMaxExtent()
    {
        return Bounds.narrowToBounds(getJSObject().getProperty("maxExtent"));
    }

    public void setType(String type)
    {
        getJSObject().setProperty("type", type);
    }

    public String getType()
    {
        return getJSObject().getPropertyAsString("type");
    }

    public void setServiceVersion(String serviceVersion)
    {
        getJSObject().setProperty("serviceVersion", serviceVersion);
    }

    public String getServiceVersion()
    {
        return getJSObject().getPropertyAsString("serviceVersion");
    }

    public void setLayername(String layername)
    {
        getJSObject().setProperty("layername", layername);
    }

    public String getLayername()
    {
        return getJSObject().getPropertyAsString("layername");
    }

    public void setGetURL(JSObject getURL)
    {
        getJSObject().setProperty("getURL", getURL);
    }
}
