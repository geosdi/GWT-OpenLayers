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
 * Set topInUnits and topOutUnits to an empty String to hide top units and
 * set bottomInUnits and bottomOutUnits to an empty String to hide bottom units.
 *
 * @author Edwin Commandeur - Atlis EJS
 */
public class ScaleLineOptions extends ControlOptions
{
	
	/**
	 * Set the maximum width of the scale line in pixels.
	 * @param maxWidth Maximum width of the scale line in pixels (default is 100)
	 */
	public void setMaxWidth(int maxWidth)
	{
        getJSObject().setProperty("maxWidth", maxWidth);
	}

    /**
     *
     * In refers to ..?zoomed in?...
     *
     * @param units - Index into OpenLayers.INCHES_PER_UNIT hashtable,
     *  default is m.
     */
    public void setTopInUnits(String units)
    {
        getJSObject().setProperty("topInUnits", units);
    }

    /**
     * Out refers to ..?zoomed out?...
     *
     * @param units - Index into OpenLayers.INCHES_PER_UNIT hashtable,
     *  default is km.
     */
    public void setTopOutUnits(String units)
    {
        getJSObject().setProperty("topOutUnits", units);
    }

    /**
     *
     * In refers to ..?zoomed in?...
     *
     * @param units - Index into OpenLayers.INCHES_PER_UNIT hashtable,
     *  default is mi.
     */
    public void setBottomInUnits(String units)
    {
        getJSObject().setProperty("bottomInUnits", units);
    }

    /**
     *
     * Out refers to ..?zoomed out?...
     *
     * @param units - Index into OpenLayers.INCHES_PER_UNIT hashtable,
     *  default is ft.
     */
    public void setBottomOutUnits(String units)
    {
        getJSObject().setProperty("bottomOutUnits", units);
    }

}
