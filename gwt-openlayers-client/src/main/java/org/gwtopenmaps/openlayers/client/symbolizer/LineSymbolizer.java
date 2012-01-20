/**
 *
 */
package org.gwtopenmaps.openlayers.client.symbolizer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author lorenzo
 *
 */
public class LineSymbolizer extends Symbolizer
{

    protected LineSymbolizer(JSObject jsObject)
    {
        super(jsObject);
        // TODO Auto-generated constructor stub
    }

    public LineSymbolizer(LineSymbolizerOptions options)
    {

        this(LineSymbolizerImpl.create(options.getJSObject()));
    }

}
