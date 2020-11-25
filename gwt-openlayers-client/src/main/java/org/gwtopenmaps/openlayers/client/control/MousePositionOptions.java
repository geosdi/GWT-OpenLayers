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
package org.gwtopenmaps.openlayers.client.control;


/**
 * See {@link MousePosition}.
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class MousePositionOptions extends ControlOptions
{

    /**
     * <p>
     * The output of the MousePosition control is determined by
     * the formatOutput function of MouseOptions. The format used
     * is:<pre>
     *      prefix + longitude + separator + latitude + postfix
     * </pre>
     * The prefix, number of significant digits of the longitude and latitude,
     * the separator, and the postfix can all be changed, but sometimes
     * it is desirable to change the format.
     * </p><p>
     * In OpenLayers you would override the formatOutput function to customize
     * the format in which the geographic coordinates are displayed.
     *
     * In GWT-OpenLayers the same effect can be achieved by passing
     * an instance of MousePositionOutput with a custom format
     * function, see {@link MousePositionOutput}. For example:
     *
     * <pre>
     *     MousePositionOutput mpOut = new MousePositionOutput(){
     *         public String format(LonLat lonLat, Map map){
     *              String out = "";
     *              out += lonLat.lon();
     *              out += ", ";
     *              out += lonLat.lat();
     *              return out;
     *         }
     *     };
     *     setFormatOutput(mpOut);
     * </pre>
     * </p>
     *
     */
    public void setFormatOutput(MousePositionOutput output)
    {
        getJSObject().setProperty("formatOutput", MousePositionImpl.formatOutput(output));
    }

    /**
     * The number of digits to display in the fractional part of
     * decimal LonLat coordinates.
     *
     * For example 3.14 has 2 digits in it's fractional part.
     *
     * Default number of fractional digits displayed is 5.
     *
     */
    public void setNumDigits(int numDigits)
    {
        getJSObject().setProperty("numDigits", numDigits);
    }

    /**
     * The separator between the Longitude and the Latitude.
     *
     * Default separator is ", ".
     *
     */
    public void setSeparator(String separator)
    {
        getJSObject().setProperty("separator", separator);
    }

    /**
     * Text displayed before coordinates:
     *
     * prefixHere 0.00000, 0.0000
     *
     */
    public void setPrefix(String prefix)
    {
        getJSObject().setProperty("prefix", prefix);
    }

    /**
     * Text displayed after coordinates:
     *
     * 0.00000, 0.0000 suffixHere
     *
     */
    public void setSuffix(String suffix)
    {
        getJSObject().setProperty("suffix", suffix);
    }

    /**
     *
     * Default granularity is 10.
     *
     */
    public void setGranularity(int granularity)
    {
        getJSObject().setProperty("granularity", granularity);
    }

}
