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

import org.apache.abdera.Abdera;
import org.apache.abdera.model.Collection;
import org.apache.abdera.model.Text;
import org.apache.abdera.model.Workspace;

public class SwordWorkspace {
    private Workspace workspace;

    public SwordWorkspace() {
        Abdera abdera = new Abdera();
        this.workspace = abdera.getFactory().newWorkspace();
    }

    public Workspace getWrappedWorkspace() {
        return workspace;
    }

    public Workspace getAbderaWorkspace() {
        // at the moment, this doesn't need to clone anything
        return workspace;
    }

    public void addCollection(SwordCollection collection) {
        // FIXME: or should collections be managed internally until getAbderaWorkspace is called
        Collection abderaCollection = collection.getAbderaCollection();
        this.workspace.addCollection(abderaCollection);
    }

    public Text setTitle(String title) {
        return this.workspace.setTitle(title);
    }
}
