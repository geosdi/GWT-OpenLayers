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
package org.gwtopenmaps.openlayers.client.handler.chain;

import org.gwtopenmaps.openlayers.client.handler.Handler;
import org.gwtopenmaps.openlayers.client.handler.PolygonHandler;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class PolygonChainHandler extends ChainHandler {

    public PolygonChainHandler() {
        super.setSuccessor(new RegularPolygonChainHandler());
    }

    @Override
    public <H extends Handler> H buildHandler(JSObject jsObject) {
        return (H) ((super.canBuildHandler(jsObject.getPropertyAsString(
                "CLASS_NAME")))
                ? PolygonHandler.narrowToHandler(jsObject)
                : super.forwardBuildHandler(jsObject));
    }

    @Override
    protected String getClassHandlerType() {
        return Handler.POLYGON_HANDLER_CLASS_NAME;
    }

}
