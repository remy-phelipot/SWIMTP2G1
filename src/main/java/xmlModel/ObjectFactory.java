//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2014.12.31 à 06:30:05 PM CET 
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

    private final static QName _Sequence_QNAME = new QName("", "sequence");
    private final static QName _Param_QNAME = new QName("", "param");
    private final static QName _Provider_QNAME = new QName("", "provider");
    private final static QName _Link_QNAME = new QName("", "link");
    private final static QName _Links_QNAME = new QName("", "links");
    private final static QName _Consumers_QNAME = new QName("", "consumers");
    private final static QName _Consumer_QNAME = new QName("", "consumer");
    private final static QName _Providers_QNAME = new QName("", "providers");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xmlModel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link XmlSequence }
     * 
     */
    public XmlSequence createXmlSequence() {
        return new XmlSequence();
    }

    /**
     * Create an instance of {@link XmlParameters }
     * 
     */
    public XmlParameters createXmlParameters() {
        return new XmlParameters();
    }

    /**
     * Create an instance of {@link XmlProvider }
     * 
     */
    public XmlProvider createXmlProvider() {
        return new XmlProvider();
    }

    /**
     * Create an instance of {@link XmlLink }
     * 
     */
    public XmlLink createXmlLink() {
        return new XmlLink();
    }

    /**
     * Create an instance of {@link XmlLinks }
     * 
     */
    public XmlLinks createXmlLinks() {
        return new XmlLinks();
    }

    /**
     * Create an instance of {@link XmlConsumers }
     * 
     */
    public XmlConsumers createXmlConsumers() {
        return new XmlConsumers();
    }

    /**
     * Create an instance of {@link XmlConsumer }
     * 
     */
    public XmlConsumer createXmlConsumer() {
        return new XmlConsumer();
    }

    /**
     * Create an instance of {@link XmlProviders }
     * 
     */
    public XmlProviders createXmlProviders() {
        return new XmlProviders();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XmlSequence }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sequence")
    public JAXBElement<XmlSequence> createSequence(XmlSequence value) {
        return new JAXBElement<XmlSequence>(_Sequence_QNAME, XmlSequence.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XmlParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "param")
    public JAXBElement<XmlParameters> createParam(XmlParameters value) {
        return new JAXBElement<XmlParameters>(_Param_QNAME, XmlParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XmlProvider }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "provider")
    public JAXBElement<XmlProvider> createProvider(XmlProvider value) {
        return new JAXBElement<XmlProvider>(_Provider_QNAME, XmlProvider.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XmlLink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "link")
    public JAXBElement<XmlLink> createLink(XmlLink value) {
        return new JAXBElement<XmlLink>(_Link_QNAME, XmlLink.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XmlLinks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "links")
    public JAXBElement<XmlLinks> createLinks(XmlLinks value) {
        return new JAXBElement<XmlLinks>(_Links_QNAME, XmlLinks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XmlConsumers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "consumers")
    public JAXBElement<XmlConsumers> createConsumers(XmlConsumers value) {
        return new JAXBElement<XmlConsumers>(_Consumers_QNAME, XmlConsumers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XmlConsumer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "consumer")
    public JAXBElement<XmlConsumer> createConsumer(XmlConsumer value) {
        return new JAXBElement<XmlConsumer>(_Consumer_QNAME, XmlConsumer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XmlProviders }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "providers")
    public JAXBElement<XmlProviders> createProviders(XmlProviders value) {
        return new JAXBElement<XmlProviders>(_Providers_QNAME, XmlProviders.class, null, value);
    }

}
