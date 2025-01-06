package org.automation.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class Utility {
    public static String fetchPropertyValue(String key) throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\SwadhinKumarJena\\IdeaProjects\\DataDriven_Framework\\src\\test\\resources\\config.properties");
        Properties prop = new Properties();
        prop.load(file);

        return prop.get(key).toString();
    }
    public static String fetchLocatorValue(String key) throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\SwadhinKumarJena\\IdeaProjects\\DataDriven_Framework\\src\\test\\resources\\element.properties");
        Properties prop = new Properties();
        prop.load(file);

        return prop.get(key).toString();
    }
    public static String fetchCompareValue(String key) throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\SwadhinKumarJena\\IdeaProjects\\DataDriven_Framework\\src\\test\\resources\\compare.properties");
        Properties prop = new Properties();
        prop.load(file);

        return prop.get(key).toString();
    }
    public static String fetchExcelValue(String key) throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\SwadhinKumarJena\\IdeaProjects\\DataDriven_Framework\\src\\test\\resources\\excelPath.properties");
        Properties prop = new Properties();
        prop.load(file);

        return prop.get(key).toString();
    }



}
