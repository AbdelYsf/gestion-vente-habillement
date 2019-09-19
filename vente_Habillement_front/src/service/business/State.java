
package service.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for state complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="state">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chifferDAffair" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="countAchat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="countArticle" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="countClient" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="countVente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalCredi" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "state", propOrder = {
    "chifferDAffair",
    "countAchat",
    "countArticle",
    "countClient",
    "countVente",
    "totalCredi"
})
public class State {

    protected double chifferDAffair;
    protected int countAchat;
    protected int countArticle;
    protected int countClient;
    protected int countVente;
    protected double totalCredi;

    /**
     * Gets the value of the chifferDAffair property.
     * 
     */
    public double getChifferDAffair() {
        return chifferDAffair;
    }

    /**
     * Sets the value of the chifferDAffair property.
     * 
     */
    public void setChifferDAffair(double value) {
        this.chifferDAffair = value;
    }

    /**
     * Gets the value of the countAchat property.
     * 
     */
    public int getCountAchat() {
        return countAchat;
    }

    /**
     * Sets the value of the countAchat property.
     * 
     */
    public void setCountAchat(int value) {
        this.countAchat = value;
    }

    /**
     * Gets the value of the countArticle property.
     * 
     */
    public int getCountArticle() {
        return countArticle;
    }

    /**
     * Sets the value of the countArticle property.
     * 
     */
    public void setCountArticle(int value) {
        this.countArticle = value;
    }

    /**
     * Gets the value of the countClient property.
     * 
     */
    public int getCountClient() {
        return countClient;
    }

    /**
     * Sets the value of the countClient property.
     * 
     */
    public void setCountClient(int value) {
        this.countClient = value;
    }

    /**
     * Gets the value of the countVente property.
     * 
     */
    public int getCountVente() {
        return countVente;
    }

    /**
     * Sets the value of the countVente property.
     * 
     */
    public void setCountVente(int value) {
        this.countVente = value;
    }

    /**
     * Gets the value of the totalCredi property.
     * 
     */
    public double getTotalCredi() {
        return totalCredi;
    }

    /**
     * Sets the value of the totalCredi property.
     * 
     */
    public void setTotalCredi(double value) {
        this.totalCredi = value;
    }

}
