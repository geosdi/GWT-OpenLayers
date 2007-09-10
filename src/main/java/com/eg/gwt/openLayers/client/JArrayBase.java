package com.eg.gwt.openLayers.client;




public class JArrayBase extends OpenLayersWidget {

	protected JArrayBase(JSObject element) 
	{
		super(element);
	}
	
	public static JArrayBase narrowToGoogleMapsWidgetArray(JSObject element)
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
