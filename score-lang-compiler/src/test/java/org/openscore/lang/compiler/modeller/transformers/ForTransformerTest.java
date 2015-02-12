package org.openscore.lang.compiler.modeller.transformers;

import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openscore.lang.entities.LoopStatement;

public class ForTransformerTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private ForTransformer transformer = new ForTransformer();

    @Test
    public void testValidStatement() throws Exception {
        LoopStatement statement = transformer.transform("x in collection");
        Assert.assertEquals("x", statement.getVarName());
        Assert.assertEquals("collection", statement.getCollectionExpression());
    }

    @Test
    public void testValidStatementAndTrim() throws Exception {
        LoopStatement statement = transformer.transform(" min   in  collection  ");
        Assert.assertEquals("min", statement.getVarName());
        Assert.assertEquals("collection", statement.getCollectionExpression());
    }

    @Test
    public void testNoVarName() throws Exception {
        exception.expect(RuntimeException.class);
        exception.expectMessage("var name");
        transformer.transform("  in  collection");
    }

    @Test
    public void testVarNameContainInvalidChars() throws Exception {
        exception.expect(RuntimeException.class);
        exception.expectMessage("var name");
        exception.expectMessage("invalid");
        transformer.transform("x a  in  collection");
    }

    @Test
    public void testNoCollectionExpression() throws Exception {
        exception.expect(RuntimeException.class);
        exception.expectMessage("collection expression");
        transformer.transform("x in  ");
    }

    @Test
    public void testMultipleInsAreTrimmed() throws Exception {
        LoopStatement statement = transformer.transform(" in   in in ");
        Assert.assertEquals("in", statement.getVarName());
        Assert.assertEquals("in", statement.getCollectionExpression());
    }

    @Test
    public void testEmptyValue() throws Exception {
        LoopStatement statement = transformer.transform("");
        Assert.assertNull(statement);
    }
}