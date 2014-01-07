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
public class RegExp extends JSObjectWrapper
{

    protected RegExp(JSObject jsObject)
    {
        super(jsObject);
    }

    public RegExp(String regexString)
    {
        super(RegExpImpl.create(regexString));
    }

    public RegExp(String regexString, String modifier)
    {
        super(RegExpImpl.create(regexString, modifier));
    }

    public JSObject exec(String str)
    {
        return RegExpImpl.exec(getJSObject(), str);
    }
}
