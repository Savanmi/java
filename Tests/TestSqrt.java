package Tests;

import Commands.Sqrt;
import Factory.CalcCommand;
import junit.framework.TestCase;
import Factory.Context;

public class TestSqrt extends TestCase {
    public void testExecute() throws Exception {
        Double a = 5.0;

        Context context = new Context();
        context.pushToStack(a);
        CalcCommand cmd = new Sqrt();
        cmd.execute(context, null);
        assertEquals(Math.sqrt(a), context.peekAtStack());
    }
}
