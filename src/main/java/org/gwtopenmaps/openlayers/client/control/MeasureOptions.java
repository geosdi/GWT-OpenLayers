/**
 *
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.handler.HandlerOptions;



/**
 * @author Michel Vitor A Rodrigues - Intec
 *
 */
public class MeasureOptions extends ControlOptions{

	/**
	 * Keep the temporary measure sketch or not.
	 *
	 * @param persist - Set to true to keep the temporary measurement sketch drawn after
	 *     the measurement is complete.  The geometry will persist until a new
	 *     measurement is started, the control is deactivated, or <cancel> is called.
	 *     Default is false.
	 */
	public void setPersist(boolean persist){
		getJSObject().setProperty("persist", persist);
	}

	/**
	 * Set non-default handler options. An example is setting a {@link org.gwtopenmaps.openlayers.client.StyleMap}.
	 * <pre>
	 *
	 * control.setHandlerOptions(new BaseGeometryHandlerOptions()
	 *   .setLayerOptions(new HandlerLayerOptions().setStyleMap(styleMap)))
	 *
	 * </pre>
	 *
	 * @param options - {@link org.gwtopenmaps.openlayers.client.handler.BaseGeometryHandlerOptions} or a subclass
	 */
	public void setHandlerOptions(HandlerOptions options){
		getJSObject().setProperty("handlerOptions", options.getJSObject());
	}
}
