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
package org.gwtopenmaps.test.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.strategy.RefreshStrategy;
import org.gwtopenmaps.openlayers.client.strategy.RefreshStrategyOptions;


/**
 * Test for RefreshStrategy.
 *
 * @author T. Desjardins SRP
 *
 */
public class RefreshStrategyTest extends BaseStrategyTest {

    public static final String CLASS_NAME_STRATEGY_REFRESH = "OpenLayers.Strategy.Refresh";

    public void testRefreshStrategy() {

        this.testInstanceByClassName(new RefreshStrategy(), CLASS_NAME_STRATEGY_REFRESH);

        RefreshStrategyOptions refreshStrategyOptions = new RefreshStrategyOptions();
        RefreshStrategy refreshStrategyWithOptions = new RefreshStrategy(refreshStrategyOptions);
        refreshStrategyWithOptions.setForce(true);
        assertEquals(CLASS_NAME_STRATEGY_REFRESH, refreshStrategyWithOptions.getClassName());

    }

}
