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
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.UmbrellaException;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public interface ShowcaseEventBus {

    /**
     * Adds an unfiltered handler to receive events of this type from all
     * sources. <p> It is rare to call this method directly. More typically a
     * {@link GwtEvent} subclass will provide a static
     * <code>register</code> method, or a widget will accept handlers directly.
     * <p> A tip: to make a handler de-register itself, the following works:
     * <code><pre>new MyHandler() {
     *  HandlerRegistration reg = MyEvent.register(eventBus, this);
     *
     *  public void onMyThing(MyEvent event) {
     *    {@literal /}* do your thing *{@literal /} reg.removeHandler(); } };
     * </pre></code>
     *
     * @param <H> The type of handler
     * @param type the event type associated with this handler
     * @param handler the handler
     * @return the handler registration, can be stored in order to remove the
     * handler later
     */
    <T extends EventHandler> HandlerRegistration addHandler(
            GwtEvent.Type<T> type,
            T handler);

    /**
     * Adds a handler to receive events of this type from the given source. <p>
     * It is rare to call this method directly. More typically a
     * {@link GwtEvent} subclass will provide a static
     * <code>register</code> method, or a widget will accept handlers directly.
     *
     * @param <H> The type of handler
     * @param type the event type associated with this handler
     * @param source the source associated with this handler
     * @param handler the handler
     * @return the handler registration, can be stored in order to remove the
     * handler later
     */
    <T extends EventHandler> HandlerRegistration addHandlerToSource(
            GwtEvent.Type<T> type, Object source, T handler);

    /**
     * Fires the event from no source. Only unfiltered handlers will receive it.
     *
     * @param event the event to fire
     */
    void fireEvent(GwtEvent<?> event);

    /**
     * Fires the given event to the handlers listening to the event's type. <p>
     * Any exceptions thrown by handlers will be bundled into a
     * {@link UmbrellaException} and then re-thrown after all handlers have
     * completed. An exception thrown by a handler will not prevent other
     * handlers from executing.
     *
     * @param event the event to fire
     */
    void fireEventFromSource(GwtEvent<?> event, Object source);
}
