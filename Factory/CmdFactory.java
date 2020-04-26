package Factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.TreeMap;

public class CmdFactory
{

    private static Properties properties = null;
    private static HashMap<String, Class> classes = null; // МОЖНО НЕ ТРИМЭП?

    static {
        classes = new HashMap<>();
        InputStream prop = null;

        try {
            prop = new FileInputStream("C:\\Users\\Анастасия\\Calculator\\src\\Factory\\CmdFactory.properties");
            properties = new Properties();
            properties.load(prop);
        } catch (IOException e) {
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

        String commandUp = cmdName.toUpperCase();//верхний регистр

        String key = properties.getProperty(commandUp);
        if (key == null) {
            throw new NoSuchElementException("Invalid command request: " + commandUp);
        }
        if (!classes.containsKey(key)) {
            cmdClass = Class.forName(key);//загружает класс
            classes.put(cmdName, cmdClass);
        } else {
            cmdClass = classes.get(cmdName);
        }
        command = (CalcCommand) cmdClass.newInstance();//newInstance() возвращает объет обобщенного типа Object

        return command;
    }
}
