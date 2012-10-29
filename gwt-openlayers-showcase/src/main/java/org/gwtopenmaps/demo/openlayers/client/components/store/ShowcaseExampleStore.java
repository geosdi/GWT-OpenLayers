/*
 * Copyright 2012 sourceforge.
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
package org.gwtopenmaps.demo.openlayers.client.components.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.inject.Singleton;
import org.gwtopenmaps.demo.openlayers.client.ExampleBean;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@Singleton
public class ShowcaseExampleStore implements ExampleStore {

    private boolean isStoreSorted;
    /**
     * TODO : Change this implementation using {@link HashMap}
     */
    private List<ExampleBean> examples = new ArrayList<ExampleBean>();
   

    public final void addExample(ExampleBean example) {
        this.examples.add(example);
    }

    public void sortStore() {
        if (!isStoreSorted) {
            Collections.sort(examples);
            this.isStoreSorted = true;
        }
    }

    public List<ExampleBean> getExamples() {
        return Collections.unmodifiableList(examples);
    }
}
