/*
 * Copyright (c) 2011, 2022 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2011, 2022 Karsten Wutzke. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     01/04/2011-2.3 Guy Pelletier for Karsten Wutzke
//       - 330628: @PrimaryKeyJoinColumn(...) is not working equivalently to @JoinColumn(..., insertable = false, updatable = false)
package org.eclipse.persistence.testing.models.jpa.ddlgeneration;

import java.io.Serializable;

public class ZipId implements Serializable
{
    private String countryCode;

    private String code;

    public ZipId()
    {
    }

    public ZipId(String countryCode, String code)
    {
        this.countryCode = countryCode;
        this.code = code;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public void setCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }
}
