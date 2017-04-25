package by.netcracker.bsuir.pz2.propertyManager;

import by.netcracker.bsuir.pz2.enumeration.PageLocationKey;

import java.io.*;
import java.util.Properties;

public enum  PageLocation {
    INSTANCE;

    private Properties pageLocationProperties = new Properties();

    private PageLocation() {
        try {
            String PROP_FILE_LOCATION = this.getClass().getResource("/").getPath()
                    + "pageLocation.properties";
            System.out.println("PROP_FILE_LOCATION: " + PROP_FILE_LOCATION);
            File pageLocationPropertyFile = new File(PROP_FILE_LOCATION);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pageLocationPropertyFile));
            pageLocationProperties.load(bufferedReader);
        } catch (FileNotFoundException exception) {
            System.out.println("Файл конфигурации не найден (PageLocation).");
        } catch (IOException e) {
            System.out.println("IOException (PageLocation)");
        }
    }

    public String getPageLocation(PageLocationKey propertyKey) {
        return pageLocationProperties.getProperty(propertyKey.toString());
    }
}
