//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.01.03 à 01:07:56 PM CET 
//


package xmlModel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xmlModel package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Params_QNAME = new QName("", "params");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xmlModel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link XmlParameters }
     * 
     */
    public XmlParameters createXmlParameters() {
        return new XmlParameters();
    }

    /**
     * Create an instance of {@link XmlLinks }
     * 
     */
    public XmlLinks createXmlLinks() {
        return new XmlLinks();
    }

    /**
     * Create an instance of {@link XmlLink }
     * 
     */
    public XmlLink createXmlLink() {
        return new XmlLink();
    }

    /**
     * Create an instance of {@link XmlConsumer }
     * 
     */
    public XmlConsumer createXmlConsumer() {
        return new XmlConsumer();
    }

    /**
     * Create an instance of {@link XmlSequence }
     * 
     */
    public XmlSequence createXmlSequence() {
        return new XmlSequence();
    }

    /**
     * Create an instance of {@link XmlProviders }
     * 
     */
    public XmlProviders createXmlProviders() {
        return new XmlProviders();
    }

    /**
     * Create an instance of {@link XmlConsumers }
     * 
     */
    public XmlConsumers createXmlConsumers() {
        return new XmlConsumers();
    }

    /**
     * Create an instance of {@link XmlProvider }
     * 
     */
    public XmlProvider createXmlProvider() {
        return new XmlProvider();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XmlParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "params")
    public JAXBElement<XmlParameters> createParams(XmlParameters value) {
        return new JAXBElement<XmlParameters>(_Params_QNAME, XmlParameters.class, null, value);
    }

}
