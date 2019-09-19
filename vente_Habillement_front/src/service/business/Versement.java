
package service.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for versement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="versement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date_versement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_credit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_versement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mantant_versement" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "versement", propOrder = {
    "dateVersement",
    "idCredit",
    "idVersement",
    "mantantVersement"
})
public class Versement {

    @XmlElement(name = "date_versement")
    protected String dateVersement;
    @XmlElement(name = "id_credit")
    protected int idCredit;
    @XmlElement(name = "id_versement")
    protected String idVersement;
    @XmlElement(name = "mantant_versement")
    protected double mantantVersement;

    /**
     * Gets the value of the dateVersement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateVersement() {
        return dateVersement;
    }

    /**
     * Sets the value of the dateVersement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateVersement(String value) {
        this.dateVersement = value;
    }

    /**
     * Gets the value of the idCredit property.
     * 
     */
    public int getIdCredit() {
        return idCredit;
    }

    /**
     * Sets the value of the idCredit property.
     * 
     */
    public void setIdCredit(int value) {
        this.idCredit = value;
    }

    /**
     * Gets the value of the idVersement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdVersement() {
        return idVersement;
    }

    /**
     * Sets the value of the idVersement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdVersement(String value) {
        this.idVersement = value;
    }

    /**
     * Gets the value of the mantantVersement property.
     * 
     */
    public double getMantantVersement() {
        return mantantVersement;
    }

    /**
     * Sets the value of the mantantVersement property.
     * 
     */
    public void setMantantVersement(double value) {
        this.mantantVersement = value;
    }

}
