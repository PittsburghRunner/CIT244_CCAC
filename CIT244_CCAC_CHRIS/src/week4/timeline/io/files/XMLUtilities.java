/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline.io.files;

import java.io.File;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import week4.timeline.Properties;
import week4.timeline.Timeline;

/**
 *
 * @author christopher.eckles
 */
public class XMLUtilities {
    public static void componentToXMLFile(Timeline timeline) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(timeline.getClass());

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Print XML String to Console
            StringWriter sw = new StringWriter();

            //Write XML to StringWriter
            jaxbMarshaller.marshal(timeline, sw);

            //Verify XML Content
            String xmlContent = sw.toString();
            System.out.println(xmlContent);
            
            //Store XML to File
            File file = new File(Properties.TIMELINE_FILE_PATH,timeline.hashCode()+Properties.TIMELINE_COMPONENT_SUFFIX);
            
            //Writes XML file to file-system
            jaxbMarshaller.marshal(timeline, file); 

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
