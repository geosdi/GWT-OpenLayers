/**
 *
 * Copyright 2014 sourceforge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Maciej Jezierski - Pinocchio
 *
 */
public class PagingStrategy extends Strategy {

    protected PagingStrategy(JSObject strategy) {
        super(strategy);
    }

    public PagingStrategy() {
        this(PagingStrategyImpl.create());
    }

    public int pageCount() {
        return PagingStrategyImpl.pageCount(this.getJSObject());
    }

    public int pageNum() {
        return PagingStrategyImpl.pageNum(this.getJSObject());
    }

    public int pageLength() {
        return PagingStrategyImpl.pageLength(this.getJSObject());
    }

    public int pageLength(int length) {
        return PagingStrategyImpl.pageLength(this.getJSObject(), length);
    }

    public boolean pageNext() {
        return PagingStrategyImpl.pageNext(this.getJSObject());
    }

    public boolean pagePrevious() {
        return PagingStrategyImpl.pagePrevious(this.getJSObject());
    }

}
