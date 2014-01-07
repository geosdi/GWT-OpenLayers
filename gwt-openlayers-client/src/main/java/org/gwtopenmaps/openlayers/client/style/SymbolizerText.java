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
package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Maciej Jezierski - Pinocchio
 * A symbolizer used to render text labels for features
 */
public class SymbolizerText extends Symbolizer
{

    public SymbolizerText(JSObject config)
    {
        super(SymbolizerTextImpl.create(config));
    }

    public SymbolizerText()
    {
        super(SymbolizerTextImpl.create());
    }

    public void setLabel(String label)
    {
        SymbolizerTextImpl.setLabel(this.getJSObject(), label);
    }

    public String getLabel()
    {
        return SymbolizerTextImpl.getLabel(this.getJSObject());
    }

    public void setFontFamily(String fontFamily)
    {
        SymbolizerTextImpl.setFontFamily(this.getJSObject(), fontFamily);
    }

    public String getFontFamily()
    {
        return SymbolizerTextImpl.getFontFamily(this.getJSObject());
    }

    public void setFontSize(String fontSize)
    {
        SymbolizerTextImpl.setFontSize(this.getJSObject(), fontSize);
    }

    public String getFontSize()
    {
        return SymbolizerTextImpl.getFontSize(this.getJSObject());
    }

    public void setFontWeight(String fontWeight)
    {
        SymbolizerTextImpl.setFontWeight(this.getJSObject(), fontWeight);
    }

    public String getFontWeight()
    {
        return SymbolizerTextImpl.getFontWeight(this.getJSObject());
    }

    public void setFontStyle(String fontStyle)
    {
        SymbolizerTextImpl.setFontStyle(this.getJSObject(), fontStyle);
    }

    public String getFontStyle()
    {
        return SymbolizerTextImpl.getFontStyle(this.getJSObject());
    }

}
