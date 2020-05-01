package Tests;

import Commands.Mul;
import Factory.CalcCommand;
import Factory.Context;
import junit.framework.TestCase;

public class TestMul extends TestCase
{
    public void testExecute() throws Exception {
        Double a = 5.0;
        Double b = 2.0;

        Context context = new Context();
        context.pushToStack(a);
        context.pushToStack(b);
        CalcCommand cmd = new Mul();
        cmd.execute(context, null);
        assertEquals(a * b, context.peekAtStack());
    }
}