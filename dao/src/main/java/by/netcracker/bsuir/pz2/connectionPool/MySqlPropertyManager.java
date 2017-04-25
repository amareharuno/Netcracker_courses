package by.netcracker.bsuir.pz2.connectionPool;

import by.netcracker.bsuir.pz2.enumeration.MySqlPropertyKey;

import java.io.*;
import java.util.Properties;

public enum  MySqlPropertyManager {

    INSTANCE;

    private Properties bdProperties = new Properties();
//    private final String PROP_FILE_LOCATION = this.getClass().getResource("/").getPath() + "mysqldb.properties";
//    private final String PROP_FILE_LOCATION = System.getProperty("user.dir") + "\\dao\\src\\main\\resources\\" + "mysqldb.properties";

    MySqlPropertyManager() {
        try {
            String PROP_FILE_LOCATION = "F:\\NetCracker\\projects\\courses\\dao\\src\\main\\resources\\mysqldb.properties";
            System.out.println("Prop file location: " + PROP_FILE_LOCATION);
            File bdPropertyFile = new File(PROP_FILE_LOCATION);

            BufferedReader bufferedReader = new BufferedReader(new FileReader(bdPropertyFile));
            bdProperties.load(bufferedReader);
        } catch (FileNotFoundException exception) {
            System.out.println("Файл конфигурации не найден (MySqlPropertyManager).");
        } catch (IOException e) {
            System.out.println("IOException (MySqlPropertyManager)");
        }
    }

    public String getDbProperty(MySqlPropertyKey propertyKey) {
        return bdProperties.getProperty(propertyKey.toString());
    }
}
