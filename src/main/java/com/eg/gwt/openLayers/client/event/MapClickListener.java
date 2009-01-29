package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.LonLat;
import com.eg.gwt.openLayers.client.Map;
import com.eg.gwt.openLayers.client.Pixel;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapClickListener extends EventListener {

	class MapClickEvent extends EventObject {

		public MapClickEvent(JSObject eventObject) {
			super(eventObject);
		}

		public LonLat getLonLat(){
			Map map = Map.narrowToMap(this.getObject());
			Pixel pixel = super.getPixel();
			if(pixel != null){
				return map.getLonLatFromPixel(pixel);
			} else {
				return null;
			}
		}
	}

	public void onClick(Map source, MapClickEvent mapClickEvent);
}
