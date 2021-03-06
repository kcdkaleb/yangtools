package org.opendaylight.yangtools.yang.parser.stmt.rfc6020;

import org.opendaylight.yangtools.yang.parser.stmt.rfc6020.effective.MustEffectiveStatementImpl;

import org.opendaylight.yangtools.yang.model.api.RevisionAwareXPath;
import org.opendaylight.yangtools.yang.model.api.Rfc6020Mapping;
import org.opendaylight.yangtools.yang.model.api.meta.EffectiveStatement;
import org.opendaylight.yangtools.yang.model.api.stmt.DescriptionStatement;
import org.opendaylight.yangtools.yang.model.api.stmt.ErrorAppTagStatement;
import org.opendaylight.yangtools.yang.model.api.stmt.ErrorMessageStatement;
import org.opendaylight.yangtools.yang.model.api.stmt.MustStatement;
import org.opendaylight.yangtools.yang.model.api.stmt.ReferenceStatement;
import org.opendaylight.yangtools.yang.model.util.RevisionAwareXPathImpl;
import org.opendaylight.yangtools.yang.parser.spi.meta.AbstractDeclaredStatement;
import org.opendaylight.yangtools.yang.parser.spi.meta.AbstractStatementSupport;
import org.opendaylight.yangtools.yang.parser.spi.meta.StmtContext;
import org.opendaylight.yangtools.yang.parser.spi.source.SourceException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MustStatementImpl extends AbstractDeclaredStatement<RevisionAwareXPath> implements
        MustStatement {

    protected MustStatementImpl(
            StmtContext<RevisionAwareXPath, MustStatement, ?> context) {
        super(context);
    }

    public static class Definition extends AbstractStatementSupport<RevisionAwareXPath,MustStatement,EffectiveStatement<RevisionAwareXPath,MustStatement>> {

        public Definition() {
            super(Rfc6020Mapping.MUST);
        }

        @Override public RevisionAwareXPath parseArgumentValue(
                StmtContext<?, ?, ?> ctx, String value) throws SourceException {
            return new RevisionAwareXPathImpl(value, false);
        }

        @Override public MustStatement createDeclared(
                StmtContext<RevisionAwareXPath, MustStatement, ?> ctx) {
            return new MustStatementImpl(ctx);
        }

        @Override public EffectiveStatement<RevisionAwareXPath, MustStatement> createEffective(
                StmtContext<RevisionAwareXPath, MustStatement, EffectiveStatement<RevisionAwareXPath, MustStatement>> ctx) {
            return new MustEffectiveStatementImpl(ctx);
        }
    }

    @Nonnull @Override
    public RevisionAwareXPath getCondition() {
        return argument();
    }

    @Nullable @Override
    public ErrorAppTagStatement getErrorAppTagStatement() {
        return firstDeclared(ErrorAppTagStatement.class);
    }

    @Nullable @Override
    public ErrorMessageStatement getErrorMessageStatement() {
        return firstDeclared(ErrorMessageStatement.class);
    }

    @Nullable @Override
    public DescriptionStatement getDescription() {
        return firstDeclared(DescriptionStatement.class);
    }

    @Nullable @Override
    public ReferenceStatement getReference() {
        return firstDeclared(ReferenceStatement.class);
    }
}
