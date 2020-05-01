package Tests;

import Commands.Sum;
import Factory.CalcCommand;
import Factory.Context;
import junit.framework.TestCase;

public class TestSum extends TestCase
{
    public void testExecute() throws Exception {
        Double a = 5.0;
        Double b = 2.0;

        Context context = new Context();
        context.pushToStack(a);
        context.pushToStack(b);
        CalcCommand cmd = new Sum();
        cmd.execute(context, null);
        assertEquals(a + b, context.peekAtStack());
    }
}