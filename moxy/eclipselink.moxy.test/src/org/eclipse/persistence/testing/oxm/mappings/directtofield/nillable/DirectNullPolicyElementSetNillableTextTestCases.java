/*
 * Copyright (c) 1998, 2018 Oracle and/or its affiliates. All rights reserved.
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
//     Denise Smith - Sepetember 2012
package org.eclipse.persistence.testing.oxm.mappings.directtofield.nillable;

/**
 * Same as super class except the XML document being read has some text
 * after the xsi:nil that should be ignored
 */
public class DirectNullPolicyElementSetNillableTextTestCases extends
        DirectNullPolicyElementSetNillableTestCases {

    protected final static String XML_READ_RESOURCE = //
        "org/eclipse/persistence/testing/oxm/mappings/directtofield/nillable/DirectNullPolicyElementSetNillableText.xml";

    public DirectNullPolicyElementSetNillableTextTestCases(String name)
            throws Exception {
        super(name);
        setControlDocument(XML_READ_RESOURCE);
        setWriteControlDocument(XML_RESOURCE);
    }

}
