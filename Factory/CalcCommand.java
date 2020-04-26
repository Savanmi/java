package Factory;

import java.util.List;

public interface CalcCommand {

    public void execute(Context context , List<String> myArgs ) throws CommandExecuteException;

}
