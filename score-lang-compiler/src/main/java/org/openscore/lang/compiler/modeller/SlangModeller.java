/*
 * (c) Copyright 2014 Hewlett-Packard Development Company, L.P.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0 which accompany this distribution.
 *
 * The Apache License is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.openscore.lang.compiler.modeller;

import org.openscore.lang.compiler.modeller.model.Executable;
import org.openscore.lang.compiler.parser.model.ParsedSlang;

/*
 * Created by stoneo on 2/2/2015.
 */

/**
 * Slang modeller - transforms a {@link org.openscore.lang.compiler.parser.model.ParsedSlang} source into
 * the Slang model - an {@link org.openscore.lang.compiler.modeller.model.Executable} object
 */
public interface SlangModeller {

    /**
     * Pre-compile a Slang source into an {@link org.openscore.lang.compiler.modeller.model.Executable}
     * @param parsedSlang the {@link org.openscore.lang.compiler.parser.model.ParsedSlang} source
     * @return an {@link org.openscore.lang.compiler.modeller.model.Executable} object, containing either a flow or an operations in the file
     */
    Executable createModel(ParsedSlang parsedSlang);
}
