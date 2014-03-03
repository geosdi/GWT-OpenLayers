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
package org.gwtopenmaps.demo.openlayers.client;

import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;

/**
 * One example
 *
 * @author Frank
 *
 */
public class ExampleBean implements Comparable<ExampleBean> {

    private String name;
    private String description;
    private String[] tags;
    private AbstractExample example;

    /**
     * Constructs an example.
     *
     * @param name
     * @param description
     * @param tags
     */
    public ExampleBean(String name, String description, String[] tags,
            AbstractExample example) {
        super();
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.example = example;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the tags
     */
    public String[] getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    /**
     * @return the example
     */
    public AbstractExample getExample() {
        return example;
    }

    /**
     * @param example the example to set
     */
    public void setExample(AbstractExample example) {
        this.example = example;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(ExampleBean o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExampleBean other = (ExampleBean) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

}
