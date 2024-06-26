/*
 * Copyright (c) 2012, 2021 Oracle and/or its affiliates. All rights reserved.
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
//     Denise Smith - February 2012
package org.eclipse.persistence.testing.jaxb.innerclasses.notincontext;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestObjectWrapper {

    public TestObject testObject;

    public boolean equals (Object compareObject){
        if(compareObject instanceof TestObjectWrapper){
            if(testObject == null){
                return compareObject == null;
            }
            return testObject.equals(((TestObjectWrapper)compareObject).testObject);
        }
        return false;
    }
}
