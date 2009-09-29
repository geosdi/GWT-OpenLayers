package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;

public class Handler extends OpenLayersObjectWrapper {

    public final static int MOD_NONE = 0;
    public final static int MOD_SHIFT = 1;
    public final static int MOD_CTRL = 2;
    public final static int MOD_ALT = 4;

	protected Handler(JSObject element) {
		super(element);
	}

}
