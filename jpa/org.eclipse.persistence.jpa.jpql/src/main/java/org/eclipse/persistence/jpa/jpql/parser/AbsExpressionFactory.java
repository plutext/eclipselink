/*
 * Copyright (c) 2006, 2021 Oracle and/or its affiliates. All rights reserved.
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
//
package org.eclipse.persistence.jpa.jpql.parser;

import org.eclipse.persistence.jpa.jpql.WordParser;

/**
 * This {@link AbsExpressionFactory} creates a new {@link AbsExpression} when the portion of the
 * query to parse starts with <b>ABS</b>.
 *
 * @see AbsExpression
 *
 * @version 2.4
 * @since 2.3
 * @author Pascal Filion
 */
public final class AbsExpressionFactory extends ExpressionFactory {

    /**
     * The unique identifier of this {@link AbsExpressionFactory}.
     */
    public static final String ID = Expression.ABS;

    /**
     * Creates a new <code>AbsExpressionFactory</code>.
     */
    public AbsExpressionFactory() {
        super(ID, Expression.ABS);
    }

    @Override
    protected AbstractExpression buildExpression(AbstractExpression parent,
                                                 WordParser wordParser,
                                                 String word,
                                                 JPQLQueryBNF queryBNF,
                                                 AbstractExpression expression,
                                                 boolean tolerant) {

        expression = new AbsExpression(parent);
        expression.parse(wordParser, tolerant);
        return expression;
    }
}
