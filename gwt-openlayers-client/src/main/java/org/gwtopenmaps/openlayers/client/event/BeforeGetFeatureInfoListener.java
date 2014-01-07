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

import org.gwtopenmaps.openlayers.client.control.WMSGetFeatureInfo;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 *
 */
public interface BeforeGetFeatureInfoListener extends EventListener
{

    public void onBeforeGetFeatureInfo(BeforeGetFeatureInfoEvent eventObject);

    class BeforeGetFeatureInfoEvent extends EventObject
    {

        public BeforeGetFeatureInfoEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

        public WMSGetFeatureInfo getSource()
        {
            JSObject object = getSourceJSObject();

            return (object != null) ? WMSGetFeatureInfo.narrowToWMSGetFeatureInfo(object) : null;
        }

        // TODO: check if return type is OK
        public String getXY()
        {
            return getJSObject().getPropertyAsString("xy");
        }
    }

}
