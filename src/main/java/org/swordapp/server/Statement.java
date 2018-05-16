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

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Statement {
    // common elements with some default values
    protected String contentType = null;
    protected List<OriginalDeposit> originalDeposits = new ArrayList<OriginalDeposit>();
    protected Map<String, String> states = new HashMap<String, String>();
    protected List<ResourcePart> resources = new ArrayList<ResourcePart>();
    protected Date lastModified = new Date();

    public abstract void writeTo(Writer out) throws IOException;

    public String getContentType() {
        return contentType;
    }

    public void setOriginalDeposits(List<OriginalDeposit> originalDeposits) {
        this.originalDeposits = originalDeposits;
    }

    public void addOriginalDeposit(OriginalDeposit originalDeposit) {
        this.originalDeposits.add(originalDeposit);
    }

    public void setResources(List<ResourcePart> resources) {
        this.resources = resources;
    }

    public void addResource(ResourcePart resource) {
        this.resources.add(resource);
    }

    public void setStates(Map<String, String> states) {
        this.states = states;
    }

    public void setState(String state, String description) {
        this.states.clear();
        this.states.put(state, description);
    }

    public void addState(String state, String description) {
        this.states.put(state, description);
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}
