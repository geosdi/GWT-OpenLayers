package org.gwtopenmaps.openlayers.client.util;

/**
 * Wrapper for the JavaScript RegExp object.
 * 
 * A regular expression can be instantiated using the RegExp constructor as in JavaScript.
 * See also: 
 * <ul>
 * <li>http://www.w3schools.com/jsref/jsref_obj_regexp.asp</li>
 * <li>http://www.regular-expressions.info/javascript.html</li>
 * </ul>
 * 
 * @author Edwin Commandeur - Atlis Information Systems
 *
 */
public class RegExp extends JSObjectWrapper {

	protected RegExp(JSObject jsObject) {
		super(jsObject);
	}

	public RegExp(String regexString){
		super(RegExpImpl.create(regexString));
	}
	
	public RegExp(String regexString, String modifier){
		super(RegExpImpl.create(regexString, modifier));
	}
	
	public JSObject exec(String str){
		return RegExpImpl.exec(getJSObject(), str);
	}
}
