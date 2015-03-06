/**
 *
 *   Copyright 2015 sourceforge.
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