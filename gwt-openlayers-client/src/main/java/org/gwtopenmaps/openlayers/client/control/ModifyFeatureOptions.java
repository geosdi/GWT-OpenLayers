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
