/*
 * Copyright (c) 2011, 2018 Oracle and/or its affiliates. All rights reserved.
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
// dmccann - November 27/2009 - 2.0 - Initial implementation
package org.eclipse.persistence.testing.jaxb.externalizedmetadata.xmlelements;

import java.util.List;

public class Foo {
    //@javax.xml.bind.annotation.XmlElementWrapper(name="items")
    //@javax.xml.bind.annotation.XmlElements({
    //    @javax.xml.bind.annotation.XmlElement(name="A", type=Integer.class),
    //    @javax.xml.bind.annotation.XmlElement(name="B", type=Float.class)
    //})
    public List items;

    public boolean equals(Object compareObj){
        if(compareObj instanceof Foo){
            return items.equals(((Foo)compareObj).items);
        }
        return false;
    }
}
