/**
 *
 *   Copyright 2014 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.gwtopenmaps.openlayers.client.util;


class JObjectArrayImpl
{

    public static native void arraySet(JSObject myArray, int index, JSObject value) /*-{
        myArray[index] = value;
    }-*/;

    public static native JSObject getAsJSObject(JSObject myArray, int pos) /*-{
        return myArray[pos];
    }-*/;

    public static native boolean isNumber(JSObject element) /*-{
        return typeof element  == 'number' && isFinite(element);
    }-*/;

    public static native boolean isNumber(JSObject array, int pos) /*-{
        return typeof array[pos] == 'number' && isFinite(array[pos]);
    }-*/;

    public static native JSObject getNumberAsJSObject(JSObject array, int index) /*-{
        return new $wnd.Number(array[index]);
    }-*/;

    public static native boolean isBoolean(JSObject element) /*-{
        return typeof element == 'boolean';
    }-*/;

    public static native boolean isBoolean(JSObject array, int pos) /*-{
        return typeof array[pos] == 'boolean';
    }-*/;

    public static native JSObject getBooleanAsJSObject(JSObject array, int index) /*-{
        return new $wnd.Boolean(array[index]);
    }-*/;

    public static native boolean isArray(JSObject element) /*-{
        return element && typeof element === 'object' && typeof element.length === 'number' &&
        !(element.propertyIsEnumerable('length'));
    }-*/;
}
