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
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class AttributionOptions extends ControlOptions
{

    /**
     * String used to separate layers (from OL docs).
     *
     * Default separator is ", ".
     * @param separator 
     */
    public void setSeparator(String separator)
    {
        getJSObject().setProperty("separator", separator);
    }
    
    /**
     * Template for the attribution.  This has to include the substring “${layers}”, 
     * which will be replaced by the layer specific attributions, separated by 
     * <separator>.  The default is “${layers}”.
     * (from OL docs)
     * @param template 
     */
    public void setTemplate(String template) 
    {
        getJSObject().setProperty("template", template);
    }
}
