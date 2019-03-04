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

    @PromptParams(name = "MHZ CPU Speed", min = 1, max = 0, listType = ListType.INTEGER)
    int megahertzCPUSpeed;
    @PromptParams(name = "Communication Speed", min = 1, max = 0, listType = ListType.INTEGER)
    double comunicationSpeed;
    @PromptParams(name = "Communication Speed Unit", min = 1, max = 20, listType = ListType.DEFAULT)
    String comunicationSpeedUnit;
    @PromptParams(name = "Manufacturer", min = 1, max = 300, listType = ListType.DEFAULT)
    String manufacturer;

    public ComputerComponent() {

    }
    
    public ComputerComponent(HashMap map) {
        load(map);
    }

    @Override
    public HashMap export() {
        HashMap exportMap = super.export();
        exportMap.put("object", this.getClass().toString());
        exportMap.put("megahertzCPUSpeed", megahertzCPUSpeed);
        exportMap.put("description", description);
        exportMap.put("comunicationSpeed", comunicationSpeed);
        exportMap.put("comunicationSpeedUnit", comunicationSpeedUnit);
        exportMap.put("manufacturer", manufacturer);
        return exportMap;
    }

    @Override
    public void load(HashMap map) {
        super.load(map);
        megahertzCPUSpeed = (int) map.getOrDefault(megahertzCPUSpeed, 0);
        comunicationSpeed = (double) map.getOrDefault(comunicationSpeed, 0d);
        comunicationSpeedUnit = (String) map.getOrDefault(comunicationSpeedUnit, "");
        manufacturer = (String) map.getOrDefault(manufacturer, "");

    }

}
