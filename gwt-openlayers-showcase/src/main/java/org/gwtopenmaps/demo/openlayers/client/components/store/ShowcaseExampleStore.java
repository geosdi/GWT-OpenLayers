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
package org.gwtopenmaps.demo.openlayers.client.components.store;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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
    private final Map<String, ExampleBean> examples = new HashMap<String, ExampleBean>();
    
    public final void addExample(ExampleBean example) {
        if (this.examples.containsValue(example)) {
            throw new IllegalStateException("Example with Name : " + example.getName()
                    + " already present in the Store");
        }
        this.examples.put(example.getName(), example);
    }
    
    public void sortStore() {
        if (!isStoreSorted) {
            Collections.sort(new ArrayList<ExampleBean>(examples.values()));
            this.isStoreSorted = true;
        }
    }
    
    public Collection<ExampleBean> getExamples() {
        return Collections.unmodifiableCollection(examples.values());
    }
    
    public ExampleBean getExample(String exampleName) {
        return this.examples.get(exampleName);
    }
    
}
