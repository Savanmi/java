package Commands;

import Factory.CalcCommand;
import Factory.CommandExecuteException;
import Factory.Context;
import Factory.Main;
import java.util.EmptyStackException;
import java.util.List;
import java.util.logging.Level;

public class Sub implements CalcCommand
{
    @Override
    public void execute(Context context, List<String> myArgs) throws CommandExecuteException
    {
        try {
            Main.LOGGER.log(Level.INFO,"get first number");
            double b = context.popFromStack();
            Main.LOGGER.log(Level.INFO,"get second number");
            double a = context.popFromStack();
            Main.LOGGER.log(Level.INFO,"get result");
            context.pushToStack(a - b);
        } catch (EmptyStackException e) {
            throw new CommandExecuteException("stack is empty ", e);
        }
    }
}
