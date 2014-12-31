//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2014.12.31 � 05:45:05 PM CET 
//


package xmlModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour xmlSequence complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="xmlSequence">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="processing_time_provider" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="data_size" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nbr_req_per_sec_consumer" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *       &lt;attribute name="begin" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="end" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xmlSequence", propOrder = {
    "processingTimeProvider",
    "dataSize",
    "nbrReqPerSecConsumer"
})
public class XmlSequence {

    @XmlElement(name = "processing_time_provider")
    protected float processingTimeProvider;
    @XmlElement(name = "data_size")
    protected int dataSize;
    @XmlElement(name = "nbr_req_per_sec_consumer")
    protected int nbrReqPerSecConsumer;
    @XmlAttribute(name = "begin", required = true)
    protected float begin;
    @XmlAttribute(name = "end", required = true)
    protected float end;

    /**
     * Obtient la valeur de la propri�t� processingTimeProvider.
     * 
     */
    public float getProcessingTimeProvider() {
        return processingTimeProvider;
    }

    /**
     * D�finit la valeur de la propri�t� processingTimeProvider.
     * 
     */
    public void setProcessingTimeProvider(float value) {
        this.processingTimeProvider = value;
    }

    /**
     * Obtient la valeur de la propri�t� dataSize.
     * 
     */
    public int getDataSize() {
        return dataSize;
    }

    /**
     * D�finit la valeur de la propri�t� dataSize.
     * 
     */
    public void setDataSize(int value) {
        this.dataSize = value;
    }

    /**
     * Obtient la valeur de la propri�t� nbrReqPerSecConsumer.
     * 
     */
    public int getNbrReqPerSecConsumer() {
        return nbrReqPerSecConsumer;
    }

    /**
     * D�finit la valeur de la propri�t� nbrReqPerSecConsumer.
     * 
     */
    public void setNbrReqPerSecConsumer(int value) {
        this.nbrReqPerSecConsumer = value;
    }

    /**
     * Obtient la valeur de la propri�t� begin.
     * 
     */
    public float getBegin() {
        return begin;
    }

    /**
     * D�finit la valeur de la propri�t� begin.
     * 
     */
    public void setBegin(float value) {
        this.begin = value;
    }

    /**
     * Obtient la valeur de la propri�t� end.
     * 
     */
    public float getEnd() {
        return end;
    }

    /**
     * D�finit la valeur de la propri�t� end.
     * 
     */
    public void setEnd(float value) {
        this.end = value;
    }

}
