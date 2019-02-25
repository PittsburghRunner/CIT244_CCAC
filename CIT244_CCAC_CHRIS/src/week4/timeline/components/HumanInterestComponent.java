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
public class HumanInterestComponent extends Component {

    HumanInterestComponent(){
        this.year = 0000;
    }
            
    
    HumanInterestComponent(int year, String description, String createdBy){
        this.year = year;
        this.description = description;
        this.createdBy = createdBy;
    }
    
    HumanInterestComponent(HashMap map){
        load(map);
    }
    
    @Override
    public HashMap export() {
        HashMap exportMap = super.export();
        exportMap.put("object",this.getClass().toString());
        return exportMap;
    }

    @Override
    public void load(HashMap map) {
        
    }

}
