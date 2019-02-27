/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline.components;

import week4.timeline.components.interfaces.Portable;
import java.util.HashMap;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author christopher.eckles
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Component implements Portable, Comparable {

    String object;
    int year;
    String createdBy;
    String description;
    String referenceSourceUrl;

    public Component() {
        object = this.getClass().toString();
    }
    
    public Component(int year, String description, String createdBy, String referenceSourceUrl){
       
        this.year = year;
        this.description = description;
        this.createdBy = createdBy;
        this.referenceSourceUrl = referenceSourceUrl;
    }
    

    public Component(HashMap map) {
        load(map);
    }

    @Override
    public HashMap export() {
        HashMap exportMap = new HashMap();
        exportMap.put("object", this.getClass().toString());
        exportMap.put("year", year);
        exportMap.put("createdBy", createdBy);
        exportMap.put("description", description);
        exportMap.put("referenceSourceUrl", referenceSourceUrl);

        return exportMap;
    }

    @Override
    public void load(HashMap map) {
       object = (String) map.getOrDefault("object", this.getClass().toString());
       year = (int) map.getOrDefault("year", 0000);
       createdBy = (String) map.getOrDefault("createdBy", "");
       description = (String) map.getOrDefault("description", "");
       referenceSourceUrl = (String) map.getOrDefault("referenceSourceUrl", "");
    }
    
    @Override
    public int compareTo(Object o) {
        if (o instanceof Component) {
            Component t = (Component) o;
            if (this.year > t.year) {
                return 1;
            } else if (this.year < t.year) {
                return -1;
            } else {
                if (this.createdBy.compareTo(t.createdBy) == 0) {
                    return this.description.compareTo(t.description);
                } else {
                    return this.createdBy.compareTo(t.createdBy);
                }
            }
        }
        return 0;
    }
    
    @Override
    public String toString(){
        return    "Object: " + object +
    "   Year: " +  year +
    "   Created By: " +  createdBy +
    "   Description By: " +  description +
    "   Url: " +  referenceSourceUrl;
    }

}// close class

