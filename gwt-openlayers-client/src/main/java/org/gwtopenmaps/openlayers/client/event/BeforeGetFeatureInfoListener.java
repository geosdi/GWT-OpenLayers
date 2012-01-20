package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.control.WMSGetFeatureInfo;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 *
 */
public interface BeforeGetFeatureInfoListener extends EventListener
{

    public void onBeforeGetFeatureInfo(BeforeGetFeatureInfoEvent eventObject);

    class BeforeGetFeatureInfoEvent extends EventObject
    {

        public BeforeGetFeatureInfoEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

        public WMSGetFeatureInfo getSource()
        {
            JSObject object = getSourceJSObject();

            return (object != null) ? WMSGetFeatureInfo.narrowToWMSGetFeatureInfo(object) : null;
        }

        // TODO: check if return type is OK
        public String getXY()
        {
            return getJSObject().getPropertyAsString("xy");
        }
    }

}
