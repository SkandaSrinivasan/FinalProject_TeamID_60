/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JxMaps.resources;

import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Skanda
 */
public class AppConfig {

    private static final String CONFIG_FILE_NAME = "map.properties";
    private static final Properties systemPropeties = new Properties();
    private AppConfig singletonInstance;

    static {
        InputStream input = AppConfig.class.getResourceAsStream(CONFIG_FILE_NAME);
        try {
            if (input == null) {
                throw new Exception("properties file is empty");
            }
            AppConfig.systemPropeties.load(input);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public AppConfig() {

    }

    public AppConfig getInstance() {
        if (this.singletonInstance == null) {
            this.singletonInstance = new AppConfig();
        }
        return this.singletonInstance;
    }

    public String getGMapsApiKey() {
        return systemPropeties.getProperty("API_KEY");
    }
}
