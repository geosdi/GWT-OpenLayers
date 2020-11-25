/*
 *
 *   Copyright 2015 GWT OpenLayers Team.
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
 * Listener for Trigger BeforeFeatureModified on Vector Layer
 *
 * beforefeaturemodified - Triggered when a feature is selected to be modified.
 * Listeners will receive an object with a *feature* property referencing the
 * selected feature.
 *
 * @author giuseppe
 *
 */
public interface VectorBeforeFeatureModifiedListener extends EventListener
{

    public void onBeforeFeatureModified(BeforeFeatureModifiedEvent eventObject);

    class BeforeFeatureModifiedEvent extends VectorFeatureEvent
    {

        public BeforeFeatureModifiedEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
            // TODO Auto-generated constructor stub
        }

    }

}
