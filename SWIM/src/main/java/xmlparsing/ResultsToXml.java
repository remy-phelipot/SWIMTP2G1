/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package xmlparsing;

import database.MyResult;
import java.io.File;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Guillaume
 */
public class ResultsToXml {
    
    /**
     * Allows to generate an XML file for the results given in parameters
     * @param results to serialize
     * @param filePath to the XML file (file must be created before calling this method)
     * @throws JAXBException in case of error while marshaling
     * @throws FileNotFoundException in case of wrong path
     */
    public static void generateXml(MyResult results, String filePath) throws JAXBException,FileNotFoundException{
        // creation of the context
        JAXBContext jaxbContext = JAXBContext.newInstance(MyResult.class);
        // creation of the marshaller
        Marshaller marshaller = jaxbContext.createMarshaller();
        // setting properties for output XML
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // marshalling the object into the library_output.xml
        marshaller.marshal(results, new File(filePath));
    }
    
}
