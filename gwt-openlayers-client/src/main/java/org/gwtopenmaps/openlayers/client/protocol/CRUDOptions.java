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
package org.gwtopenmaps.openlayers.client.protocol;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;


/**
 * The abstract class for all option objects passed to CRUD protocol methods (Create, Read, Update and Delete).
 * It's main goal is to encapsulate callbacks.
 * When extended, every public constructor must take a <code>Callback</code> parameter.
 *
 * @author Mikael Couzic
 */
public abstract class CRUDOptions extends JSObjectWrapper
{

    protected CRUDOptions(JSObject jsObject)
    {
        super(jsObject);
    }

    /**
     * The callback objects must be encapsulated in option objects, who are then passed as parameters to Create, Read, Update and Delete methods (CRUD).
     * The use of callbacks is a necessity considering the asynchronic nature of the protocols.
     *
     * @author Mikael Couzic
     */
    public interface Callback
    {
        public void computeResponse(Response response);
    }

}
