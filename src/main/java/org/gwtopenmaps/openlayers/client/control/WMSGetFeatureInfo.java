package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.event.EventType;
import org.gwtopenmaps.openlayers.client.event.GetFeatureInfoEvent;
import org.gwtopenmaps.openlayers.client.event.GetFeatureInfoListener;
import org.gwtopenmaps.openlayers.client.handler.HandlerOptions;

/**
 * @author Dave Potts
 *
 * requires OpenLayers 2.7 or higher
 */
public class WMSGetFeatureInfo extends Control{

	protected WMSGetFeatureInfo(JSObject wMSGetFeatureInfo){
		super(wMSGetFeatureInfo);
	}

	public WMSGetFeatureInfo(){
		this(WMSGetFeatureInfoImpl.create());
	}

	public WMSGetFeatureInfo(WMSGetFeatureInfoOptions o, HandlerOptions ho){
		this(WMSGetFeatureInfoImpl.create(o.getJSObject()));
	}

	public WMSGetFeatureInfo(WMSGetFeatureInfoOptions o){
		this(WMSGetFeatureInfoImpl.create(o.getJSObject()));
	}
	public static WMSGetFeatureInfo narrowToWMSGetFeatureInfo(JSObject object)	{
		return (object == null)? null: new WMSGetFeatureInfo(object);
	}

	public void addGetFeatureListener(final GetFeatureInfoListener listener){
		eventListeners.addListener(this, listener, EventType.CONTROL_GET_FEATURE_INFO, new EventHandler(){
			@Override
			public void onHandle(EventObject eventObject){
				GetFeatureInfoEvent e = new GetFeatureInfoEvent(eventObject);
				listener.onGetFeature(e);
			}
		});
	}

}
