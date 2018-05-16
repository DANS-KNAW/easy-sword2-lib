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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OriginalDeposit extends ResourcePart {
    private List<String> packaging;
    private Date depositedOn;
    private String depositedBy;
    private String depositedOnBehalfOf;

    public OriginalDeposit(String uri) {
        this(uri, new ArrayList<String>(), null, null, null);
    }

    public OriginalDeposit(String uri, List<String> packaging, Date depositedOn, String depositedBy, String depositedOnBehalfOf) {
        super(uri);
        this.packaging = packaging;
        this.depositedOn = depositedOn;
        this.depositedBy = depositedBy;
        this.depositedOnBehalfOf = depositedOnBehalfOf;
    }

    public String getUri() {
        return uri;
    }

    public List<String> getPackaging() {
        return packaging;
    }

    public void setPackaging(List<String> packaging) {
        this.packaging = packaging;
    }

    public Date getDepositedOn() {
        return depositedOn;
    }

    public void setDepositedOn(Date depositedOn) {
        this.depositedOn = depositedOn;
    }

    public String getDepositedBy() {
        return depositedBy;
    }

    public void setDepositedBy(String depositedBy) {
        this.depositedBy = depositedBy;
    }

    public String getDepositedOnBehalfOf() {
        return depositedOnBehalfOf;
    }

    public void setDepositedOnBehalfOf(String depositedOnBehalfOf) {
        this.depositedOnBehalfOf = depositedOnBehalfOf;
    }
}
