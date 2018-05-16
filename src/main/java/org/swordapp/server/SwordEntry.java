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

import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwordEntry {
    public Entry entry;

    public SwordEntry(Entry entry) {
        this.entry = entry;
    }

    public String getTitle() {
        return this.entry.getTitle();
    }

    public String getSummary() {
        return this.entry.getSummary();
    }

    public Entry getEntry() {
        return this.entry;
    }

    public String toString() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            this.entry.writeTo(baos);
            return baos.toString();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // put the code in for getting a dublin core record out
    public Map<String, List<String>> getDublinCore() {
        Map<String, List<String>> dc = new HashMap<String, List<String>>();
        List<Element> extensions = this.entry.getExtensions();
        for (Element element : extensions) {
            if (UriRegistry.DC_NAMESPACE.equals(element.getQName().getNamespaceURI())) {
                // we have a dublin core extension
                String field = element.getQName().getLocalPart();
                String value = element.getText();

                if (dc.containsKey(field)) {
                    dc.get(field).add(value);
                } else {
                    ArrayList<String> values = new ArrayList<String>();
                    values.add(value);
                    dc.put(field, values);
                }
            }
        }
        return dc;
    }
}
