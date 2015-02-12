/*******************************************************************************
 * (c) Copyright 2014 Hewlett-Packard Development Company, L.P.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0 which accompany this distribution.
 *
 * The Apache License is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *******************************************************************************/
package org.openscore.lang.entities;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

public class LoopStatement implements Serializable{

    public enum Type {
        FOR, WHILE
    }

    private final String varName;
    private final String collectionExpression;
    private final Type type;

    public LoopStatement(String varName, String collectionExpression, Type type) {
        Validate.notBlank(varName, "for loop var name cannot be empty");
        Validate.notBlank(collectionExpression, "for loop collection expression cannot be empty");
        Validate.notNull(type, "type cannot be null");

        this.varName = varName.trim();
        if (isContainInvalidChars(this.varName)) {
            throw new RuntimeException("for loop var name cannot contain invalid chars");
        }
        this.collectionExpression = collectionExpression.trim();
        this.type = type;
    }

    private boolean isContainInvalidChars(String varName) {
        return StringUtils.containsAny(varName, " \t\r\n\b");
    }

    public String getVarName() {
        return varName;
    }

    public String getCollectionExpression() {
        return collectionExpression;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        LoopStatement that = (LoopStatement) o;

        return new EqualsBuilder()
                .append(varName, that.varName)
                .append(collectionExpression, that.collectionExpression)
                .append(type, that.type)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(varName)
                .append(collectionExpression)
                .append(type)
                .toHashCode();
    }
}