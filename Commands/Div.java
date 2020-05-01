package Commands;

import Factory.CalcCommand;
import Factory.CommandExecuteException;
import Factory.Context;
import Factory.Main;
import java.util.EmptyStackException;
import java.util.List;
import java.util.logging.Level;

public class Div implements CalcCommand
{
    private static final double EPSILON = 1e-9;

    @Override
    public void execute(Context context, List<String> myArgs) throws CommandExecuteException
    {
        double a;
        double b;
        try {
            Main.LOGGER.log(Level.INFO,"get first number");
            b = context.popFromStack();
            Main.LOGGER.log(Level.INFO,"get second number");
            a = context.popFromStack();
        } catch (EmptyStackException e) {
            Main.LOGGER.log(Level.INFO,"error: " + e);
            throw new CommandExecuteException("stack is empty ", e);
        }
        if (b == 0) {
            throw new CommandExecuteException("division by zero");
        }
        double result = a / b;
        Main.LOGGER.log(Level.INFO,"get result");
        context.pushToStack(result);
    }
}
