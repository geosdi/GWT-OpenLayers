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
package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Rafael Ceravolo
 */
public class RendererOptions extends OpenLayersObjectWrapper
{
    protected RendererOptions(JSObject element)
    {
        super(element);
    }

    public RendererOptions()
    {
        this(JSObject.createJSObject());

    }

    /**
     * Whether to use yOrdering. If yOrdering is enabled, geometries with lower
     * latitude will be draw on top of others geometries with bigger latitude.
     *
     * @param yOrdering
     *            The value of the property to set. Default is false.
     */
    public void setYOrdering(boolean yOrdering)
    {
        this.getJSObject().setProperty("yOrdering", yOrdering);
    }

    /**
     * Get the yOrdering property
     *
     * @return The property value.
     */
    public boolean getYOrdering()
    {
        return this.getJSObject().getPropertyAsBoolean("yOrdering");
    }

    /**
     * Whether to use z-indexing. Will be ignored if yOrdering is set to true.
     *
     * @param zIndexing
     *            The value of the property to set. Default is false.
     */
    public void setZIndexing(boolean zIndexing)
    {
        this.getJSObject().setProperty("zIndexing", zIndexing);
    }

    /**
     * Get the yOrdering property
     *
     * @return The property value
     */
    public boolean getZIndexing()
    {
        return this.getJSObject().getPropertyAsBoolean("zIndexing");
    }
}
;
