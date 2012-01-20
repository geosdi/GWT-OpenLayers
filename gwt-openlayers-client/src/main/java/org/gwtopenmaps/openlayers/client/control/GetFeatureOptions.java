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
