
package service.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for designation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="designation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_designation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nom_designation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sous_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "designation", propOrder = {
    "idDesignation",
    "nomDesignation",
    "sousType"
})
public class Designation {

    @XmlElement(name = "id_designation")
    protected String idDesignation;
    @XmlElement(name = "nom_designation")
    protected String nomDesignation;
    @XmlElement(name = "sous_Type")
    protected String sousType;

    /**
     * Gets the value of the idDesignation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDesignation() {
        return idDesignation;
    }

    /**
     * Sets the value of the idDesignation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDesignation(String value) {
        this.idDesignation = value;
    }

    /**
     * Gets the value of the nomDesignation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomDesignation() {
        return nomDesignation;
    }

    /**
     * Sets the value of the nomDesignation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomDesignation(String value) {
        this.nomDesignation = value;
    }

    /**
     * Gets the value of the sousType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSousType() {
        return sousType;
    }

    /**
     * Sets the value of the sousType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSousType(String value) {
        this.sousType = value;
    }

}
