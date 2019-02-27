package week4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author christopher.eckles
 */
import java.util.HashMap;
import week4.timeline.Timeline;

import week4.timeline.components.Component;
import week4.timeline.components.ComputerComponent;
import week4.timeline.components.HumanInterestComponent;

import week4.timeline.io.files.XMLUtilities;

public class TestWriting {

    public static void main(String[] args) {

        Timeline timeline = new Timeline();

        HashMap<String, Object> ccMap = new HashMap();
        ccMap.put("year", 2007);
        ccMap.put("createdBy", "Apple");
        ccMap.put("description", "iPhone");
        ccMap.put("referenceSourceUrl", "http://www.apple.com/iPhone");

        HashMap<String, Object> hicMap = new HashMap();
        hicMap.put("year", 2018);
        hicMap.put("createdBy", "Microsoft");
        hicMap.put("description", "Surface Pro");
        hicMap.put("referenceSourceUrl", "http://www.microsoft.com");

        ComputerComponent cc = new ComputerComponent(ccMap);
        HumanInterestComponent hic = new HumanInterestComponent(hicMap);

        timeline.getComponents().add(cc);
        timeline.getComponents().add(hic);

        XMLUtilities.componentToXMLFile(timeline);

    }

}
