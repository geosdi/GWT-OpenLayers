/**
 *
 */
package com.eg.gwt.openLayers.client;

import com.google.gwt.user.client.Element;

/**
 * Serves as a base class for making Option objects that
 * only expose options specific to a given OpenLayers class.
 *
 * There is a lot of overlaps of OptionsBase with Options. However, OptionsBase
 *      - intentionally does not extend OpenLayersWidget, and
 *      - hides it's methods for non-children
 *
 * Use Options to set arbitrary properties.
 *      [insert example here]
 *
 * Use Objects that extend OptionsBase to set class specific properties.
 *      [insert example here]
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class OptionsBase {

    private JSObject options;

    protected OptionsBase(){
        this.options = OptionsBaseImpl.create();
    }

    public JSObject getJSObject(){
        return this.options;
    }

    protected void setAttribute(String attr, boolean value)
    {
        ElementHelper.setAttribute(getJSObject(), attr, value);
    }

    protected void setAttribute(String attr, int value)
    {
        ElementHelper.setAttribute(getJSObject(), attr, value);
    }

    protected void setAttribute(String attr, int[] value)
    {
        setAttribute(attr, new JIntArray(value).getJSObject());
    }

    protected void setAttribute(String attr, double value)
    {
       ElementHelper.setAttribute(getJSObject(), attr, value);
    }

    protected void setAttribute(String attr, String value)
    {
        ElementHelper.setAttribute(getJSObject(), attr, value);
    }

    protected void setAttribute(String attr, Element value)
    {
        ElementHelper.setAttribute(getJSObject(), attr, value);
    }

    protected void setAttribute(String attr, JSObject value)
    {
        ElementHelper.setAttribute(getJSObject(), attr, value);
    }

    protected void setAttribute(String attr, JObjectArray value)
    {
        ElementHelper.setAttribute(getJSObject(), attr, value.getJSObject());
    }

    protected String getAttribute(String attr)
    {
        return ElementHelper.getAttribute(getJSObject(), attr);
    }

    protected boolean getAttributeAsBoolean(String attr)
    {
        return ElementHelper.getAttributeAsBoolean(getJSObject(), attr);
    }

    protected double getAttributeAsDouble(String attr)
    {
        return ElementHelper.getAttributeAsDouble(getJSObject(), attr);
    }

    protected Element getAttributeAsElement(String attr)
    {
        return ElementHelper.getAttributeAsElement(getJSObject(), attr);
    }

    protected JSObject getAttributeAsJSObject(String attr)
    {
        return ElementHelper.getAttributeAsJSObject(getJSObject(), attr);
    }

    protected int getAttributeAsInt(String attr)
    {
        return ElementHelper.getAttributeAsInt(getJSObject(), attr);
    }

    //TODO Perhaps move these back to helper methods
    protected int[] getAttributeAsIntArray(String attr)
    {
        return new JIntArray(getAttributeAsJSObject(attr)).toArray();
    }

    protected String[] getAttributes()
    {
        JSObject attributes = ElementHelper.getAttributes(getJSObject());

        int size = ElementHelper.arrayLength(attributes);
        String[] rtn = new String[size];

        for(int i = 0; i < size; i++)
        {
            JSObject elem = ElementHelper.getElementFromArray(attributes, i);
            rtn[i] = ElementHelper.getAttributeName(elem);
        }

        return rtn;

    }

}
