package by.netcracker.bsuir.pz2.propertyManager;

import by.netcracker.bsuir.pz2.enumeration.PageLocationKey;

import java.io.*;
import java.util.Properties;

public class PageLocation {
    private final String PROP_FILE_LOCATION = this.getClass().getResource("/").getPath()
            + "pageLocation.properties";
    private File pageLocationPropertyFile = new File(PROP_FILE_LOCATION);
    private Properties pageLocationProperties = new Properties();

    private PageLocation() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pageLocationPropertyFile));
            pageLocationProperties.load(bufferedReader);
        } catch (FileNotFoundException exception) {
            System.out.println("Файл конфигурации не найден (PageLocation).");
        } catch (IOException e) {
            System.out.println("IOException (PageLocation)");
        }
    }

    private static class Holder {
        private static final PageLocation INSTANCE = new PageLocation();
    }

    public static PageLocation getInstance() {
        return Holder.INSTANCE;
    }

    public String getPageLocation(PageLocationKey propertyKey) {
        return pageLocationProperties.getProperty(propertyKey.toString());
    }
}
