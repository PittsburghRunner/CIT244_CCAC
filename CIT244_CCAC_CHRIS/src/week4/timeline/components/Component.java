/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline.components;

import java.util.Date;
import week4.timeline.components.interfaces.Portable;
import java.util.HashMap;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import week4.utils.lits.ListType;
import week4.utils.lits.input.PromptParams;

/**
 *
 * @author christopher.eckles
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Component implements Portable, Comparable {

    @PromptParams(hidden=true)
    private String object;
    @PromptParams(name="Created On", min=1900, max=2022, listType=ListType.DATE)
    private Date createdOn;
    @PromptParams(name="Created By", min=4, max=300, listType=ListType.STRING_MIN_MAX)
    private String createdBy;
    @PromptParams(name="Description", min=4, max=300, listType=ListType.STRING_MIN_MAX)
    private String description;
    @PromptParams(name="Reference Source URL", min=4, max=300, listType=ListType.STRING_MIN_MAX)
    private String referenceSourceUrl;

    public Component() {
        object=this.getClass().toString();
    }

    public Component(Date date, String description, String createdBy, String referenceSourceUrl) {

        this.createdOn=date;
        this.description=description;
        this.createdBy=createdBy;
        this.referenceSourceUrl=referenceSourceUrl;
    }

    public Component(HashMap map) {
        load(map);
    }

    @Override
    public HashMap export() {
        HashMap exportMap=new HashMap();
        exportMap.put("object", this.getClass().toString());
        exportMap.put("date", createdOn);
        exportMap.put("createdBy", createdBy);
        exportMap.put("description", description);
        exportMap.put("referenceSourceUrl", referenceSourceUrl);

        return exportMap;
    }

    @Override
    public void load(HashMap map) {
        object=(String) map.getOrDefault("object", this.getClass().toString());
        createdOn=(Date) map.getOrDefault("year", new Date());
        createdBy=(String) map.getOrDefault("createdBy", "");
        description=(String) map.getOrDefault("description", "");
        referenceSourceUrl=(String) map.getOrDefault("referenceSourceUrl", "");
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Component) {
            Component t=(Component) o;
            if (this.getDate().compareTo(t.getDate()) != 0) {
                return this.getDate().compareTo(t.getDate());
            } else if (this.getDescription().compareTo(t.getDescription()) != 0) {
                return this.getDescription().compareTo(t.getDescription());
            } else {
                return this.getCreatedBy().compareTo(t.getCreatedBy());
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Object: " + object
                + "   Date: " + createdOn
                + "   Created By: " + createdBy
                + "   Description By: " + description
                + "   Url: " + referenceSourceUrl;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object=object;
    }

    public Date getDate() {
        return createdOn;
    }

    public void setDate(Date date) {
        this.createdOn=date;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy=createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public String getReferenceSourceUrl() {
        return referenceSourceUrl;
    }

    public void setReferenceSourceUrl(String referenceSourceUrl) {
        this.referenceSourceUrl=referenceSourceUrl;
    }

}// close class

