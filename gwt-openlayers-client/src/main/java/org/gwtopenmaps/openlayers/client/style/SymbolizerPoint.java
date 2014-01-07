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

/**
 * Create a symbolizer for rendering points
 * @author Maciej Jezierski - Pinocchio
 *
 */
public class SymbolizerPoint extends SymbolizerPolygon
{

    public SymbolizerPoint()
    {
        super(SymbolizerPointImpl.create());
    }

    public void setPointRadius(double radius)
    {
        SymbolizerPointImpl.setPointRadius(this.getJSObject(), radius);
    }

    public double getPointRadius()
    {
        return SymbolizerPointImpl.getPointRadius(this.getJSObject());
    }

    public void setExternalGraphic(String url)
    {
        SymbolizerPointImpl.setExternalGraphic(this.getJSObject(), url);
    }

    public String getExternalGraphic()
    {
        return SymbolizerPointImpl.getExtenalGraphic(this.getJSObject());
    }

    public void setGraphicWidth(int width)
    {
        SymbolizerPointImpl.setGraphicWidth(this.getJSObject(), width);
    }

    public int getGraphicWidth()
    {
        return SymbolizerPointImpl.getGraphicWidth(this.getJSObject());
    }

    public void setGraphicHeight(int height)
    {
        SymbolizerPointImpl.setGraphicHeight(this.getJSObject(), height);
    }

    public int getGraphicHeight()
    {
        return SymbolizerPointImpl.getGraphicHeight(this.getJSObject());
    }

    public void setGraphicOpacity(double opacity)
    {
        SymbolizerPointImpl.setGraphicOpacity(this.getJSObject(), opacity);
    }

    public double getGraphicOpacity()
    {
        return SymbolizerPointImpl.getGraphicOpacity(this.getJSObject());
    }

    public void setGraphicXOffset(int offset)
    {
        SymbolizerPointImpl.setGraphicXOffset(this.getJSObject(), offset);
    }

    public int getGraphicXOffset()
    {
        return SymbolizerPointImpl.getGraphicXOffset(this.getJSObject());
    }

    public void setGraphicYOffset(int offset)
    {
        SymbolizerPointImpl.setGraphicYOffset(this.getJSObject(), offset);
    }

    public int getGraphicYOffset()
    {
        return SymbolizerPointImpl.getGraphicYOffset(this.getJSObject());
    }

    public void setRotation(double rotation)
    {
        SymbolizerPointImpl.setRotation(this.getJSObject(), rotation);
    }

    public double getRotation()
    {
        return SymbolizerPointImpl.getRotation(this.getJSObject());
    }

    public void setGraphicName(String name)
    {
        SymbolizerPointImpl.setGraphicName(this.getJSObject(), name);
    }

    public String getGraphicName()
    {
        return SymbolizerPointImpl.getGraphicName(this.getJSObject());
    }
}
