package org.gwtopenmaps.openlayers.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.ScriptElement;

/**
 * Script injector that can inject script from a resource.
 * @author fks/Frank Wynants
 *
 */
public final class ScriptInjector
{
    /** Keeps track if script was allready injected. */
    private static List<String> scriptIsInjected = new ArrayList<String>();

    /** The head element to inject in. */
    private static HeadElement head;

    // ===============================================================
    /**
     * Private utility class constructor.
     */
    private ScriptInjector()
    {

    }

    // ===============================================================
    /**
     * Inject public resource script file as a file.
     * @param filename inject file name
     */
    public static void injectResourceScriptAsFile(String filename)
    {
        if (!scriptIsInjected.contains(filename))
        {
            ScriptElement link = Document.get().createScriptElement();
            link.setAttribute("language", "javascript");
            link.setText(filename);
            getHead().appendChild(link);

            scriptIsInjected.add(filename);
        }
    }

    // ================================================================
    /**
     * Get the head element.
     * @return The update HeadElement
     */
    private static HeadElement getHead()
    {
        if (head == null)
        {
            Element elt = Document.get().getElementsByTagName("head").getItem(0);
            assert elt != null : "The host HTML page does not have a <head> element"
                    + " which is required by StyleInjector";
            head = HeadElement.as(elt);
        }
        return head;
    }
}