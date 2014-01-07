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
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.OpenLayersEObjectWrapper;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Lorenzo Amato - CNR IMAA geoSDI Group
 * @email lorenzo.amato@geosdi.org
 *
 */
public class SnappingTarget extends OpenLayersEObjectWrapper
{

    public SnappingTarget(JSObject openLayersObject)
    {
        super(openLayersObject);
        // TODO Auto-generated constructor stub
    }

    public SnappingTarget()
    {
        super(JSObject.createJSObject());
    }

    /**
     *
     * @param layer
     */
    public void setLayer(Vector layer)
    {
        getJSObject().setProperty("layer", layer.getJSObject());
    }

    /**
     *
     * @return Vector
     */
    public Vector getLayer()
    {
        return Vector.narrowToVector(getJSObject().getProperty("layer"));
    }

    /**
     *
     * @return Tolerance
     */
    public Float getTolerance()
    {
        return getJSObject().getPropertyAsFloat("tolerance");
    }

    /**
     *
     * @param tolerance
     */
    public void setTolerance(Float tolerance)
    {
        getJSObject().setProperty("tolerance", tolerance);
    }

    /**
     *
     * @return boolean
     */
    public boolean getNode()
    {
        return getJSObject().getPropertyAsBoolean("node");
    }

    /**
     *
     * @param node
     */
    public void setNode(boolean node)
    {
        getJSObject().setProperty("node", node);
    }

    /**
     *
     * @return Node Tolerance
     */
    public Float getNodeTolerance()
    {
        return getJSObject().getPropertyAsFloat("nodeTolerance");
    }

    /**
     *
     * @param nodeTolerance
     */
    public void setNodeTolerance(Float nodeTolerance)
    {
        getJSObject().setProperty("nodeTolerance", nodeTolerance);
    }

    /**
     *
     * @return boolean
     */
    public boolean getVertex()
    {
        return getJSObject().getPropertyAsBoolean("vertex");
    }

    /**
     *
     * @param vertex
     */
    public void setVertex(boolean vertex)
    {
        getJSObject().setProperty("vertex", vertex);
    }

    /**
     *
     * @return Vertex Tolerance
     */
    public Float getVertexTolerance()
    {
        return getJSObject().getPropertyAsFloat("vertexTolerance");
    }

    /**
     *
     * @param vertexTolerance
     */
    public void setVertexTolerance(Float vertexTolerance)
    {
        getJSObject().setProperty("vertexTolerance", vertexTolerance);
    }

    /**
     *
     * @return boolean
     */
    public boolean getEdge()
    {
        return getJSObject().getPropertyAsBoolean("edge");
    }

    /**
     *
     * @param edge
     */
    public void setEdge(boolean edge)
    {
        getJSObject().setProperty("edge", edge);
    }

    /**
     *
     * @return Edge Tolerance
     */
    public Float getEdgeTolerance()
    {
        return getJSObject().getPropertyAsFloat("edgeTolerance");
    }

    /**
     *
     * @param edgeTolerance
     */
    public void setEdgeTolerance(Float edgeTolerance)
    {
        getJSObject().setProperty("edgeTolerance", edgeTolerance);
    }

}
