//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2014.12.31 à 05:56:03 PM CET 
//


package xmlModel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour xmlParameters complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="xmlParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consumers" type="{}xmlConsumers" minOccurs="0"/>
 *         &lt;element name="providers" type="{}xmlProviders" minOccurs="0"/>
 *         &lt;element name="links" type="{}xmlLink" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xmlParameters", propOrder = {
    "name",
    "description",
    "consumers",
    "providers",
    "links"
})
public class XmlParameters {

    protected String name;
    protected String description;
    protected XmlConsumers consumers;
    protected XmlProviders providers;
    protected List<XmlLink> links;

    /**
     * Obtient la valeur de la propriété name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriété description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la valeur de la propriété description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtient la valeur de la propriété consumers.
     * 
     * @return
     *     possible object is
     *     {@link XmlConsumers }
     *     
     */
    public XmlConsumers getConsumers() {
        return consumers;
    }

    /**
     * Définit la valeur de la propriété consumers.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlConsumers }
     *     
     */
    public void setConsumers(XmlConsumers value) {
        this.consumers = value;
    }

    /**
     * Obtient la valeur de la propriété providers.
     * 
     * @return
     *     possible object is
     *     {@link XmlProviders }
     *     
     */
    public XmlProviders getProviders() {
        return providers;
    }

    /**
     * Définit la valeur de la propriété providers.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlProviders }
     *     
     */
    public void setProviders(XmlProviders value) {
        this.providers = value;
    }

    /**
     * Gets the value of the links property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the links property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlLink }
     * 
     * 
     */
    public List<XmlLink> getLinks() {
        if (links == null) {
            links = new ArrayList<XmlLink>();
        }
        return this.links;
    }

}
