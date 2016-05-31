/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ETL;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
/**
 *
 * @author Tomás
 */
public class LoadFestivities {
    
    static Festivities festivities = new Festivities();
    
    private static Festivities unMarshalingFestivities() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Festivities.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Festivities emps;
        emps = (Festivities) jaxbUnmarshaller.unmarshal( new File("C:\\source\\festivities.xml") );
        
        festivities.setFestivities(new ArrayList<Festivity>());
        
        for(Festivity emp : emps.getFestivities())
        {
                System.out.println(emp.getName());
                System.out.println(emp.getPlace());
                System.out.println(emp.getStart());
                System.out.println(emp.getEnd());
                festivities.getFestivities().add(emp);                     
        }
        return festivities;
    }
    
    private static void marshalingExample() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Festivities.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(festivities, System.out);
        jaxbMarshaller.marshal(festivities, new File("c:/source/festivitiesOut.xml"));
    }
    
    
    public static void main(String[] args) throws JAXBException {
        Festivities festivities2 = new Festivities();
        festivities2.setFestivities(new ArrayList<Festivity>());
        System.out.println("Hello World!"); //Display the string.
        festivities2 = unMarshalingFestivities();
    }
}
