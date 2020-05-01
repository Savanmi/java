package Factory;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Logger LOGGER;
    private final static Context context = new Context();

    static {
        try(FileInputStream ins = new FileInputStream("C:\\Users\\Анастасия\\Calculator\\src\\Factory\\log.txt"))
        {
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Main.class.getName());
        } catch (Exception ignore){
            ignore.printStackTrace();
        }
    }
    public static void main(String args[]) {
        LOGGER.log(Level.INFO,"start main");
        Scanner scanner = null;
        if (args.length > 0) {

            try {
                LOGGER.log(Level.INFO,"open file " + args[0]);
                InputStream inputStream = new FileInputStream("C:\\Users\\Анастасия\\Calculator\\src\\Factory\\" + args[0]);
                scanner = new Scanner(inputStream);
            } catch (FileNotFoundException e) {
                LOGGER.log(Level.INFO,"error: " + e);
                System.err.println(e.getMessage());
                System.exit(0);
            }

        } else {
            scanner = new Scanner(System.in);
        }

        while (scanner.hasNextLine()) {
            String commandStr = scanner.nextLine();
            String cmd[] = commandStr.split(" ");
            List<String> cmdArguments = new ArrayList<String>(Arrays.asList(cmd).subList(1, cmd.length));

            try {
                LOGGER.log(Level.INFO,"create command " + cmd[0]);
                CalcCommand command = CmdFactory.getCommand(cmd[0]);
                LOGGER.log(Level.INFO,"execute command " + cmd[0]);
                command.execute(context, cmdArguments);
            } catch (Throwable e) {
                LOGGER.log(Level.INFO,"error: " + e);
                System.err.println("Error execute command: " + e.getLocalizedMessage());

            }
        }
        scanner.close();

    }
}

