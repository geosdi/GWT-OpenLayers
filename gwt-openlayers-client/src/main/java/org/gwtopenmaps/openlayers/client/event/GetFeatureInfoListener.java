package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.control.WMSGetFeatureInfo;
import org.gwtopenmaps.openlayers.client.util.JSObject;



/**
 * @author Dave Potts
 *
 */
public interface GetFeatureInfoListener extends EventListener {

	class GetFeatureInfoEvent extends EventObject {

		public GetFeatureInfoEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

		public WMSGetFeatureInfo getSource(){
			JSObject object = getSourceJSObject();
			return (object!=null)?WMSGetFeatureInfo.narrowToWMSGetFeatureInfo(object):null;
		}
		public String getText(){
			return getJSObject().getPropertyAsString("text");

		}
	}

	public void onGetFeatureInfo(GetFeatureInfoEvent eventObject);

}
