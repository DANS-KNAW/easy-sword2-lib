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
import org.swordapp.server.ContainerAPI;
import org.swordapp.server.ContainerManager;
import org.swordapp.server.StatementAPI;
import org.swordapp.server.StatementManager;
import org.swordapp.server.SwordConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContainerServletDefault extends SwordServlet {
    private static Logger log = Logger.getLogger(ContainerServletDefault.class);

    private ContainerManager cm;
    private ContainerAPI api;
    private StatementManager sm;

    public void init() throws ServletException {
        super.init();

        // load the container manager implementation
        this.cm = (ContainerManager) this.loadImplClass("container-impl", false);

        // load the container manager implementation
        this.sm = (StatementManager) this.loadImplClass("statement-impl", false);

        // initialise the underlying servlet processor
        this.api = new ContainerAPI(this.cm, this.sm, this.config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.api.get(req, resp);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.api.head(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.api.put(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.api.post(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.api.delete(req, resp);
    }
}
