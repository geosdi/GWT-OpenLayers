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


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class NavigationOptions extends ControlOptions
{

    public void setZoomWheelEnabled(boolean zoomWheelEnabled)
    {
        getJSObject().setProperty("zoomWheelEnabled", zoomWheelEnabled);
    }

    public void setHandleRightClicks(boolean handleRightClicks)
    {
        getJSObject().setProperty("handleRightClicks", handleRightClicks);
    }

    /**
     *
     * @param zoomBoxKeyMask - by default ... (shift)
     */
    public void setZoomBoxKeyMask(int zoomBoxKeyMask)
    {
        getJSObject().setProperty("zoomBoxKeyMask", zoomBoxKeyMask);
    }
    
    /**
     * Set options passed to the DragPan control
     * @param dragPanOptions 
     */
    public void setDragPanOptions(DragPanOptions dragPanOptions)
    {
        getJSObject().setProperty("dragPanOptions", dragPanOptions.getJSObject());
    }
    
    /**
     * Set options passed to the PinchZoom control
     * @param pinchZoomOptions 
     */
    public void setPinchZoomOptions(PinchZoomOptions pinchZoomOptions)
    {
        getJSObject().setProperty("pinchZoomOptions", pinchZoomOptions.getJSObject());
    }
}
