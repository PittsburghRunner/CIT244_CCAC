/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline.components;

import java.util.Date;
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
public class HumanInterestComponent extends Component {

    public HumanInterestComponent(){
        this.date = new Date();
    }
            
    
    public HumanInterestComponent(Date date, String description, String createdBy){
        this.date = date;
        this.description = description;
        this.createdBy = createdBy;
    }
    
    public HumanInterestComponent(HashMap map){
        load(map);
    }
    
//    @Override
//    public HashMap export() {
//        HashMap exportMap = super.export();
//        exportMap.put("object",this.getClass().toString());
//        return exportMap;
//    }

    @Override
    public void load(HashMap map) {
        super.load(map);
    }

}
