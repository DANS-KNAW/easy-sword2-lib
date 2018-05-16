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

public class SwordError extends Exception {
    private String errorUri;
    private int status = -1;
    private boolean hasBody = true;

    public SwordError() {
        super();
    }

    public SwordError(int status) {
        super();
        this.status = status;
        this.hasBody = false;
    }

    public SwordError(String errorUri) {
        super(errorUri);
        this.errorUri = errorUri;
    }

    public SwordError(String errorUri, int status) {
        super(errorUri);
        this.errorUri = errorUri;
        this.status = status;
    }

    public SwordError(String errorUri, String message) {
        super(message);
        this.errorUri = errorUri;
    }

    public SwordError(String errorUri, int status, String message) {
        super(message);
        this.errorUri = errorUri;
        this.status = status;
    }

    public SwordError(String errorUri, Throwable cause) {
        super(errorUri, cause);
        this.errorUri = errorUri;
    }

    public SwordError(String errorUri, int status, Throwable cause) {
        super(errorUri, cause);
        this.errorUri = errorUri;
        this.status = status;
    }

    public SwordError(String errorUri, String message, Throwable cause) {
        super(message, cause);
        this.errorUri = errorUri;
    }

    public SwordError(String errorUri, int status, String message, Throwable cause) {
        super(message, cause);
        this.errorUri = errorUri;
        this.status = status;
    }

    public String getErrorUri() {
        return errorUri;
    }

    public int getStatus() {
        return status;
    }

    public boolean hasBody() {
        return hasBody;
    }
}
