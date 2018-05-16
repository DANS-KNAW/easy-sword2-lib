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

import org.swordapp.server.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.log4j.Logger;

public class StatementServletDefault extends SwordServlet {
    private static Logger log = Logger.getLogger(StatementServletDefault.class);

    private StatementManager sm;
    private StatementAPI statementApi;

    public void init() throws ServletException {
        super.init();

        // load the container manager implementation
        this.sm = (StatementManager) this.loadImplClass("statement-impl", false);

        // initialise the underlying servlet processor
        this.statementApi = new StatementAPI(this.sm, this.config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.statementApi.get(req, resp);
    }
}
