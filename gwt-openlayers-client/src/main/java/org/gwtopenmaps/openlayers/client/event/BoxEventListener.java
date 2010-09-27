package org.gwtopenmaps.openlayers.client.event;
/**
*
* @author Michel Vitor - Intec
*
*/
public interface BoxEventListener extends EventListener {
	
	class BoxEvents extends BoxEvent {

		public BoxEvents(EventObject eventObject) {
			super(eventObject.getJSObject());
		}
	}
	public void onBox(BoxEvents eventObject);

}
