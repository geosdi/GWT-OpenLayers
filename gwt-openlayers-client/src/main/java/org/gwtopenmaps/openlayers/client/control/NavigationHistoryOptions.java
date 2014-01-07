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
package org.gwtopenmaps.openlayers.client.control;

/**
 *
 * @author giuseppe
 *
 */
public class NavigationHistoryOptions extends ControlOptions
{

    /**
     * APIProperty: limit {Integer} Optional limit on the number of history
     * items to retain. If null, there is no limit. Default is 50.
     */
    public void setLimit(int limit)
    {
        getJSObject().setProperty("limit", limit);
    }

    /**
     * APIProperty: autoActivate {Boolean} Activate the control when it is added
     * to a map. Default is true.
     */
    public void setAutoActivate(boolean autoActivate)
    {
        getJSObject().setProperty("autoActivate", autoActivate);
    }

    /**
     * Property: clearOnDeactivate {Boolean} Clear the history when the control
     * is deactivated. Default is false.
     */
    public void setClearOnDeactivate(boolean clearOnDeactivate)
    {
        getJSObject().setProperty("clearOnDeactivate", clearOnDeactivate);
    }

}
