
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
 *         &lt;element name="LoginByCookiesResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "loginByCookiesResult"
})
@XmlRootElement(name = "LoginByCookiesResponse")
public class LoginByCookiesResponse {

    @XmlElement(name = "LoginByCookiesResult")
    protected String loginByCookiesResult;

    /**
     * Gets the value of the loginByCookiesResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginByCookiesResult() {
        return loginByCookiesResult;
    }

    /**
     * Sets the value of the loginByCookiesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginByCookiesResult(String value) {
        this.loginByCookiesResult = value;
    }

}
