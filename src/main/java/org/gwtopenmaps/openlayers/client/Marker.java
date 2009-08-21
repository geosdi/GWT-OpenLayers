package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.event.MarkerBrowserEventListener;
import org.gwtopenmaps.openlayers.client.event.MarkerBrowserEventListener.MarkerBrowserEvent;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @author Michel Vitor - Intec
 *
 */
public class Marker extends OpenLayersEObjectWrapper {
    
	protected Marker(JSObject element) {
		super(element);
	}

	public static Marker narrowToMarker(JSObject element)
	{
		return (element == null)? null: new Marker(element);
	}
	public Marker(LonLat lonlat) {
		this (MarkerImpl.create(lonlat.getJSObject()));
	}

	public Marker(LonLat lonlat, Icon icon) {
		this (MarkerImpl.create(lonlat.getJSObject(), icon.getJSObject()));
	}

	public LonLat getLonLat() {
		return LonLat.narrowToLonLat(MarkerImpl.getLonLat(getJSObject()));
	}

	public Icon getIcon() {
		return Icon.narrowToIcon(MarkerImpl.getIcon(getJSObject()));
	}
   /**
	* Method: setIcon
	* Change the icon image.
	* icon (Icon) the image of icon  
	*/    
    public void setIcon(Icon icon){
        MarkerImpl.setIcon(getJSObject(),icon.getJSObject()); 	
    }
    /**
	 * Method setLonlat
	 * Change the lonlat of Icon
	 * lonlat (LonLat) the position of this marker
	 */
    public void setLonLat(LonLat lonlat){
    	MarkerImpl.setLonLat(getJSObject(),lonlat.getJSObject());    	
    }
    /**
	 * Method setImageUrl
	 * Change the Url of Icon
	 * imageUrl (Url) the url of this marker
	 */
    public void setImageUrl(String imageUrl){
    	MarkerImpl.setImageUrl(getJSObject(),imageUrl);	
    }
	public void addBrowserEventListener(String browserEvent, final MarkerBrowserEventListener listener){
		eventListeners.addListener(this, listener, browserEvent, new EventHandler (){
			public void onHandle(EventObject eventObject) {
				MarkerBrowserEvent e = new MarkerBrowserEvent(eventObject);
				listener.onBrowserEvent(e);
			}
		});
	};

}
