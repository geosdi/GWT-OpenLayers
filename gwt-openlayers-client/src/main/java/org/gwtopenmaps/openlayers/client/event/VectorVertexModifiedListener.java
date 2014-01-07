/**
 *
 *   Copyright 2014 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
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
