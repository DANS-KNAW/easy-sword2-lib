/**
 * Copyright (C) 2018 DANS - Data Archiving and Networked Services (info@dans.knaw.nl)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.swordapp.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ResourcePart {
    protected String uri;
    protected String mediaType;
    protected Map<String, String> properties = new HashMap<String, String>();
    protected List<String> selfLinks = new ArrayList<String>();

    public ResourcePart(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public void addProperty(String predicate, String object) {
        this.properties.put(predicate, object);
    }

    public List<String> getSelfLinks() {
        return selfLinks;
    }

    public void addSelfLink(String link) {
        selfLinks.add(link);
    }

}
