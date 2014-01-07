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
/**
 *
 */
package org.gwtopenmaps.openlayers.client.symbolizer;

/**
 * @author lorenzo
 *
 */
public class TextSymbolizerOptions extends SymbolizerOptions
{


    /**
     * APIProperty: fontSize
     * {String} The font size for the label.
     */
    public void setFontSize(String size)
    {
        getJSObject().setProperty("fontSize", size);
    }


    /**
     * APIProperty: label
     * {String} The text for the label.
     */
    public void setLabel(String label)
    {
        getJSObject().setProperty("label", label);
    }


    /**
     * APIProperty: fontFamily
     * {String} The font family for the label.
     */
    public void setFontFamily(String family)
    {
        getJSObject().setProperty("fontFamily", family);
    }


    /**
     * APIProperty: fontWeight
     * {String} The font weight for the label.
     */
    public void setFontWeight(String weight)
    {
        getJSObject().setProperty("fontWeight", weight);
    }


    /**
     * Property: fontStyle
     * {String} The font style for the label.
     */
    public void setFontStyle(String fontStyle)
    {
        getJSObject().setProperty("fontStyle", fontStyle);
    }
}
