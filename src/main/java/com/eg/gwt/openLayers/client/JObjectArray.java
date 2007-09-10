package com.eg.gwt.openLayers.client;


public class JObjectArray extends JArrayBase 
{
	protected JObjectArray(JSObject element)
	{
		super(element);
	}
	
	public static JObjectArray narrowToJElementArray(JSObject element)
	{
		return (element == null)?null: new JObjectArray(element);
	}
	
	public JObjectArray(JSObject[] array)
	{
		super(array.length);
		
		for(int i = 0; i < array.length; i++)
		{
			set(i, array[i]);
		}
	}
	
	public void set(int index, JSObject value)
	{
		JObjectArrayImpl.arraySet(getJSObject(), index, value);
	}
	
	public JSObject get(int index)
	{
		return JObjectArrayImpl.getAsJSObject(getJSObject(), index);
	}
	
	public JSObject[] toArray()
	{
		JSObject[] rtn = new JSObject[length()];

		for(int i = 0; i < rtn.length; i++)
		{
			if (JObjectArrayImpl.isNumber(getJSObject(), i))
			{
				rtn[i] = JObjectArrayImpl.getNumberAsJSObject(getJSObject(), i);
			}
			else if (JObjectArrayImpl.isBoolean(getJSObject(), i))
			{
				rtn[i] = JObjectArrayImpl.getBooleanAsJSObject(getJSObject(), i);
			}
			else rtn[i] = JObjectArrayImpl.getAsJSObject(getJSObject(), i);
		}
		
		return rtn;
	}
	
}
