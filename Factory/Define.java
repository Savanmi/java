package Factory;

import Factory.CalcCommand;
import Factory.CommandExecuteException;
import Factory.Context;
import java.util.EmptyStackException;
import java.util.List;
import java.util.logging.Level;


public class Define implements CalcCommand
{
    @Override
    public void execute(Context context, List<String> myArgs) throws CommandExecuteException
    {
        if (myArgs.size() < 2) {
            throw new CommandExecuteException("incorrect DEFINE using");
        }
        String constValueStr = null;
        try {
            String constName = myArgs.get(0);
            constValueStr = myArgs.get(1);
            
            double constValue = Double.parseDouble(constValueStr);
            Main.LOGGER.log(Level.INFO,"set variable");
            context.setConstant(constName, constValue);
            
        } catch (EmptyStackException e) {
            Main.LOGGER.log(Level.INFO,"error: " + e);
            throw new CommandExecuteException("stack is empty ", e);
        }

    }
}
