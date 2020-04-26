package Factory;

import Factory.CalcCommand;
import Factory.CommandExecuteException;
import Factory.Context;

import java.util.EmptyStackException;
import java.util.List;

public class Print implements CalcCommand
{
    @Override
    public void execute(Context context, List<String> myArgs) throws CommandExecuteException
    {
        try {
            double a = context.peekAtStack();
            System.out.println("Result: " + a);
        } catch (EmptyStackException e) {
            throw new CommandExecuteException("Cannot execute command because stack is empty", e);
        }
    }
}
