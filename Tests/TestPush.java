package Tests;

import Factory.Context;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestPush extends TestCase {
    public void testExecute() throws Exception {
        Context context = new Context();
        Double a = 5.0;
        Double b = 2.0;
        context.pushToStack(a);
        Double res = context.popFromStack();
        Assert.assertEquals(a, res);
        context.pushToStack(b);
        res = context.popFromStack();
        Assert.assertEquals(b, res);
    }
}