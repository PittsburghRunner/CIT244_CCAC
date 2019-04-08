/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import javafx.collections.ObservableList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import timeline.components.Component;
import timeline.components.ComputerComponent;
import timeline.components.HumanInterestComponent;

/**
 *
 * @author christopher.eckles
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Timeline {

    String author;
    String Description;
    @XmlElements({
        @XmlElement(name = "Component", type = Component.class)
        ,
        @XmlElement(name = "ComputerComponent", type = ComputerComponent.class)
        ,
        @XmlElement(name = "HumanInterestComponent", type = HumanInterestComponent.class)

    })
    ArrayList<Component> components = new ArrayList<>();

    public int generateYearSince(int currYear) {
        return currYear - getStartYear();
    }

    public int getStartYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int year = 0000;
        Component oldest = getOldestComponent();
        if (oldest != null && oldest.getDate() != null) {
            year = Integer.valueOf(sdf.format(oldest.getDate()));
        }

        return year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public Component getOldestComponent() {
        sortTimeline();
        if (!components.isEmpty()) {
           return components.get(0);
        }
        return new Component();
    }

    public void sortTimeline() {
        Collections.sort(getComponents());
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    public void exportTimeline() {
        for (Component component : components) {
            component.export();
        }
    }

    public void loadTimeline() {

        //  this.components.add(component);
    }
}
