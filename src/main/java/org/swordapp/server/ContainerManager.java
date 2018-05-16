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

import java.util.Map;

public interface ContainerManager {
    DepositReceipt getEntry(String editIRI, Map<String, String> accept, AuthCredentials auth, SwordConfiguration config) throws SwordServerException,
            SwordError, SwordAuthException;

    DepositReceipt replaceMetadata(String editIRI, Deposit deposit, AuthCredentials auth, SwordConfiguration config) throws SwordError, SwordServerException,
            SwordAuthException;

    DepositReceipt replaceMetadataAndMediaResource(String editIRI, Deposit deposit, AuthCredentials auth, SwordConfiguration config) throws SwordError,
            SwordServerException, SwordAuthException;

    DepositReceipt addMetadataAndResources(String editIRI, Deposit deposit, AuthCredentials auth, SwordConfiguration config) throws SwordError,
            SwordServerException, SwordAuthException;

    DepositReceipt addMetadata(String editIRI, Deposit deposit, AuthCredentials auth, SwordConfiguration config) throws SwordError, SwordServerException,
            SwordAuthException;

    DepositReceipt addResources(String editIRI, Deposit deposit, AuthCredentials auth, SwordConfiguration config) throws SwordError, SwordServerException,
            SwordAuthException;

    void deleteContainer(String editIRI, AuthCredentials auth, SwordConfiguration config) throws SwordError, SwordServerException, SwordAuthException;

    DepositReceipt useHeaders(String editIRI, Deposit deposit, AuthCredentials auth, SwordConfiguration config) throws SwordError, SwordServerException,
            SwordAuthException;

    boolean isStatementRequest(String editIRI, Map<String, String> accept, AuthCredentials auth, SwordConfiguration config) throws SwordError,
            SwordServerException, SwordAuthException;
}
