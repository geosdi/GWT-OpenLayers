/**
 *
 *   Copyright 2013 sourceforge.
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
 * Create a symbolizer for rendering lines.
 */

public class SymbolizerLine extends Symbolizer
{

    public SymbolizerLine()
    {
        super(SymbolizerLineImpl.create());
    }

    protected SymbolizerLine(JSObject object)
    {
        super(object);
    }

    public void setStorkeColor(String color)
    {
        SymbolizerLineImpl.setStorkeColor(this.getJSObject(), color);
    }

    public String getStorkeColor()
    {
        return SymbolizerLineImpl.getStorkeColor(this.getJSObject());
    }

    public void setStorkeOpacity(double opacity)
    {
        SymbolizerLineImpl.setStorkeOpacity(this.getJSObject(), opacity);
    }

    public double getStorkeOpacity()
    {
        return SymbolizerLineImpl.getStorkeOpacity(this.getJSObject());
    }

    public void setStorkeWidth(int width)
    {
        SymbolizerLineImpl.setStorkeWidth(this.getJSObject(), width);
    }

    public int getStorkeWidth()
    {
        return SymbolizerLineImpl.getStorkeWidth(this.getJSObject());
    }

    /**
     *
     * @param linecap Stroke cap type (“butt�?, “round�?, or “square�?).
     */
    public void setLinecap(String linecap)
    {
        SymbolizerLineImpl.setLinecap(this.getJSObject(), linecap);
    }

    public String getLinecap()
    {
        return SymbolizerLineImpl.getLinecap(this.getJSObject());
    }


    /**
     * Stroke dash style according to the SLD spec.  Note that the OpenLayers values for strokeDashstyle (“dot�?, “dash�?, “dashdot�?, “longdash�?, “longdashdot�?, or “solid�?) will not work in SLD, but most SLD patterns will render correctly in OpenLayers
     * @param dashstyle
     */
    public void setDashstyle(String dashstyle)
    {
        SymbolizerLineImpl.setDashstyle(this.getJSObject(), dashstyle);
    }

    public String getDashstyle()
    {
        return SymbolizerLineImpl.getDashstyle(this.getJSObject());
    }
}
