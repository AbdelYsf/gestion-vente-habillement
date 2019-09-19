
package service.business;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for credit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="credit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date_expiration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="etat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idCredit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="montantPaye" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="montantReste" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="montant_credit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="versement" type="{http://business.service/}versement" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "credit", propOrder = {
    "dateExpiration",
    "etat",
    "idCredit",
    "montantPaye",
    "montantReste",
    "montantCredit",
    "versement"
})
public class Credit {

    @XmlElement(name = "date_expiration")
    protected String dateExpiration;
    protected String etat;
    protected int idCredit;
    protected double montantPaye;
    protected double montantReste;
    @XmlElement(name = "montant_credit")
    protected double montantCredit;
    @XmlElement(nillable = true)
    protected List<Versement> versement;

    /**
     * Gets the value of the dateExpiration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateExpiration() {
        return dateExpiration;
    }

    /**
     * Sets the value of the dateExpiration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateExpiration(String value) {
        this.dateExpiration = value;
    }

    /**
     * Gets the value of the etat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtat() {
        return etat;
    }

    /**
     * Sets the value of the etat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtat(String value) {
        this.etat = value;
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
     * Gets the value of the montantPaye property.
     * 
     */
    public double getMontantPaye() {
        return montantPaye;
    }

    /**
     * Sets the value of the montantPaye property.
     * 
     */
    public void setMontantPaye(double value) {
        this.montantPaye = value;
    }

    /**
     * Gets the value of the montantReste property.
     * 
     */
    public double getMontantReste() {
        return montantReste;
    }

    /**
     * Sets the value of the montantReste property.
     * 
     */
    public void setMontantReste(double value) {
        this.montantReste = value;
    }

    /**
     * Gets the value of the montantCredit property.
     * 
     */
    public double getMontantCredit() {
        return montantCredit;
    }

    /**
     * Sets the value of the montantCredit property.
     * 
     */
    public void setMontantCredit(double value) {
        this.montantCredit = value;
    }

    /**
     * Gets the value of the versement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the versement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVersement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Versement }
     * 
     * 
     */
    public List<Versement> getVersement() {
        if (versement == null) {
            versement = new ArrayList<Versement>();
        }
        return this.versement;
    }

}
