
package service.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statistics complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="statistics">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="article" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="categorie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mois" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nbrVente" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "statistics", propOrder = {
    "article",
    "categorie",
    "mois",
    "nbrVente",
    "taille"
})
public class Statistics {

    protected String article;
    protected String categorie;
    protected String mois;
    protected int nbrVente;
    protected String taille;

    /**
     * Gets the value of the article property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticle() {
        return article;
    }

    /**
     * Sets the value of the article property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticle(String value) {
        this.article = value;
    }

    /**
     * Gets the value of the categorie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategorie() {
        return categorie;
    }

    /**
     * Sets the value of the categorie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategorie(String value) {
        this.categorie = value;
    }

    /**
     * Gets the value of the mois property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMois() {
        return mois;
    }

    /**
     * Sets the value of the mois property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMois(String value) {
        this.mois = value;
    }

    /**
     * Gets the value of the nbrVente property.
     * 
     */
    public int getNbrVente() {
        return nbrVente;
    }

    /**
     * Sets the value of the nbrVente property.
     * 
     */
    public void setNbrVente(int value) {
        this.nbrVente = value;
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
