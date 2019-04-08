package timeline;

import java.util.Locale;
import java.util.ResourceBundle;
import timeline.menus.LanguageMenu;

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

    private static final String LABELS_BUNDLE = "timeline.resources.labels";
    private static ResourceBundle labels =  ResourceBundle.getBundle(LABELS_BUNDLE);
    
    public static String getLabel(String key) {
        String value = key;
        try {
            value = labels.getString(key);
        } catch (Exception e) {
        }
        return value;
    }

    public static ResourceBundle getLabelsBundle() {
        return labels;
    }

    public static void refreshLabelsBundle() {
        labels = ResourceBundle.getBundle(LABELS_BUNDLE, Locale.getDefault());
    }
    
}
