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

	class MapClickEvent extends MapEvent {

		public MapClickEvent(JSObject eventObject) {
			super(eventObject);
		}

		public LonLat getLonLat(){
			Map map = Map.narrowToMap(this.getObject());
			Pixel pixel = Pixel.narrowToPixel(getJSObject().getProperty("xy"));
			return (pixel != null)? map.getLonLatFromPixel(pixel):null;
		}
	}

	public void onClick(MapClickEvent mapClickEvent);
}
