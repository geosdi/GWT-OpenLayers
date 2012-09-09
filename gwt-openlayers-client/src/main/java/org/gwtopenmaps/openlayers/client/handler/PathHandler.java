package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.Pixel;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class PathHandler extends PointHandler
{

    protected PathHandler(JSObject element)
    {
        super(element);
    }

    public PathHandler()
    {
        this(PathHandlerImpl.create());
    }

    public void click(Pixel pixel) {
		PathHandlerImpl.click(getJSObject(), pixel.getJSObject());
	}

	public static PathHandler narrowTo(Handler h) {
		return h == null ? null : new PathHandler(h.getJSObject());
	}

}
