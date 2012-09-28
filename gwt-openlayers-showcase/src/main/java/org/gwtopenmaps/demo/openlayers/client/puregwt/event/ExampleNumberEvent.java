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
package org.gwtopenmaps.demo.openlayers.client.puregwt.event;

import com.google.gwt.event.shared.GwtEvent;
import org.gwtopenmaps.demo.openlayers.client.puregwt.handler.ExampleNumberHandler;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class ExampleNumberEvent extends GwtEvent<ExampleNumberHandler> {
    
    protected int number;

    @Override
    public Type<ExampleNumberHandler> getAssociatedType() {
        return ExampleNumberHandler.TYPE;
    }

    @Override
    protected void dispatch(ExampleNumberHandler handler) {
        handler.updateExampleNumber(number);
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }
}
