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

/**
 * The options object to be passed to CRUD methods of WFSProtocol.
 * The callback is necessary, therefore the public constructor forces its use.
 *
 * @author Mikael Couzic
 */
public class WFSProtocolCRUDOptions extends CRUDOptions
{

    public WFSProtocolCRUDOptions(Callback callback)
    {
        super(WFSProtocolCRUDOptionsImpl.create(callback));
    }

}
