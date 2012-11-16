/**
 *
 */
package org.gwtopenmaps.openlayers.client.control;

import com.google.gwt.user.client.Element;

/**
 * @author Todor Todorov
 *
 */
public class KeyboardDefaultOptions extends ControlOptions
{


    /**
     *  Activate the control when it is added to a map.  Default is true.
     */
    public void setAutoActivate(boolean activate)
    {
        getJSObject().setProperty("autoActivate", activate);
    }

    /**
     * Pixels to slide by.
     */
    public void setSlideFactor(int pixels) {
        getJSObject().setProperty("slideFactor", pixels);
    }

    /**
     * The DOM element to handle keys for.
     */
    public void setObserveElement(Element element) {
        getJSObject().setProperty("observeElement", element);
    }

    /**
     * The element Id to handle keys for.
     */
	public void setObserveElement(String id) {
        getJSObject().setProperty("observeElement", id);
	}

}
