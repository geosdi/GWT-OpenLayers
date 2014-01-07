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

import org.gwtopenmaps.openlayers.client.control.ModifyFeature.OnModificationEndListener;
import org.gwtopenmaps.openlayers.client.control.ModifyFeature.OnModificationListener;
import org.gwtopenmaps.openlayers.client.control.ModifyFeature.OnModificationStartListener;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * Options specific to Modify Feature Control.
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ModifyFeatureOptions extends ControlOptions
{

    public void setClickout(boolean clickout)
    {
        getJSObject().setProperty("clickout", clickout);
    }

    public void setToggle(boolean toggle)
    {
        getJSObject().setProperty("toggle", toggle);
    }

    public void setDeleteCodes(int[] deleteCodes)
    {
        // TODO make the JSArray for the deleteCodes and pass it in... This just shuts off all deleting.
        getJSObject().setProperty("deleteCodes", JSObject.createJSObject());
    }

    public void setMode(int mode)
    {
        getJSObject().setProperty("mode", mode);
    }


    public void setStandalone(boolean standalone)
    {
        getJSObject().setProperty("standalone", standalone);
    }

    public void onModificationStart(OnModificationStartListener listener)
    {
        JSObject callback = ModifyFeatureImpl.createOnModificationStartCallback(listener);
        getJSObject().setProperty("onModificationStart", callback);
    }

    public void onModification(OnModificationListener listener)
    {
        JSObject callback = ModifyFeatureImpl.createOnModificationCallback(listener);
        getJSObject().setProperty("onModification", callback);
    }

    public void onModificationEnd(OnModificationEndListener listener)
    {
        JSObject callback = ModifyFeatureImpl.createOnModificationEndCallback(listener);
        getJSObject().setProperty("onModificationEnd", callback);
    }
}
