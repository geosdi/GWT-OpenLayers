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

import org.gwtopenmaps.openlayers.client.strategy.Strategy;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Maciej Jezierski - Pinocchio, lorenzo
 * A simple strategy that requests features once and never requests new data
 *
 */
public class FixedStrategy extends Strategy {

    /**
     * TODO ahhughes - should this be public or private?
     * @param strategy
     */
    protected FixedStrategy(JSObject strategy) {
        super(strategy);
    }

    public FixedStrategy(FixedStrategyOptions options) {
        this(FixedStrategyImpl.create(options.getJSObject()));
    }

    public FixedStrategy(JSObject strategy, boolean preload) {
        super(strategy);
        preload(preload);
    }

    public FixedStrategy(boolean preload) {
        this(FixedStrategyImpl.create(), preload);
    }

    public FixedStrategy() {
        this(FixedStrategyImpl.create());
    }


    /**
     * Clean up the strategy.
     */
    public void destroy() {
        FixedStrategyImpl.destroy(this.getJSObject());
    }

    /**
     * Load data before layer made visible.  Enabling this may result in considerable overhead if your application loads many data layers that are not visible by default.  Default is false.
     * @param preload
     */
    public void preload(boolean preload) {
        FixedStrategyImpl.preload(this.getJSObject(), preload);
    }
}
