package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * Format objects provide support for reading and writing text and xml formats.
 *
 * This can be:
 * <ul>
 *  <li> spatial vector formats (GML, KML, WKT, ...) </li>
 *  <li> map description format (WMC) </li>
 *  <li> ... </li>
 * </ul>
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public abstract class Format extends OpenLayersObjectWrapper
{

    protected Format(JSObject format)
    {
        super(format);
    }

    // Formats have a read and write method.
    // Subtypes of Format use FormatImpl to implement their read and write methods.

    // The read method takes a String and returns an object.
    // This object, and therefore the return type of the method may differ between formats.
    // Java does not support variable return types.


    // The write method takes an object and writes a String.
    // Each format expects a specific type of object to write,
    // therefore no generic write method is implemented here.

}
