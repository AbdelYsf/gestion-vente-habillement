
package service.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for vente complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vente">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="article" type="{http://business.service/}article" minOccurs="0"/>
 *         &lt;element name="client" type="{http://business.service/}client" minOccurs="0"/>
 *         &lt;element name="credit" type="{http://business.service/}credit" minOccurs="0"/>
 *         &lt;element name="date_vente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_vente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mantant" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="mode_payement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quantite" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type_operation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vente", propOrder = {
    "article",
    "client",
    "credit",
    "dateVente",
    "idVente",
    "mantant",
    "modePayement",
    "quantite",
    "typeOperation"
})
public class Vente {

    protected Article article;
    protected Client client;
    protected Credit credit;
    @XmlElement(name = "date_vente")
    protected String dateVente;
    @XmlElement(name = "id_vente")
    protected int idVente;
    protected double mantant;
    @XmlElement(name = "mode_payement")
    protected String modePayement;
    protected int quantite;
    @XmlElement(name = "type_operation")
    protected String typeOperation;

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
     * Gets the value of the client property.
     * 
     * @return
     *     possible object is
     *     {@link Client }
     *     
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets the value of the client property.
     * 
     * @param value
     *     allowed object is
     *     {@link Client }
     *     
     */
    public void setClient(Client value) {
        this.client = value;
    }

    /**
     * Gets the value of the credit property.
     * 
     * @return
     *     possible object is
     *     {@link Credit }
     *     
     */
    public Credit getCredit() {
        return credit;
    }

    /**
     * Sets the value of the credit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Credit }
     *     
     */
    public void setCredit(Credit value) {
        this.credit = value;
    }

    /**
     * Gets the value of the dateVente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateVente() {
        return dateVente;
    }

    /**
     * Sets the value of the dateVente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateVente(String value) {
        this.dateVente = value;
    }

    /**
     * Gets the value of the idVente property.
     * 
     */
    public int getIdVente() {
        return idVente;
    }

    /**
     * Sets the value of the idVente property.
     * 
     */
    public void setIdVente(int value) {
        this.idVente = value;
    }

    /**
     * Gets the value of the mantant property.
     * 
     */
    public double getMantant() {
        return mantant;
    }

    /**
     * Sets the value of the mantant property.
     * 
     */
    public void setMantant(double value) {
        this.mantant = value;
    }

    /**
     * Gets the value of the modePayement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModePayement() {
        return modePayement;
    }

    /**
     * Sets the value of the modePayement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModePayement(String value) {
        this.modePayement = value;
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

    /**
     * Gets the value of the typeOperation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeOperation() {
        return typeOperation;
    }

    /**
     * Sets the value of the typeOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeOperation(String value) {
        this.typeOperation = value;
    }

}
