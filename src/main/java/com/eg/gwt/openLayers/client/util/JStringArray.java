package com.eg.gwt.openLayers.client.util;


/**
 *
 *
 */
public class JStringArray extends JArrayBase
{
	protected JStringArray(JSObject element)
	{
		super(element);
	}

	public static JStringArray narrowToJStringArray(JSObject element)
	{
		return (element == null)?null: new JStringArray(element);
	}

	public JStringArray(String[] array)
	{
		super(array.length);

		for(int i = 0; i < array.length; i++)
		{
			set(i, array[i]);
		}
	}

	public void set(int index, String value)
	{
		JStringArrayImpl.arraySet(getJSObject(), index, value);
	}

	public String[] toArray()
	{
		String[] rtn = new String[length()];

		for(int i = 0; i < rtn.length; i++)
		{
			rtn[i] = JStringArrayImpl.getAsString(getJSObject(), i);
		}

		return rtn;
	}

}
