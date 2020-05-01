package Commands;

import Factory.CalcCommand;
import Factory.CommandExecuteException;
import Factory.Context;
import Factory.Main;
import java.util.EmptyStackException;
import java.util.List;
import java.util.logging.Level;

public class Print implements CalcCommand
{
    @Override
    public void execute(Context context, List<String> myArgs) throws CommandExecuteException
    {
        try {
            double a = context.peekAtStack();
            Main.LOGGER.log(Level.INFO, "print result");
            System.out.println("Result: " + a);
        } catch (EmptyStackException e) {
            Main.LOGGER.log(Level.INFO, "error" + e);
            throw new CommandExecuteException("stack is empty", e);
        }
    }
}
