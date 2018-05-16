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
import org.apache.abdera.model.Service;
import org.apache.abdera.model.Workspace;

public class ServiceDocument {
    private String version = "2.0";
    private int maxUploadSize = -1;

    private Service service;

    public ServiceDocument() {
        Abdera abdera = new Abdera();
        this.service = abdera.newService();
    }

    public Service getWrappedService() {
        return service;
    }

    public Service getAbderaService() {
        // here is where we compress everything from SWORD into Abdera
        // and the output has to be a full clone, not by reference
        Service abderaService = (Service) this.service.clone();
        abderaService.addSimpleExtension(UriRegistry.SWORD_VERSION, this.version);
        if (maxUploadSize > -1) {
            abderaService.addSimpleExtension(UriRegistry.SWORD_MAX_UPLOAD_SIZE, Integer.toString(this.maxUploadSize));
        }
        return abderaService;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setMaxUploadSize(int maxUploadSize) {
        this.maxUploadSize = maxUploadSize;
    }

    public void addWorkspace(SwordWorkspace workspace) {
        // FIXME: or do we just keep a reference of these until we get a call to getAbderaService()?
        Workspace abderaWorkspace = workspace.getAbderaWorkspace();
        this.service.addWorkspace(abderaWorkspace);
    }
}
