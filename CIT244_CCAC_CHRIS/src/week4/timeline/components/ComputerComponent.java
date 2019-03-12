/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline.components;

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
public class ComputerComponent extends Component {

    @PromptParams(name = "MHZ CPU Speed", min = 1, max = 999999, listType = ListType.INTEGER)
    private int megahertzCPUSpeed;
    @PromptParams(name = "Communication Speed", min = 1, max = 999999, listType = ListType.DOUBLE)
    private double comunicationSpeed;
    @PromptParams(name = "Communication Speed Unit", min = 1, max = 20, listType = ListType.DEFAULT)
    private String comunicationSpeedUnit;
    @PromptParams(name = "Manufacturer", min = 1, max = 300, listType = ListType.DEFAULT)
    private String manufacturer;

    public ComputerComponent() {

    }
    
    public ComputerComponent(HashMap map) {
        load(map);
    }

    @Override
    public HashMap export() {
        HashMap exportMap = super.export();
        exportMap.put("object", this.getClass().toString());
        exportMap.put("megahertzCPUSpeed", getMegahertzCPUSpeed());
        exportMap.put("description", getDescription());
        exportMap.put("comunicationSpeed", getComunicationSpeed());
        exportMap.put("comunicationSpeedUnit", getComunicationSpeedUnit());
        exportMap.put("manufacturer", getManufacturer());
        return exportMap;
    }

    @Override
    public void load(HashMap map) {
        super.load(map);
        megahertzCPUSpeed = (int) map.getOrDefault("megahertzCPUSpeed",0);
        comunicationSpeed = (Double) map.getOrDefault("comunicationSpeed",0d);
        comunicationSpeedUnit = (String) map.get("comunicationSpeedUnit");
        manufacturer = (String) map.get("manufacturer");

    }
    
    @Override
    public String toString() {
        return super.toString() + "   Megahertz CPU Speed: " + megahertzCPUSpeed
                + "   Comunication Speed: " + comunicationSpeed
                + "   Comunication Speed Unit: " + comunicationSpeedUnit
                + "   Manufacturer: " + manufacturer;
    }

    public int getMegahertzCPUSpeed() {
        return megahertzCPUSpeed;
    }

    public void setMegahertzCPUSpeed(int megahertzCPUSpeed) {
        this.megahertzCPUSpeed = megahertzCPUSpeed;
    }

    public double getComunicationSpeed() {
        return comunicationSpeed;
    }

    public void setComunicationSpeed(double comunicationSpeed) {
        this.comunicationSpeed = comunicationSpeed;
    }

    public String getComunicationSpeedUnit() {
        return comunicationSpeedUnit;
    }

    public void setComunicationSpeedUnit(String comunicationSpeedUnit) {
        this.comunicationSpeedUnit = comunicationSpeedUnit;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    

}
