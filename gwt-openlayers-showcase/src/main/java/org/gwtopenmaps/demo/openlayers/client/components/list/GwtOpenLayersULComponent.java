/*
 * Copyright 2014 geoSDI.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtopenmaps.demo.openlayers.client.components.list;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class GwtOpenLayersULComponent extends ComplexPanel
        implements InsertPanel {

    public GwtOpenLayersULComponent() {
        setElement(Document.get().createULElement());
    }

    private GwtOpenLayersLIComponent wrapWidget(Widget w) {
        GwtOpenLayersLIComponent li = new GwtOpenLayersLIComponent();
        li.add(w);
        return li;
    }

    /**
     * Adds a new child widget to the panel.
     *
     * @param w the widget to be added
     */
    @Override
    public void add(Widget w) {
        add(wrapWidget(w), (Element) getElement());
    }

    /**
     * Inserts a widget before the specified index.
     *
     * @param w the widget to be inserted
     * @param beforeIndex the index before which it will be inserted
     * @throws IndexOutOfBoundsException if <code>beforeIndex</code> is out of
     * range
     */
    public void insert(Widget w, int beforeIndex) {
        insert(wrapWidget(w), (Element) getElement(), beforeIndex, true);
    }

    private static class GwtOpenLayersLIComponent extends ComplexPanel implements
            InsertPanel {

        protected GwtOpenLayersLIComponent() {
            setElement(Document.get().createLIElement());
        }

        /**
         * Adds a new child widget to the panel.
         *
         * @param w the widget to be added
         */
        @Override
        public void add(Widget w) {
            add(w, (Element) getElement());
        }

        /**
         * Inserts a child widget before the specified index. If the widget is
         * already a child of this panel, it will be moved to the specified
         * index.
         *
         * @param w the child widget to be inserted
         * @param beforeIndex the index before which it will be inserted
         * @throws IndexOutOfBoundsException if <code>beforeIndex</code> is out
         * of range
         */
        @Override
        public void insert(Widget w, int beforeIndex) {
            insert(w, (Element) getElement(), beforeIndex, true);
        }

    }

}
