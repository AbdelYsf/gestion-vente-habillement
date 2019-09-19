
package service.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fournisseur complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fournisseur">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adresse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_fournisseur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tele" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fournisseur", propOrder = {
    "adresse",
    "idFournisseur",
    "nom",
    "tele"
})
public class Fournisseur {

    protected String adresse;
    @XmlElement(name = "id_fournisseur")
    protected String idFournisseur;
    protected String nom;
    protected String tele;

    /**
     * Gets the value of the adresse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Sets the value of the adresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresse(String value) {
        this.adresse = value;
    }

    /**
     * Gets the value of the idFournisseur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdFournisseur() {
        return idFournisseur;
    }

    /**
     * Sets the value of the idFournisseur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdFournisseur(String value) {
        this.idFournisseur = value;
    }

    /**
     * Gets the value of the nom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets the value of the nom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Gets the value of the tele property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTele() {
        return tele;
    }

    /**
     * Sets the value of the tele property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTele(String value) {
        this.tele = value;
    }

}
