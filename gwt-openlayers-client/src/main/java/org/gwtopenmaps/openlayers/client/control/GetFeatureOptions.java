/**
 *
 *   Copyright 2013 sourceforge.
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

import org.gwtopenmaps.openlayers.client.protocol.WFSProtocol;


public class GetFeatureOptions extends ControlOptions
{

    public void setProtocol(WFSProtocol protocol)
    {
//              getJSObject().setProperty("protocol", createGetFromWMSLayerProtocol(layer.getJSObject()));
        getJSObject().setProperty("protocol", protocol.getJSObject());
    }

    public void setHover(boolean hover)
    {
        getJSObject().setProperty("hover", hover);
    }

    public void setBox(boolean box)
    {
        getJSObject().setProperty("box", box);
    }

    public void setMultiple(boolean multiple)
    {
        getJSObject().setProperty("multiple", multiple);
    }

    public void setMultipleKey(String key)
    {
        getJSObject().setProperty("multipleKey", key);
    }

    public void setToggleKey(String key)
    {
        getJSObject().setProperty("toggleKey", key);
    }

    public void setMaxFeatures(int maxFeatures)
    {
        getJSObject().setProperty("maxFeatures", maxFeatures);
    }

}
