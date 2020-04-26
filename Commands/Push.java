package Commands;

import Factory.CalcCommand;
import Factory.CommandExecuteException;
import Factory.Context;

import java.util.List;
import java.util.NoSuchElementException;

public class Push implements CalcCommand
{
    @Override
    public void execute(Context context, List<String> myArgs) throws CommandExecuteException
    {
        String arg = myArgs.get(0);
        if (isDouble(arg)) {
            context.pushToStack(Double.parseDouble(arg));
        } else {
            // is a constant
            try {
                double constantValue = context.getConstant(arg);
                context.pushToStack(constantValue);
            } catch (NoSuchElementException e) {
                throw new CommandExecuteException("Cannot execute command because constant named " + arg + " is not exist", e);
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
