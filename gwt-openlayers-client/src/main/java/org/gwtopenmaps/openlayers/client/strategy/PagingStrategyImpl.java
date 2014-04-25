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
package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;

class PagingStrategyImpl {

    public static native JSObject create() /*-{
     return new $wnd.OpenLayers.Strategy.Paging();
     }-*/;

    public static native int pageCount(JSObject self) /*-{
     return self.pageCount();
     }-*/;

    public static native int pageNum(JSObject self) /*-{
     return self.pageNum();
     }-*/;

    public static native int pageLength(JSObject self) /*-{
     return self.pageLength();
     }-*/;

    public static native int pageLength(JSObject self, int length) /*-{
     return self.pageLength(length);
     }-*/;

    public static native boolean pageNext(JSObject self) /*-{
     return self.pageNext();
     }-*/;

    public static native boolean pagePrevious(JSObject self) /*-{
     return self.pagePrevious();
     }-*/;

}
