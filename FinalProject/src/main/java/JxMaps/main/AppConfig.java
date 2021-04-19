/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JxMaps.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Skanda
 */
public class AppConfig {

    private static final String CONFIG_FILE_NAME = "map.properties";
    private static final Properties systemPropeties = new Properties();
    private static AppConfig singletonInstance;
    static {
        InputStream input;
        try {
            input = AppConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
            if (input == null) {
                throw new Exception("properties file is empty");
            }
            AppConfig.systemPropeties.load(input);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppConfig.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            
        }

    }

    public AppConfig() {

    }

    public static AppConfig getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new AppConfig();
        }
        return singletonInstance;
    }

    public String getGMapsApiKey() {
        return systemPropeties.getProperty("API_KEY");
    }
    
    public String getJXBrowserLicenseKey() {
        return systemPropeties.getProperty("LICENSE_KEY");
    }
}
