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

import java.io.InputStream;
import java.util.Date;

public class MediaResource {
    private String packaging = UriRegistry.PACKAGE_SIMPLE_ZIP;
    private String contentType = "application/octet-stream";
    private InputStream inputStream = null;
    private boolean unpackaged = false;
    private String contentMD5;
    private Date lastModified;

    public MediaResource(InputStream in, String contentType, String packaging) {
        this(in, contentType, packaging, false);
    }

    public MediaResource(InputStream in, String contentType, String packaging, boolean unpackaged) {
        this.inputStream = in;
        this.contentType = contentType;
        this.packaging = packaging;
        this.unpackaged = unpackaged;
    }

    public String getContentMD5() {
        return contentMD5;
    }

    public void setContentMD5(String contentMD5) {
        this.contentMD5 = contentMD5;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public boolean isUnpackaged() {
        return unpackaged;
    }

    public void setUnpackaged(boolean unpackaged) {
        this.unpackaged = unpackaged;
    }

    public String getPackaging() {
        return packaging;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }
}
