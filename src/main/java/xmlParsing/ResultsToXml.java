/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package xmlParsing;

import database.MyResult;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Guillaume
 */
public class ResultsToXml {
    
    public static void generateXml(MyResult results) throws JAXBException{
        // creation of the context
        JAXBContext jaxbContext = JAXBContext.newInstance(MyResult.class);
        // creation of the marshaller
        Marshaller marshaller = jaxbContext.createMarshaller();
        // setting properties for output XML
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(true));
        
        // marshalling the object into the library_output.xml
        marshaller.marshal(results, System.out);
    }
    
}
