
package service.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for achat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="achat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="article" type="{http://business.service/}article" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fournisseur" type="{http://business.service/}fournisseur" minOccurs="0"/>
 *         &lt;element name="id_achat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="quantite" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "achat", propOrder = {
    "article",
    "date",
    "fournisseur",
    "idAchat",
    "quantite"
})
public class Achat {

    protected Article article;
    protected String date;
    protected Fournisseur fournisseur;
    @XmlElement(name = "id_achat")
    protected int idAchat;
    protected int quantite;

    /**
     * Gets the value of the article property.
     * 
     * @return
     *     possible object is
     *     {@link Article }
     *     
     */
    public Article getArticle() {
        return article;
    }

    /**
     * Sets the value of the article property.
     * 
     * @param value
     *     allowed object is
     *     {@link Article }
     *     
     */
    public void setArticle(Article value) {
        this.article = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the fournisseur property.
     * 
     * @return
     *     possible object is
     *     {@link Fournisseur }
     *     
     */
    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    /**
     * Sets the value of the fournisseur property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fournisseur }
     *     
     */
    public void setFournisseur(Fournisseur value) {
        this.fournisseur = value;
    }

    /**
     * Gets the value of the idAchat property.
     * 
     */
    public int getIdAchat() {
        return idAchat;
    }

    /**
     * Sets the value of the idAchat property.
     * 
     */
    public void setIdAchat(int value) {
        this.idAchat = value;
    }

    /**
     * Gets the value of the quantite property.
     * 
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Sets the value of the quantite property.
     * 
     */
    public void setQuantite(int value) {
        this.quantite = value;
    }

}
