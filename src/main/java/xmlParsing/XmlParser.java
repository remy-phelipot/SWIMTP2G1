/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package xmlParsing;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import xmlModel.XmlParameters;

/**
 *
 * @author Guillaume
 */
public class XmlParser {
    
    public static XmlParameters parseConfiguration(String filePath) throws JAXBException, SAXException {
        XmlParameters params = null;
        // creating jaxb context
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlParameters.class);
        // creating unmarshaller
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        
        // verifying that the XML file respects the XSD schema
        // creating a schema factory
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI) ;
        // creating the schema object corresponding to the XSD schema
        Schema schema = sf.newSchema(new File("src/main/resources/xmlFiles/schemaScenario.xsd")) ;
        // setting xsd schema
        unmarshaller.setSchema(schema);        
        // parsing XML file
        params = (XmlParameters) unmarshaller.unmarshal(new File(filePath));
        return params;
    }
    
    
    public static void generateConfigFile(XmlParameters params) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlParameters.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(true));
    }
}
