package Commands;

import Factory.CalcCommand;
import Factory.CommandExecuteException;
import Factory.Context;
import Factory.Main;
import java.util.EmptyStackException;
import java.util.List;
import java.util.logging.Level;

public class Pop implements CalcCommand {
    public void execute(Context context, List<String> myArgs ) throws CommandExecuteException {
        try {
            Main.LOGGER.log(Level.INFO, "pop from stack");
            context.popFromStack();
        } catch(EmptyStackException e) {
            Main.LOGGER.log(Level.INFO, "error" + e);
            throw new CommandExecuteException("stack is empty", e);
        }
    }
}
