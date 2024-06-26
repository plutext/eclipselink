/*
 * Copyright (c) 2011, 2021 Oracle and/or its affiliates. All rights reserved.
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
//     Oracle - initial API and implementation
package org.eclipse.persistence.internal.nosql.adapters.nosql;

import javax.naming.Reference;
import jakarta.resource.ResourceException;
import jakarta.resource.cci.Connection;
import jakarta.resource.cci.ConnectionFactory;
import jakarta.resource.cci.ConnectionSpec;
import jakarta.resource.cci.RecordFactory;
import jakarta.resource.cci.ResourceAdapterMetaData;

import oracle.kv.KVStore;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;

/**
 * Connection factory for Oracle NoSQL JCA adapter.
 *
 * @author James
 * @since EclipseLink 2.4
 */
public class OracleNoSQLConnectionFactory implements ConnectionFactory {

    /**
     * Default constructor.
     */
    public OracleNoSQLConnectionFactory() {
    }

    @Override
    public Connection getConnection() throws ResourceException {
        return getConnection(new OracleNoSQLJCAConnectionSpec());
    }

    @Override
    public Connection getConnection(ConnectionSpec spec) throws ResourceException {
        OracleNoSQLJCAConnectionSpec connectionSpec = (OracleNoSQLJCAConnectionSpec)spec;
        KVStore store = null;
        try {
            KVStoreFactory factory = new KVStoreFactory();
            String[] hosts = new String[connectionSpec.getHosts().size()];
            int index = 0;
            for (String host : connectionSpec.getHosts()) {
                hosts[index] = host;
                index++;
            }
            KVStoreConfig config = new KVStoreConfig(connectionSpec.getStore(), hosts);
            store = KVStoreFactory.getStore(config);
        } catch (Exception exception) {
            ResourceException resourceException = new ResourceException(exception.toString());
            resourceException.initCause(exception);
            throw resourceException;
        }

        return new OracleNoSQLConnection(store, connectionSpec);
    }

    @Override
    public ResourceAdapterMetaData getMetaData() {
        return new OracleNoSQLAdapterMetaData();
    }

    @Override
    public RecordFactory getRecordFactory() {
        return new OracleNoSQLRecordFactory();
    }

    @Override
    public Reference getReference() {
        return new Reference(getClass().getName());
    }

    @Override
    public void setReference(Reference reference) {
    }
}
