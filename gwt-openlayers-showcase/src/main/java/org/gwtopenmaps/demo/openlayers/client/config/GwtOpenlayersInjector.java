/*
 * Copyright 2012 sourceforge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtopenmaps.demo.openlayers.client.config;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import org.gwtopenmaps.demo.openlayers.client.components.ShowcaseExamplePanel;
import org.gwtopenmaps.demo.openlayers.client.components.ShowcaseSearchPanel;
import org.gwtopenmaps.demo.openlayers.client.components.ShowcaseTopPanel;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.demo.openlayers.client.puregwt.ShowcaseEventBus;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@GinModules(value = {GwtOpenlayersInjectorModule.class})
public interface GwtOpenlayersInjector extends Ginjector {

    public ShowcaseEventBus getEventBus();

    public ShowcaseExampleStore getExampleStore();

    public ShowcaseSearchPanel getShowcaseSearchPanel();

    public ShowcaseTopPanel getShowcaseTopPanel();

    public ShowcaseExamplePanel getShowcaseExamplePanel();
}
