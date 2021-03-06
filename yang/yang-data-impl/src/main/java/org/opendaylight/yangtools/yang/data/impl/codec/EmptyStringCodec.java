/*
 * Copyright (c) 2015 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yangtools.yang.data.impl.codec;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.opendaylight.yangtools.yang.data.api.codec.EmptyCodec;
import org.opendaylight.yangtools.yang.model.api.type.EmptyTypeDefinition;

class EmptyStringCodec extends TypeDefinitionAwareCodec<Void, EmptyTypeDefinition> implements
        EmptyCodec<String> {

    protected EmptyStringCodec(final Optional<EmptyTypeDefinition> typeDef) {
        super(typeDef, Void.class);
    }

    @Override
    public final String serialize(final Void data) {
        return "";
    }

    @Override
    public final Void deserialize(final String stringRepresentation) {
        Preconditions.checkArgument( Strings.isNullOrEmpty( stringRepresentation ),
                                     "The value must be empty" );
        return null;
    }
}