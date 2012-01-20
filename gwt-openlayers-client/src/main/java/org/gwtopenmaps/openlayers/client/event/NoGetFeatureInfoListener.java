package org.gwtopenmaps.openlayers.client.event;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 */
public interface NoGetFeatureInfoListener extends EventListener
{

    public void onNoGetFeatureInfo(NoGetFeatureInfoEvent eventObject);

    class NoGetFeatureInfoEvent extends EventObject
    {

        public NoGetFeatureInfoEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }
    }
}
