package Utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

public class PropertiesUtils {

    private PropertiesUtils()
    {
        super();
    }

    public static final String PROPERTIES_PATH = "src/main/resources";

    public static Properties loadProperties() {
        try {
            Properties properties = new Properties();
            Collection<File> PropertiesFileList;
            PropertiesFileList = FileUtils.listFiles(new File(PROPERTIES_PATH), new String[]{"properties"}, false);
            PropertiesFileList.forEach(propertyFile -> {
            try {
                properties.load(new FileInputStream(propertyFile));
            } catch (IOException ioe) {
                Logs.error(ioe.getMessage());
            }
            properties.putAll(System.getProperties());
            System.getProperties().putAll(properties);
        });
        Logs.info("Loading Properties File Data");
        return properties;
        } catch (Exception e) {

            Logs.error("Failed to Load Properties File Data because: " + e.getMessage());
            return null;
        }
    }

    public static String getPropertyValue(String Key)
    {
        try {
            return System.getProperty(Key);
        }
        catch (Exception e)
        {
            Logs.error(e.getMessage());
            return "";
        }

    }
}
