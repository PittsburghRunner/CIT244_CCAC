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
import week4.utils.lits.ListType;
import week4.utils.lits.input.PromptParams;

/**
 *
 * @author christopher.eckles
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class HumanInterestComponent extends Component {

    @PromptParams(name = "Is this really interesting", min = 1, max = 1, listType = ListType.BOOLEAN)
    Boolean isInteresting;

    
    public HumanInterestComponent(){
        setDate(new Date());
    }
            
    
    public HumanInterestComponent(Date date, String description, String createdBy){
        setDate(date);
        setDescription(description);
        setCreatedBy(createdBy);
    }
    
    public HumanInterestComponent(HashMap map){
        load(map);
    }
    
    @Override
    public HashMap export() {
        HashMap exportMap = super.export();
        exportMap.put("isInteresting",isInteresting);
        return exportMap;
    }

    @Override
    public void load(HashMap map) {
        isInteresting = (Boolean) map.get("isInteresting");
        super.load(map);
    }

    @Override
    public String toString() {
        return super.toString() + "   Is Interesting: " + isInteresting;
  }
    
    public boolean isIsInteresting() {
        return isInteresting;
    }

    public void setIsInteresting(boolean isInteresting) {
        this.isInteresting = isInteresting;
    }
    
    

}
