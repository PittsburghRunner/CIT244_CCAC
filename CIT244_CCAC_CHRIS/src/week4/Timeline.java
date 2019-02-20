/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4;

import java.util.HashMap;

/**
 *
 * @author christopher.eckles
 */
public class Timeline implements Portable, Comparable {

    int year;
    String author;
    String description;

    public int generateYearSince(int currYear) {
        return currYear - year;
    }

    @Override
    public HashMap export() {
        HashMap exportMap = new HashMap();
        exportMap.put("year", year);
        exportMap.put("author", author);
        exportMap.put("description", description);
        
       return exportMap;
    }

    @Override
    public void load(HashMap map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Timeline) {
            Timeline t = (Timeline) o;
            if (this.year > t.year) {
                return 1;
            } else if (this.year < t.year) {
                return -1;
            } else {
                if (this.author.compareTo(t.author) == 0) {
                    return this.description.compareTo(t.description);
                } else {
                    return this.author.compareTo(t.author);
                }
            }
        }
        return 0;
    }

}// close class

