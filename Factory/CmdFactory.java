package Factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.logging.Level;

public class CmdFactory
{
    private static Properties properties = null;
    private static HashMap<String, Class> classes;
    static {
        classes = new HashMap<>();
        InputStream prop = null;
        try {
            prop = new FileInputStream("C:\\Users\\Анастасия\\Calculator\\src\\Factory\\CmdFactory.properties");
            properties = new Properties();
            Main.LOGGER.log(Level.INFO,"load properties");
            properties.load(prop);
        } catch (IOException e) {
            Main.LOGGER.log(Level.INFO,"error: " + e);
            System.out.println("IOException in CommandsFactory.properties " + e.getLocalizedMessage());
        } finally {
            try {
                if (prop != null) {
                    prop.close();
                }
            } catch (IOException e) {
                System.out.println("IOException: " + e.getLocalizedMessage());
            }
        }
    }


    public static CalcCommand getCommand(String cmdName) throws ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        CalcCommand command;
        Class<?> cmdClass;

        String commandUp = cmdName.toUpperCase();

        String key = properties.getProperty(commandUp);
        if (key == null) {
            throw new NoSuchElementException("Invalid command request: " + commandUp);
        }
        if (!ComExist(key)) {
            Main.LOGGER.log(Level.INFO,"create class");
            cmdClass = Class.forName(key);
            classes.put(cmdName, cmdClass);
        } else {
            cmdClass = classes.get(cmdName);
        }
        Main.LOGGER.log(Level.INFO,"create new instance of object");
        command = (CalcCommand) cmdClass.newInstance();

        return command;
    }

    public static Boolean ComExist(String comName)
    {
        if(classes.containsKey(comName))
            return true;
        else
            return false;
    }
}
