//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2014.12.31 à 06:30:05 PM CET 
//


package xmlModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="links" type="{}xmlLinks" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="params")
@XmlType(name = "xmlParams", propOrder = {
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
    protected XmlLinks links;

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
     * Obtient la valeur de la propriété links.
     * 
     * @return
     *     possible object is
     *     {@link XmlLinks }
     *     
     */
    public XmlLinks getLinks() {
        return links;
    }

    /**
     * Définit la valeur de la propriété links.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlLinks }
     *     
     */
    public void setLinks(XmlLinks value) {
        this.links = value;
    }

}
