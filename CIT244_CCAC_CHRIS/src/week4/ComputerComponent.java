/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author christopher.eckles
 */
public class ComputerComponent extends Timeline implements Portable {

    int megahertzCPUSpeed;
    int componentReleaseYear;
    String description;
    double comunicationSpeed;
    String comunicationSpeedUnit;
    String manufacturer;

    @Override
    public HashMap export() {
        HashMap exportMap = super.export();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
