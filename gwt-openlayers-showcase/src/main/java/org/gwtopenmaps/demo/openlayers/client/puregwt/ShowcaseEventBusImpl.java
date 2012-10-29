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
package org.gwtopenmaps.demo.openlayers.client.puregwt;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class ShowcaseEventBusImpl implements ShowcaseEventBus {
    
    private SimpleEventBus eventBus = new SimpleEventBus();
    
    public <T extends EventHandler> HandlerRegistration addHandler(Type<T> type,
            T handler) {
        return eventBus.addHandler(type, handler);
    }
    
    public <T extends EventHandler> HandlerRegistration addHandlerToSource(
            Type<T> type,
            Object source, T handler) {
        return eventBus.addHandlerToSource(type, source, handler);
    }
    
    public void fireEvent(GwtEvent<?> event) {
        eventBus.fireEvent(event);
    }
    
    public void fireEventFromSource(GwtEvent<?> event, Object source) {
        eventBus.fireEventFromSource(event, source);
    }
}
