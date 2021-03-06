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

import org.apache.commons.lang3.Validate;

import java.io.Serializable;

public abstract class ForLoopStatement implements Serializable{

    private final String collectionExpression;

    public ForLoopStatement(String collectionExpression) {
        Validate.notBlank(collectionExpression, "for loop collection expression cannot be empty");

        this.collectionExpression = collectionExpression;
    }

    public String getCollectionExpression() {
        return collectionExpression;
    }

}
