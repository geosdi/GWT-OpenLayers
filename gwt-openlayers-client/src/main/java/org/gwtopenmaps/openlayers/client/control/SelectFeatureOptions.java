package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.RenderIntent;
import org.gwtopenmaps.openlayers.client.control.SelectFeature.ClickFeatureListener;
import org.gwtopenmaps.openlayers.client.control.SelectFeature.SelectFeatureListener;
import org.gwtopenmaps.openlayers.client.control.SelectFeature.UnselectFeatureListener;
import org.gwtopenmaps.openlayers.client.event.EventType;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * See {@link SelectFeature}.
 *
 * Default mode of selection is clickout, see {@link SelectFeature}.
 *
 * @author Edwin Commandeur - Atlis EJS
 * @author Rafael Ceravolo - LOGANN
 *
 */
public class SelectFeatureOptions extends ControlOptions
{

    /**
     * Indicates that the selection of the feature should occur when the mouse
     * hovers the feature rather then when clicked. Defaults to <b>false</b>.
     * <p>
     * Note: the behavior of the selection on hover depends also of the
     * highlightOnly property
     */
    public void setHover()
    {
        getJSObject().setProperty("hover", true);
    }

    /**
     * Indicates that when clicking a already selected feature again, it will be
     * unselected. Defaults to <b>false</b>.
     */
    public void setToggle()
    {
        getJSObject().setProperty("toggle", true);
    }

    /**
     * Indicates that the user can select multiple features at the same time.
     * Defaults to <b>false</b>.
     */
    public void setMultiple()
    {
        getJSObject().setProperty("multiple", true);
    }

    /**
     * Triggers when a feature is selected.
     *
     * TODO: Can this be added to SelectFeature? Or should it be set at construction time?
     * it doesn't work via event object, so removeListener will not work
     * the name should therefore not be addSelectFeature...
     */
    public void onSelect(SelectFeatureListener listener)
    {
        JSObject callback = SelectFeatureImpl.createSelectFeatureCallback(listener);
        getJSObject().setProperty(EventType.CONTROL_SELECT_FEATURE_SELECT, callback);
    }

    /**
     * Triggers when a feature is unselected.
     *
     * TODO: Can this be added to SelectFeature? Or should it be set at construction time?
     * it doesn't work via event object, so removeListener will not work
     * the name should therefore not be addUnSelectFeature...
     */
    public void onUnSelect(UnselectFeatureListener listener)
    {
        JSObject callback = SelectFeatureImpl.createUnselectFeatureCallback(listener);
        getJSObject().setProperty(EventType.CONTROL_SELECT_FEATURE_UNSELECT, callback);
    }

    /**
     * Triggers when a feature is clicked
     *
     * TODO: Same concern that for onSelect and onUnSelect ?
     */
    public void clickFeature(ClickFeatureListener listener)
    {
        JSObject callback = SelectFeatureImpl.createClickFeatureCallback(listener);
        getJSObject().setProperty("clickFeature", callback);
    }

    /**
     * From OpenLayers documentation: If true do not actually select features
     * (i.e. place them in the layer's selected features array), just highlight
     * them. This property has no effect if hover is false. Defaults to
     * <b>false</b>.
     *
     * @param highlightOnly
     *            The property value
     */
    public void setHighlightOnly(boolean highlightOnly)
    {
        getJSObject().setProperty("highlightOnly", highlightOnly);
    }

    /**
     * Sets the render intent of the styles to be used when drawing the features
     * on the selected state controled by the SelectFeature.Defaults to <b>
     * DEFAULT</b>.
     *
     * @param renderIntent
     *            The render intent to be used
     */
    public void setRenderIntent(RenderIntent renderIntent)
    {
        if (renderIntent != null)
        {
            getJSObject().setProperty("renderIntent", renderIntent.getValue());
        }
    }

    /**
     * Allows features to be selected by dragging a box.
     */
    public void setBox(boolean box)
    {
        getJSObject().setProperty("box", box);
    }

}
