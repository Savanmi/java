package Commands;

import Factory.CalcCommand;
import Factory.CommandExecuteException;
import Factory.Context;
import Factory.Main;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;

public class Push implements CalcCommand
{
    @Override
    public void execute(Context context, List<String> myArgs) throws CommandExecuteException
    {
        String arg = myArgs.get(0);
        if (isDouble(arg)) {
            context.pushToStack(Double.parseDouble(arg));
        } else {
            try {
                Main.LOGGER.log(Level.INFO,"get value");
                double constantValue = context.getConstant(arg);
                Main.LOGGER.log(Level.INFO,"push num to stack");
                context.pushToStack(constantValue);
            } catch (NoSuchElementException e) {
                throw new CommandExecuteException(arg + " is not exist", e);
            }
        }
    }

    private boolean isDouble(String str)
    {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
