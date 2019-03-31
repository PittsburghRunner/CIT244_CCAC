/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.components;

import java.text.SimpleDateFormat;
import java.util.Date;
import timeline.components.interfaces.Portable;
import java.util.HashMap;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import timeline.utils.lits.ListType;
import timeline.utils.lits.input.PromptParams;

/**
 *
 * @author christopher.eckles
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Component implements Portable, Comparable {

    @PromptParams(hidden=true)
    public String object;
    @PromptParams(name="created.on", min=1900, max=2022, listType=ListType.DATE)
    public Date createdOn;
    @PromptParams(name="created.by", min=4, max=300, listType=ListType.STRING_MIN_MAX)
    public String createdBy;
    @PromptParams(name="title", min=4, max=300, listType=ListType.STRING_MIN_MAX)
    public String title;
    @PromptParams(name="description", min=4, max=3000, listType=ListType.STRING_MIN_MAX)
    public String description;
    @PromptParams(name="reference.source.url", min=4, max=300, listType=ListType.STRING_MIN_MAX)
    public String referenceSourceUrl;
    @PromptParams(name="image.url", min=4, max=300, listType=ListType.STRING_MIN_MAX)
    public String imageUrl;

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
        exportMap.put("createdOn", createdOn);
        exportMap.put("createdBy", createdBy);
        exportMap.put("title", title);
        exportMap.put("description", description);
        exportMap.put("referenceSourceUrl", referenceSourceUrl);

        return exportMap;
    }

    @Override
    public void load(HashMap map) {
        object=(String) map.getOrDefault("object", this.getClass().toString());
        createdOn=(Date) map.get("createdOn");
        createdBy=(String) map.get("createdBy");
        title=(String) map.get("title");
        description=(String) map.get("description");
        referenceSourceUrl=(String) map.get("referenceSourceUrl");
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Component) {
            Component t=(Component) o;
            if (this.getDate().compareTo(t.getDate()) != 0) {
                return this.getDate().compareTo(t.getDate());
            } else if (this.getTitle().compareTo(t.getTitle()) != 0) {
                return this.getTitle().compareTo(t.getTitle());
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return  sdf.format(createdOn)  + " - Title: " + title
                + " (" + object
                + "   Created By: " + createdBy
                + "   Url: " + referenceSourceUrl;
    }
    
    public String toWireframe() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return  "[],"+sdf.format(createdOn)  
                + "," + title
                + "," + createdBy
                + "," + referenceSourceUrl;
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    

}// close class

