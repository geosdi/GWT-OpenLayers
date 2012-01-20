package org.gwtopenmaps.openlayers.client.control;

/**
 *
 * @author giuseppe
 *
 */
public class NavigationHistoryOptions extends ControlOptions
{

    /**
     * APIProperty: limit {Integer} Optional limit on the number of history
     * items to retain. If null, there is no limit. Default is 50.
     */
    public void setLimit(int limit)
    {
        getJSObject().setProperty("limit", limit);
    }

    /**
     * APIProperty: autoActivate {Boolean} Activate the control when it is added
     * to a map. Default is true.
     */
    public void setAutoActivate(boolean autoActivate)
    {
        getJSObject().setProperty("autoActivate", autoActivate);
    }

    /**
     * Property: clearOnDeactivate {Boolean} Clear the history when the control
     * is deactivated. Default is false.
     */
    public void setClearOnDeactivate(boolean clearOnDeactivate)
    {
        getJSObject().setProperty("clearOnDeactivate", clearOnDeactivate);
    }

}
