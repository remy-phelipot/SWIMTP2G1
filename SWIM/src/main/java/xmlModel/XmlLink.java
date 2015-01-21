//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.01.05 à 02:53:14 PM CET 
//


package xmlModel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour xmlLink complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="xmlLink">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="consumer" type="{}xmlConsumer" minOccurs="0"/>
 *         &lt;element name="provider" type="{}xmlProvider" minOccurs="0"/>
 *         &lt;element name="sequences" type="{}xmlSequences" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xmlLink", propOrder = {
    "consumer",
    "provider",
    "sequences"
})
public class XmlLink {

    /**
     * field consumer
     */
    protected XmlConsumer consumer;
    /**
     * field provider
     */
    protected XmlProvider provider;
    /**
     * field sequences
     */
    @XmlElement(nillable = true)
    protected List<XmlSequences> sequences;

    /**
     * Obtient la valeur de la propriété consumer.
     * 
     * @return
     *     possible object is
     *     {@link XmlConsumer }
     *     
     */
    public XmlConsumer getConsumer() {
        return consumer;
    }

    /**
     * Définit la valeur de la propriété consumer.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlConsumer }
     *     
     */
    public void setConsumer(XmlConsumer value) {
        this.consumer = value;
    }

    /**
     * Obtient la valeur de la propriété provider.
     * 
     * @return
     *     possible object is
     *     {@link XmlProvider }
     *     
     */
    public XmlProvider getProvider() {
        return provider;
    }

    /**
     * Définit la valeur de la propriété provider.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlProvider }
     *     
     */
    public void setProvider(XmlProvider value) {
        this.provider = value;
    }

    /**
     * Gets the value of the sequences property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sequences property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSequences().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlSequences }
     * 
     * 
     */
    public List<XmlSequences> getSequences() {
        if (sequences == null) {
            sequences = new ArrayList<XmlSequences>();
        }
        return this.sequences;
    }

}
