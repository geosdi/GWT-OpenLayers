package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.Pixel;
import org.gwtopenmaps.openlayers.client.util.JSObject;

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
