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
 * Create a symbolizer for rendering polygons.
 */

public class SymbolizerPolygon extends SymbolizerLine
{

    public SymbolizerPolygon()
    {
        super(SymbolizerPolygonImpl.create());
    }

    protected SymbolizerPolygon(JSObject object)
    {
        super(object);
    }

    public void setFillColor(String color)
    {
        SymbolizerPolygonImpl.setFillColor(this.getJSObject(), color);
    }

    public String getFillColor()
    {
        return SymbolizerPolygonImpl.getFillColor(this.getJSObject());
    }

    public void setFillOpacity(double opacity)
    {
        SymbolizerPolygonImpl.setFillOpacity(this.getJSObject(), opacity);
    }

    public double getFillOpacity()
    {
        return SymbolizerPolygonImpl.getFillOpacity(this.getJSObject());
    }
}
