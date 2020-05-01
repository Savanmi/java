package Tests;

import Commands.Sub;
import Factory.CalcCommand;
import junit.framework.TestCase;
import Factory.Context;


public class TestSub extends TestCase {
    public void testExecute() throws Exception {
        Double a = 5.0;
        Double b = 2.0;

        Context context = new Context();
        context.pushToStack(a);
        context.pushToStack(b);
        CalcCommand cmd = new Sub();
        cmd.execute(context, null);
        assertEquals(a - b, context.peekAtStack());
    }
}

