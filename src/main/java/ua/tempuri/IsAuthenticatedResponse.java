
package ua.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IsAuthenticatedResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "isAuthenticatedResult"
})
@XmlRootElement(name = "IsAuthenticatedResponse")
public class IsAuthenticatedResponse {

    @XmlElement(name = "IsAuthenticatedResult")
    protected boolean isAuthenticatedResult;

    /**
     * Gets the value of the isAuthenticatedResult property.
     * 
     */
    public boolean isIsAuthenticatedResult() {
        return isAuthenticatedResult;
    }

    /**
     * Sets the value of the isAuthenticatedResult property.
     * 
     */
    public void setIsAuthenticatedResult(boolean value) {
        this.isAuthenticatedResult = value;
    }

}
