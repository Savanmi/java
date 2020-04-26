package Commands;

import Factory.CalcCommand;
import Factory.CommandExecuteException;
import Factory.Context;

import java.util.EmptyStackException;
import java.util.List;

public class Sub implements CalcCommand
{
    @Override
    public void execute(Context context, List<String> myArgs) throws CommandExecuteException
    {
        try {
            double b = context.popFromStack();
            double a = context.popFromStack();

            context.pushToStack(a - b);
        } catch (EmptyStackException e) {
            throw new CommandExecuteException("Cannot execute command because stack is empty ", e);
        }
    }
}
