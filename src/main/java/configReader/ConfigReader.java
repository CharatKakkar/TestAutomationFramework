package configReader;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;
    private FileInputStream ip;

    public Properties initLangProp(String lang) {

        System.out.println("lang is : " + lang);
        prop = new Properties();
        try {
            switch (lang.toLowerCase()) {
                case "eng":
                    ip = new FileInputStream("src/resources/lang.eng.properties");
                    break;
                case "fr":
                    ip = new FileInputStream("src/resources/lang.fr.properties");
                    break;
                default:
                    System.out.println("lang not found..." + lang);
                    break;
            }
            prop.load(ip);
        } catch (Exception e) {
            System.out.println(lang + " : properties file not found");
        }
        return prop;
    }
}
