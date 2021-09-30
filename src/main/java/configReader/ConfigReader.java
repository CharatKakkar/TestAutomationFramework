package configReader;

import utils.Log;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;
    private FileInputStream ip;

    public Properties initLangProp(String lang) {

        Log.debug("lang is : " + lang);
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
                    Log.debug("lang not found..." + lang);
                    break;
            }
            prop.load(ip);
        } catch (Exception e) {
            Log.error(lang + " : properties file not found");
        }
        return prop;
    }
}
