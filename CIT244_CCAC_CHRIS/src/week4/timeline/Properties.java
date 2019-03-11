package week4.timeline;

import java.util.ResourceBundle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author christopher.eckles
 */
public class Properties {
            public static final String TIMELINE_FILE_PATH = "timelinerepository";    
            public static final String TIMELINE_FILE = "TIMELINE";    
            public static final String FILE_SUFFIX = ".xml";    

   private ResourceBundle resourceBundle;

    public Properties(String propertyFilePath) {
       resourceBundle = ResourceBundle.getBundle(propertyFilePath);
    }

    public String getString(String key) {
        return resourceBundle.getString(key);

    }
            
}
