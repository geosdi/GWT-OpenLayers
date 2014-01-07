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
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.control.Control;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Maciej Jezierski - Pinocchio
 *
 */
public class NavigationHistory extends Control
{

    /**
     * TODO hughesa - should this be protected or public?
     * @param element
     */
    public NavigationHistory(JSObject element)
    {
        super(element);
    }

    public NavigationHistory()
    {
        this(NavigationHistoryImpl.create());
    }

    public NavigationHistory(NavigationHistoryOptions options)
    {
        this(NavigationHistoryImpl.create(options.getJSObject()));
    }

    /**
     * Switch map view to a previous step in browser's history.
     *
     */
    public void previous()
    {
        NavigationHistoryImpl.previous(this.getJSObject());
    }

    /**
     * Switch map view to next step in browser's history.
     *
    */
    public void next()
    {
        NavigationHistoryImpl.next(this.getJSObject());
    }

    /**
     * Optional limit on the number of history items to retain.
     * If null, there is no limit.  Default is 50.
     *
     * @param limit         - number of items
     * @return void
    */
    public void limit(int limit)
    {
        NavigationHistoryImpl.limit(this.getJSObject(), limit);
    }

    /**
     * Activate the control when it is added to a map.
     * Default is true. If set to false, activate() method must
     * be fired in order to use the control with map.
     *
     * @param autoActivate  -  set automatic activation true or false
     * @return void
    */
    public void autoActivate(boolean autoActivate)
    {
        NavigationHistoryImpl.autoActivate(this.getJSObject(), autoActivate);
    }

    /**
     * TODO ahhughes, should this return JSObject or void?
     *
     * APIMethod: nextTrigger Restore the next state. If no items are in the
     * next history stack, this has no effect. The next history stack is
     * populated as states are restored from the previous history stack.
     *
     * Returns: {Object} Item representing state that was restored. Undefined if
     * no items are in the next history stack.
     *
     *
     * @param void
     * @return JSObject     - Item representing state that was restored.  Undefined if no items are in the next history stack.
    */
    public JSObject nextTrigger()
    {
        return NavigationHistoryImpl.nextTrigger(this.getJSObject());
    }

    // lorenzo's work below.....


    /**
     *
     * @return Previous Control
     */
    public Control getPrevious()
    {
        return Control.narrowToControl(NavigationHistoryImpl.getPrevious(getJSObject()));
    }

    /**
     *
     * @return Next Control
     */
    public Control getNext()
    {
        return Control.narrowToControl(NavigationHistoryImpl.getNext(getJSObject()));
    }

    /**

     */

    /**
     * Method: previousTrigger Restore the previous state. If no items are in
     * the previous history stack, this has no effect.
     *
     * Returns: {Object} Item representing state that was restored. Undefined if
     * no items are in the previous history stack.
     */
    public void previousTrigger()
    {
        NavigationHistoryImpl.previousTrigger(getJSObject());
    }

    /**
     * APIMethod: clear Clear history.
     */
    public void clear()
    {
        NavigationHistoryImpl.clear(getJSObject());
    }


}
