package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.LonLat;
import com.eg.gwt.openLayers.client.Map;
import com.eg.gwt.openLayers.client.util.OptionsBase;

/**
 * See {@link MousePosition}.
 *
 * @author Edwin Commandeur - Atlis EJS
 * @since GWT-OL 0.4
 *
 */
public class MousePositionOptions extends OptionsBase {

	/**
	 * <p>
	 * The output of the MousePosition control is determined by
	 * the formatOutput function of MouseOptions. The format used
	 * is:<pre>
	 *      prefix + longitude + separator + latitude + postfix
	 * </pre>
	 * The prefix, number of significant digits of the longitude and latitude,
	 * the separator, and the postfix can all be changed, but sometimes
	 * it is desirable to change the format.
	 * </p><p>
	 * In OpenLayers you would override the formatOutput function to customize
	 * the format in which the geographic coordinates are displayed.
	 *
	 * In GWT-OpenLayers the same effect can be achieved by passing
	 * an instance of MousePositionOutput with a custom format
	 * function, see {@link MousePositionOutput}. For example:
	 *
	 * <pre>
	 *     MousePositionOutput mpOut = new MousePositionOutput(){
	 *         public String format(LonLat lonLat, Map map){
	 *              String out = "";
	 *              out += lonLat.lon();
	 *              out += ", ";
	 *              out += lonLat.lat();
	 *              return out;
	 *         }
	 *     };
	 *     setFormatOutput(mpOut);
	 * </pre>
	 * </p>
	 * @since GWT-OL 0.4
	 */
	public void setFormatOutput(MousePositionOutput output){
		setAttribute("formatOutput", MousePositionImpl.formatOutput(output));
	}

	/**
	 * The number of digits to display in the fractional part of
	 * decimal LonLat coordinates.
	 *
	 * For example 3.14 has 2 digits in it's fractional part.
	 *
	 * Default number of fractional digits displayed is 5.
	 *
	 * @since GWT-OL 0.4
	 */
	public void setNumDigits(int numDigits){
		setAttribute("numDigits", numDigits);
	}

	/**
	 * The separator between the Longitude and the Latitude.
	 *
	 * Default separator is ", ".
	 *
	 * @since GWT-OL 0.4
	 */
	public void setSeparator(String separator){
		setAttribute("separator", separator);
	}

	/**
	 * Text displayed before coordinates:
	 *
	 * prefixHere 0.00000, 0.0000
	 *
	 * @since GWT-OL 0.4
	 */
	public void setPrefix(String prefix){
		setAttribute("prefix", prefix);
	}

	/**
	 * Text displayed after coordinates:
	 *
	 * 0.00000, 0.0000 suffixHere
	 *
	 * @since GWT-OL 0.4
	 */
	public void setSuffix(String suffix){
		setAttribute("suffix", suffix);
	}

	/**
	 *
	 * Default granularity is 10.
	 *
	 * @since GWT-OL 0.4
	 */
	public void setGranularity(int granularity){
		setAttribute("granularity", granularity);
	}

}
