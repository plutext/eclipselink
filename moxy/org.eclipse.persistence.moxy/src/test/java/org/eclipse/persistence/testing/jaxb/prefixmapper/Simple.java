/*
 * Copyright (c) 2012, 2024 Oracle and/or its affiliates. All rights reserved.
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
// Denise Smith - October 2012
package org.eclipse.persistence.testing.jaxb.prefixmapper;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace="namespace3")
public class Simple {
   @XmlElement(namespace="namespace1")
  public int thing1;
   @XmlElement(namespace="namespace2")
  public int thing2;

   public boolean equals(Object obj){
       if(!(obj instanceof Simple simpleObject)){
           return false;
       }
       return thing1 == simpleObject.thing1 && thing2 == simpleObject.thing2;
   }
}
