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
package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Maciej Jezierski - Pinocchio
 * @author T. Desjardins - SRP
 */
public class RefreshStrategy extends Strategy {

    protected RefreshStrategy(JSObject strategy) {
        super(strategy);
    }

    public RefreshStrategy() {
        this(RefreshStrategyImpl.create());
    }

    public RefreshStrategy(RefreshStrategyOptions options){
        this(RefreshStrategyImpl.create(options.getJSObject()));
    }

    public void refresh() {
        RefreshStrategyImpl.refresh(this.getJSObject());
    }

    /**
     * Force a refresh on the layer, default is false.
     * @param force True to enable force, false to disable (default)
     */
    public void setForce(boolean force) {
        this.getJSObject().setProperty("force", force);
    }

}
