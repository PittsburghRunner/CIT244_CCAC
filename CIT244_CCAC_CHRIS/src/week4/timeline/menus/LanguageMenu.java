/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline.menus;

import java.util.Arrays;
import java.util.Locale;

/**
 *
 * @author ceckles
 */
public enum LanguageMenu {
    US_ENGLISH(1, new Locale("en","US")),
    CANADIAN_ENGLISH(2, new Locale("en","CA")),
    CANADIAN_FRENCH(3, new Locale("fr","CA")),
    FRANCE_FRENCH(3, new Locale("fr","FR")),
    GERMANY_GERMAN(4, new Locale("de","DE")),
    MEXICO_SPANISH(5, new Locale("es","MX")),
    EXIT(6, null);
    

    int menuItemid;
    Locale locale;


    LanguageMenu(int id, Locale loc) {
        menuItemid = id;
        locale = loc;
    }

    public int getMenuItemid() {
        return menuItemid;
    }

    public Locale getLocale() {
        return locale;
    }


    @Override
    public String toString() {
        if(getLocale() == null){
            return menuItemid + " - " + this.name();
        }
        return menuItemid + " - " + getLocale().getDisplayName();
    }

    public static void printEntireMenu() {
        for (LanguageMenu mi : LanguageMenu.values()) {
            System.out.println(mi.toString());
        }
    }

    public static LanguageMenu findById(final int id) {
        return Arrays.stream(values()).filter(value -> value.getMenuItemid() == id).findFirst().orElse(null);
    }

}
