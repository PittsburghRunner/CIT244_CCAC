/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline.io.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import week4.timeline.Properties;
import week4.timeline.Timeline;

/**
 *
 * @author christopher.eckles
 */
public class XMLUtilities {

    public static void saveTimelineToXML(Timeline timeline) throws JAXBException, FileNotFoundException {

        JAXBContext jaxbContext = JAXBContext.newInstance(timeline.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter sw = new StringWriter();

        //Write XML to StringWriter
        jaxbMarshaller.marshal(timeline, sw);

        //Verify XML Content
        String xmlContent = sw.toString();
        System.out.println(xmlContent);

        //Store XML to File
        File file = new File(Properties.TIMELINE_FILE_PATH, Properties.TIMELINE_FILE + Properties.FILE_SUFFIX);

        //Writes XML file to file-system
        jaxbMarshaller.marshal(timeline, file);
        
        System.out.println("Saved to:" + file.getAbsolutePath());

    }

    public static Timeline loadXMLTimeline() throws JAXBException, FileNotFoundException {

        File file = new File(Properties.TIMELINE_FILE_PATH, Properties.TIMELINE_FILE + Properties.FILE_SUFFIX);

        JAXBContext jaxbContext = JAXBContext.newInstance(Timeline.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        Timeline timeline = (Timeline) unmarshaller.unmarshal(file);

        return timeline;
    }
}
