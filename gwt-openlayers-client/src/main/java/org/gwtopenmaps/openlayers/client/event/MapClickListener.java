package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.Pixel;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapClickListener extends EventListener
{

    public void onClick(MapClickEvent mapClickEvent);

    class MapClickEvent extends MapEvent
    {

        public MapClickEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

        public LonLat getLonLat()
        {
            Map map = Map.narrowToMap(this.getSourceJSObject());
            Pixel pixel = Pixel.narrowToPixel(getJSObject().getProperty("xy"));

            return (pixel != null) ? map.getLonLatFromPixel(pixel) : null;
        }

        public Pixel getPixel()
        {
            return Pixel.narrowToPixel(getJSObject().getProperty("xy"));
        }
    }
}
