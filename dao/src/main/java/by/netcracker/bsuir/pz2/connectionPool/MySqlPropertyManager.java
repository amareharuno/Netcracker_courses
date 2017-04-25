package by.netcracker.bsuir.pz2.connectionPool;

import by.netcracker.bsuir.pz2.enumeration.MySqlPropertyKey;

import java.io.*;
import java.util.Properties;

public class MySqlPropertyManager {

    private Properties bdProperties = new Properties();
    private final String PROP_FILE_LOCATION = "F:\\NetCracker\\projects\\courses\\dao\\src\\main\\resources\\mysqldb.properties";
//    private final String PROP_FILE_LOCATION = System.getProperty("user.dir") + "\\dao\\src\\main\\resources\\" + "mysqldb.properties";

    private File bdPropertyFile = new File(PROP_FILE_LOCATION);

    private MySqlPropertyManager() {
        try {
            System.out.println("Prop file location: " + PROP_FILE_LOCATION);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(bdPropertyFile));
            bdProperties.load(bufferedReader);
        } catch (FileNotFoundException exception) {
            System.out.println("Файл конфигурации не найден (MySqlPropertyManager).");
        } catch (IOException e) {
            System.out.println("IOException (MySqlPropertyManager)");
        }
    }

    private static class Holder {
        private static final MySqlPropertyManager INSTANCE = new MySqlPropertyManager();
    }

    public static MySqlPropertyManager getInstance() {
        return Holder.INSTANCE;
    }

    public String getDbProperty(MySqlPropertyKey propertyKey) {
        return bdProperties.getProperty(propertyKey.toString());
    }
}
