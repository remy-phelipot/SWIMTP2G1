/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlParsing;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import xmlModel.XmlParameters;

/**
 *
 * @author Guillaume
 */
public class XmlParser {

	public static XmlParameters parseConfiguration(String filePath) throws JAXBException {
		XmlParameters params = null; 
		JAXBContext jaxbContext = JAXBContext.newInstance(XmlParameters.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		params = (XmlParameters) unmarshaller.unmarshal(new File(filePath));
		return params;
	}
	
	
	public static void generateConfigFile(XmlParameters params) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(XmlParameters.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(true));		
	}
}
