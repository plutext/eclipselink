/*
 * Copyright (c) 1998, 2024 Oracle and/or its affiliates. All rights reserved.
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
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.testing.oxm.xmlmarshaller;

import org.eclipse.persistence.exceptions.XMLMarshalException;
import org.eclipse.persistence.oxm.XMLContext;
import org.eclipse.persistence.oxm.XMLDescriptor;
import org.eclipse.persistence.oxm.XMLValidator;
import org.eclipse.persistence.testing.oxm.OXTestCase;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLMarshallerValidateRootTestCases extends OXTestCase {
    private XMLContext xmlContext;
    private XMLValidator xmlValidator;
    private XMLMarshallerCarProject project;

    public XMLMarshallerValidateRootTestCases(String name) {
        super(name);
    }

    @Override
    public void setUp() throws Exception {
        project = new XMLMarshallerCarProject();
        xmlContext = new XMLContext(project);
        xmlValidator = xmlContext.createValidator();
    }

    public void testDescriptorNotInProject() throws Exception {
        Employee emp = new Employee();
        try {
            xmlValidator.validateRoot(emp);
        } catch (XMLMarshalException ex) {
            assertEquals("", XMLMarshalException.DESCRIPTOR_NOT_FOUND_IN_PROJECT, ex.getErrorCode());
            return;
        }

        fail("Validation Exception not caught");
    }

    public void testDescriptorWithNoSchemaReference() throws Exception {
        ((XMLDescriptor) project.getClassDescriptor(Car.class)).setSchemaReference(null);
        Car car = new Car();
        car.setLicense("123789");
        try {
            xmlValidator.validateRoot(car);
        } catch (XMLMarshalException ex) {
            assertEquals("", XMLMarshalException.SCHEMA_REFERENCE_NOT_SET, ex.getErrorCode());
            return;
        }
        fail("ValidationException not caught");
    }

    public void testValidCar() throws Exception {
        Car car = new Car();
        car.setLicense("123987");
        assertTrue("Valid car reported invalid", xmlValidator.validateRoot(car));
    }

    public void testInvalidCar() throws Exception {
        Car car = new Car();
        car.setLicense("12345678910");
        assertFalse("Invalid car found to be valid", xmlValidator.validateRoot(car));
    }

    public void testErrorHandler() throws Exception {
        ErrorHandler errorHandler = new IgnoreAllErrorHandler();
        xmlValidator.setErrorHandler(errorHandler);

        Car car = new Car();
        car.setLicense("12345678910");
        assertTrue("Errors not ignored", xmlValidator.validateRoot(car));
    }

    public void testNullRootObject() throws Exception {
        try {
            boolean valid = xmlValidator.validateRoot(null);
        } catch (XMLMarshalException validationException) {
            assertEquals("An unexpected XMLMarshalException was caught.", XMLMarshalException.NULL_ARGUMENT, validationException.getErrorCode());
            return;
        }
        fail("An XMLMarshalException should have been caught but wasn't");
    }

    public void testNullObject() throws Exception {
        try {
            boolean valid = xmlValidator.validate(null);
        } catch (XMLMarshalException validationException) {
            assertEquals("An unexpected XMLMarshalException was caught.", XMLMarshalException.NULL_ARGUMENT, validationException.getErrorCode());
            return;
        }
        fail("An XMLMarshalException should have been caught but wasn't");
    }

    private static class IgnoreAllErrorHandler implements ErrorHandler {
        @Override
        public void warning(SAXParseException exception) throws SAXException {
        }

        @Override
        public void error(SAXParseException exception) throws SAXException {
        }

        @Override
        public void fatalError(SAXParseException exception) throws SAXException {
        }
    }
}
