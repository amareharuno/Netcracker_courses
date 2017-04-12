package by.netcracker.bsuir.pz2.connectionpool;

import by.netcracker.bsuir.pz2.enumeration.MySqlPropertyKey;

import java.io.*;
import java.util.Properties;

public class MySqlPropertyManager {
    private final String PROP_FILE_LOCATION = this.getClass().getResource("/").getPath()
            + "mysqldb.properties";
    private File bdPropertyFile = new File(PROP_FILE_LOCATION);
    private Properties bdProperties = new Properties();

    private MySqlPropertyManager() {
        try {
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
