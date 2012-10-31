package org.gwtopenmaps.openlayers.client.control;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class AttributionOptions extends ControlOptions
{

    /**
     * String used to separate layers (from OL docs).
     *
     * Default separator is ", ".
     * @param separator 
     */
    public void setSeparator(String separator)
    {
        getJSObject().setProperty("separator", separator);
    }
    
    /**
     * Template for the attribution.  This has to include the substring “${layers}”, 
     * which will be replaced by the layer specific attributions, separated by 
     * <separator>.  The default is “${layers}”.
     * (from OL docs)
     * @param template 
     */
    public void setTemplate(String template) 
    {
        getJSObject().setProperty("template", template);
    }
}
