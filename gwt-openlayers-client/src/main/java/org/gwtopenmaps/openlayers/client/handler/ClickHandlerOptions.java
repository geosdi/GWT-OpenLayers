/**
 *
 *   Copyright 2015 GWT OpenLayers Team.
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
package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.event.ClickEvent;
import org.gwtopenmaps.openlayers.client.event.ClickListener;
import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * Options for ClickHandler.
 *
 * @author Tino Desjardins - SRP
 *
 */
public class ClickHandlerOptions extends HandlerOptions {

	protected ClickHandlerOptions(JSObject jsObject) {
		super(jsObject);
	}

	public ClickHandlerOptions() {
		this(JSObject.createJSObject());
	}

	public ClickHandlerOptions(ClickListener clickListener) {
        this(JSObject.createJSObject());
        this.setClickListener(clickListener);
    }

	/**
	 *
	 * @param delay Number of milliseconds between clicks before the event is considered a double-click.
	 */
	public void setMulti(int delay) {
		getJSObject().setProperty("delay", delay);
	}

	/**
	 *
	 * @param pixelTolerance Maximum number of pixels between mouseup and mousedown for an event to be considered a click.
	 */
	public void setPixelTolerance(int pixelTolerance) {
        getJSObject().setProperty("pixelTolerance", pixelTolerance);
    }

	/**
	 *
	 * @param doubleClickTolerance Maximum distance in pixels between clicks for a sequence of events to be considered a double click.
	 */
	public void setDoubleClickTolerance(int doubleClickTolerance) {
        getJSObject().setProperty("dblclickTolerance", doubleClickTolerance);
    }

	/**
	 *
	 * @param singleClick Handle single clicks.
	 */
	public void setSingleClick(boolean singleClick) {
        getJSObject().setProperty("single", singleClick);
    }

	/**
	 *
	 * @param doubleClick Handle double-clicks.
	 */
    public void setDoubleClick(boolean doubleClick) {
        getJSObject().setProperty("double", doubleClick);
    }

    /**
     *
     * @param stopSingle Stop other listeners from being notified of clicks.
     */
	public void setStopSingle(boolean stopSingle) {
        getJSObject().setProperty("stopSingle", stopSingle);
    }

	/**
	 *
	 * @param stopDouble Stop other listeners from being notified of double-clicks.
	 */
	public void setStopDouble(boolean stopDouble) {
        getJSObject().setProperty("stopDouble", stopDouble);
    }

	/**
	 *
	 * @param clickListener listener for click-events.
	 */
	public void setClickListener(final ClickListener clickListener) {

	    JSObject callbacks = JSObject.createJSObject();

	    if(clickListener != null) {

	        EventHandler clickHandler = new EventHandler() {

                @Override
                public void onHandle(EventObject eventObject) {
                    clickListener.onClick(new ClickEvent(eventObject));
                }
            };

	        callbacks.setProperty("rightclick", clickHandler.getJSObject());
	        callbacks.setProperty("click", clickHandler.getJSObject());

	        EventHandler doubleClickHandler = new EventHandler() {

                @Override
                public void onHandle(EventObject eventObject) {
                    clickListener.onDoubleClick(new ClickEvent(eventObject));
                }
            };

            callbacks.setProperty("dblclick", doubleClickHandler.getJSObject());

	    }

	    getJSObject().setProperty("callbacks", callbacks);

	}

}
