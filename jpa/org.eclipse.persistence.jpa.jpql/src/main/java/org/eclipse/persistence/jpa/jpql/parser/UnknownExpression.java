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

import java.util.List;
import org.eclipse.persistence.jpa.jpql.WordParser;

/**
 * This expression contains a portion of the query that is unknown to the parser. This can happen
 * when the query is malformed or incomplete.
 *
 * @version 2.5
 * @since 2.3
 * @author Pascal Filion
 */
public final class UnknownExpression extends AbstractExpression {

    /**
     * Creates a new <code>UnknownExpression</code>.
     *
     * @param parent The parent of this expression
     * @param text The text to be stored in this expression
     */
    public UnknownExpression(AbstractExpression parent, String text) {
        super(parent, text);
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void acceptChildren(ExpressionVisitor visitor) {
        // No children to visit
    }

    @Override
    protected void addOrderedChildrenTo(List<Expression> children) {
        children.add(buildStringExpression(getText()));
    }

    @Override
    public JPQLQueryBNF findQueryBNF(Expression expression) {
        return getParent().findQueryBNF(expression);
    }

    @Override
    public JPQLQueryBNF getQueryBNF() {
        return getParent().getQueryBNF();
    }

    @Override
    public String getText() {
        return super.getText();
    }

    @Override
    protected boolean isUnknown() {
        return true;
    }

    @Override
    protected void parse(WordParser wordParser, boolean tolerant) {
        wordParser.moveForward(getText());
    }

    @Override
    public String toParsedText() {
        return getText();
    }

    @Override
    protected void toParsedText(StringBuilder writer, boolean actual) {
        writer.append(getText());
    }
}
