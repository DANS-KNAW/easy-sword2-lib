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
package org.swordapp.server.servlets;

import org.apache.log4j.Logger;
import org.swordapp.server.CollectionAPI;
import org.swordapp.server.CollectionDepositManager;
import org.swordapp.server.CollectionListManager;
import org.swordapp.server.SwordConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CollectionServletDefault extends SwordServlet {
    private static Logger log = Logger.getLogger(CollectionServletDefault.class);

    protected CollectionListManager clm = null;
    protected CollectionDepositManager cdm;
    protected CollectionAPI api;

    public void init() throws ServletException {
        super.init();

        // load the collection list manager implementation
        Object possibleClm = this.loadImplClass("collection-list-impl", true); // allow null
        this.clm = possibleClm == null ? null : (CollectionListManager) possibleClm;

        // load the deposit manager implementation
        this.cdm = (CollectionDepositManager) this.loadImplClass("collection-deposit-impl", false);

        // load the API
        this.api = new CollectionAPI(this.clm, this.cdm, this.config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.api.get(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.api.post(req, resp);
    }
}
