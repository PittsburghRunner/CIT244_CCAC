/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline.components;

import java.util.HashMap;

/**
 *
 * @author christopher.eckles
 */
public class ComputerComponent extends Component  {

    int megahertzCPUSpeed;
    int componentReleaseYear;
    double comunicationSpeed;
    String comunicationSpeedUnit;
    String manufacturer;
    
    public ComputerComponent(HashMap map){
        load(map);
        
    }

    @Override
    public HashMap export() {
        HashMap exportMap = super.export();
        exportMap.put("object",this.getClass().toString());
        exportMap.put("megahertzCPUSpeed", megahertzCPUSpeed);
        exportMap.put("componentReleaseYear", componentReleaseYear);
        exportMap.put("description", description);
        exportMap.put("comunicationSpeed", comunicationSpeed);
        exportMap.put("comunicationSpeedUnit", comunicationSpeedUnit);
        exportMap.put("manufacturer", manufacturer);
        return exportMap;
    }

    @Override
    public void load(HashMap map) {
        super.load(map);
        
    }

}
