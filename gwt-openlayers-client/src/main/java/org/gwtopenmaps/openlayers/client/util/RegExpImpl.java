package org.gwtopenmaps.openlayers.client.util;

class RegExpImpl {

	public static native JSObject create(String regexString)/*-{
		return new RegExp(regexString);
	}-*/;
	
	public static native JSObject create(String regexString, String modifier)/*-{
		return new RegExp(regexString, modifier);
	}-*/;

	public static native JSObject exec(JSObject object, String str)/*-{
		return new RegExp(regexString, str);
	}-*/;
}
