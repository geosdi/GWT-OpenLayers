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


public class JFloatArrayImpl
{

    public static native float get(JSObject array, int index) /*-{
        return array[index];
    }-*/;

    public static native float getAsFloat(JSObject array, int pos) /*-{
        if (array) return array[pos];
    }-*/;

    public static native void push(JSObject array, float f) /*-{
        array.push(f);
    }-*/;
}
