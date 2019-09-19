
package service.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for article complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="article">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="categorie" type="{http://business.service/}categorie" minOccurs="0"/>
 *         &lt;element name="designation" type="{http://business.service/}designation" minOccurs="0"/>
 *         &lt;element name="marque" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quantite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ref" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taille" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "article", propOrder = {
    "categorie",
    "designation",
    "marque",
    "prix",
    "quantite",
    "ref",
    "taille"
})
public class Article {

    protected Categorie categorie;
    protected Designation designation;
    protected String marque;
    protected String prix;
    protected String quantite;
    protected String ref;
    protected String taille;

    /**
     * Gets the value of the categorie property.
     * 
     * @return
     *     possible object is
     *     {@link Categorie }
     *     
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * Sets the value of the categorie property.
     * 
     * @param value
     *     allowed object is
     *     {@link Categorie }
     *     
     */
    public void setCategorie(Categorie value) {
        this.categorie = value;
    }

    /**
     * Gets the value of the designation property.
     * 
     * @return
     *     possible object is
     *     {@link Designation }
     *     
     */
    public Designation getDesignation() {
        return designation;
    }

    /**
     * Sets the value of the designation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Designation }
     *     
     */
    public void setDesignation(Designation value) {
        this.designation = value;
    }

    /**
     * Gets the value of the marque property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarque() {
        return marque;
    }

    /**
     * Sets the value of the marque property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarque(String value) {
        this.marque = value;
    }

    /**
     * Gets the value of the prix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrix() {
        return prix;
    }

    /**
     * Sets the value of the prix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrix(String value) {
        this.prix = value;
    }

    /**
     * Gets the value of the quantite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuantite() {
        return quantite;
    }

    /**
     * Sets the value of the quantite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuantite(String value) {
        this.quantite = value;
    }

    /**
     * Gets the value of the ref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRef(String value) {
        this.ref = value;
    }

    /**
     * Gets the value of the taille property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaille() {
        return taille;
    }

    /**
     * Sets the value of the taille property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaille(String value) {
        this.taille = value;
    }

}
