package Commands;

import Factory.CalcCommand;
import Factory.CommandExecuteException;
import Factory.Context;
import Factory.Main;
import java.util.EmptyStackException;
import java.util.List;
import java.util.logging.Level;

public class Sqrt implements CalcCommand
{
    @Override
    public void execute(Context context, List<String> myArgs) throws CommandExecuteException
    {
        double a;
        try {
            Main.LOGGER.log(Level.INFO,"get number");
            a = context.popFromStack();
        } catch (EmptyStackException e) {
            throw new CommandExecuteException("stack is empty", e);
        }
        if (a < 0) {
            throw new CommandExecuteException("arg is less than zero");
        }
        double result = Math.sqrt(a);
        Main.LOGGER.log(Level.INFO,"get result");
        context.pushToStack(result);
    }
}
