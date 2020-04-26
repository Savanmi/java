package Commands;

import Factory.CalcCommand;
import Factory.CommandExecuteException;
import Factory.Context;

import java.util.EmptyStackException;
import java.util.List;

public class Sqrt implements CalcCommand
{
    @Override
    public void execute(Context context, List<String> myArgs) throws CommandExecuteException
    {
        double a;
        try {
            a = context.popFromStack();
        } catch (EmptyStackException e) {
            throw new CommandExecuteException("Cannot execute command because stack is empty", e);
        }
        if (a < 0.0) {
            throw new CommandExecuteException("Argumet of sqrt commant cant be less zero");
        }
        double result = Math.sqrt(a);

        context.pushToStack(result);
    }
}
