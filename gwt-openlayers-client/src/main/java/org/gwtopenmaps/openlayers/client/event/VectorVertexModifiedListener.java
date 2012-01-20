package org.gwtopenmaps.openlayers.client.event;

/**
 * Listener for Trigger VertexModified event on Vector Layer
 *
 * vertexmodified - Triggered when a vertex within any feature geometry has been
 * modified. Listeners will receive an object with a *feature* property
 * referencing the modified feature, a *vertex* property referencing the vertex
 * modified (always a point geometry), and a *pixel* property referencing the
 * pixel location of the modification.
 *
 * @author giuseppe
 *
 */
public interface VectorVertexModifiedListener extends EventListener
{

    public void onVertexModifiedEvent(VertexModifiedEvent eventObject);

    class VertexModifiedEvent extends VectorFeatureEvent
    {

        public VertexModifiedEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
            // TODO Auto-generated constructor stub
        }

    }

}
