/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline.tests;

import java.util.HashMap;
import week4.timeline.Timeline;
import week4.timeline.components.Component;
import week4.timeline.components.ComputerComponent;

/**
 *
 * @author christopher.eckles
 */
public class TimelineTest {
    public static void main(String[] args) {
        Timeline timeline = new Timeline();
        
        HashMap ccMap = new HashMap();
        ccMap.put("year", 2007);
        ccMap.put("createdBy", "Apple");
        ccMap.put("description", "iPhone");
        ccMap.put("referenceSourceUrl", "http://www.apple.com/iPhone");
        
        ComputerComponent cc = new ComputerComponent(ccMap);
        
        
        
        
        for(Component component : timeline.getComponents()){
            System.out.println(component.toString());
        }
        
        
        
   
    }
}
