/*
 * Copyright (c) 2013, 2021 Oracle and/or its affiliates. All rights reserved.
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
//     Blaise Doughan - 2.4.2 - initial implementation
package org.eclipse.persistence.testing.jaxb.annotations.xmlnullpolicy;

import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;

public class DefaultNoNodeTestCases extends JAXBWithJSONTestCases {

    private static final String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/annotations/xmlnullpolicy/default-no-node.xml";
    private static final String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/annotations/xmlnullpolicy/default-no-node.json";

    public DefaultNoNodeTestCases(String name) throws Exception {
        super(name);
        setClasses(new Class<?>[] {DefaultNoNodeEmployee.class});
        setControlDocument(XML_RESOURCE);
        setControlJSON(JSON_RESOURCE);
    }

    @Override
    protected DefaultNoNodeEmployee getControlObject() {
        return new DefaultNoNodeEmployee();
    }

}
