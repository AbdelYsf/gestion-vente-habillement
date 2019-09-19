
package service.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for categorie complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="categorie">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_categ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nom_categ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type_categ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "categorie", propOrder = {
    "idCateg",
    "nomCateg",
    "sex",
    "typeCateg"
})
public class Categorie {

    @XmlElement(name = "id_categ")
    protected String idCateg;
    @XmlElement(name = "nom_categ")
    protected String nomCateg;
    protected String sex;
    @XmlElement(name = "type_categ")
    protected String typeCateg;

    /**
     * Gets the value of the idCateg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCateg() {
        return idCateg;
    }

    /**
     * Sets the value of the idCateg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCateg(String value) {
        this.idCateg = value;
    }

    /**
     * Gets the value of the nomCateg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomCateg() {
        return nomCateg;
    }

    /**
     * Sets the value of the nomCateg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomCateg(String value) {
        this.nomCateg = value;
    }

    /**
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSex(String value) {
        this.sex = value;
    }

    /**
     * Gets the value of the typeCateg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeCateg() {
        return typeCateg;
    }

    /**
     * Sets the value of the typeCateg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeCateg(String value) {
        this.typeCateg = value;
    }

}
