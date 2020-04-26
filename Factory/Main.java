package Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final static Context context = new Context();

    public static void main(String args[]) {

        Scanner scanner = null;
        if (args.length > 0) {

            try {
                InputStream inputStream = new FileInputStream("C:\\Users\\Анастасия\\Calculator\\src\\Factory\\" + args[0]);
                scanner = new Scanner(inputStream);
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
                System.exit(0);
            }

        } else {
            scanner = new Scanner(System.in);
        }

        while (scanner.hasNextLine()) {
            String commandStr = scanner.nextLine();
            String cmd[] = commandStr.split(" ");
            List<String> cmdArguments = new ArrayList<String>(Arrays.asList(cmd).subList(1, cmd.length));//берем список пааметров

            try {
                CalcCommand command = CmdFactory.getCommand(cmd[0]);
                command.execute(context, cmdArguments);
            } catch (Throwable e) {
                System.err.println("Error execute command: " + e.getLocalizedMessage());

            }
        }
        scanner.close();

    }
}

