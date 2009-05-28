package org.gwtopenmaps.openlayers.client.util;




/**
 *
 *
 */
public class JArrayBase extends JSObjectWrapper {

	protected JArrayBase(JSObject element)
	{
		super(element);
	}

	public static JArrayBase narrowToJArray(JSObject element)
	{
		return (element == null)?null: new JArrayBase(element);
	}

	protected JArrayBase(int length)
	{
		this(JArrayBaseImpl.create(length));
	}

	public int length()
	{
		return JArrayBaseImpl.arrayLength(getJSObject());
	}
}
