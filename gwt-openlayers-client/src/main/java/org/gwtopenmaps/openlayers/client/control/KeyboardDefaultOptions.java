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
