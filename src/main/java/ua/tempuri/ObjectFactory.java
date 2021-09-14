
package ua.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Boolean_QNAME = new QName("http://tempuri.org/", "boolean");
    private final static QName _String_QNAME = new QName("http://tempuri.org/", "string");
    private final static QName _AnyType_QNAME = new QName("http://tempuri.org/", "anyType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChangePassword }
     * 
     */
    public ChangePassword createChangePassword() {
        return new ChangePassword();
    }

    /**
     * Create an instance of {@link SignOut }
     * 
     */
    public SignOut createSignOut() {
        return new SignOut();
    }

    /**
     * Create an instance of {@link ExecuteWithTimeout }
     * 
     */
    public ExecuteWithTimeout createExecuteWithTimeout() {
        return new ExecuteWithTimeout();
    }

    /**
     * Create an instance of {@link ExecuteExResponse }
     * 
     */
    public ExecuteExResponse createExecuteExResponse() {
        return new ExecuteExResponse();
    }

    /**
     * Create an instance of {@link ExecuteEx }
     * 
     */
    public ExecuteEx createExecuteEx() {
        return new ExecuteEx();
    }

    /**
     * Create an instance of {@link Execute }
     * 
     */
    public Execute createExecute() {
        return new Execute();
    }

    /**
     * Create an instance of {@link IsAuthenticated }
     * 
     */
    public IsAuthenticated createIsAuthenticated() {
        return new IsAuthenticated();
    }

    /**
     * Create an instance of {@link SignOutResponse }
     * 
     */
    public SignOutResponse createSignOutResponse() {
        return new SignOutResponse();
    }

    /**
     * Create an instance of {@link IsAuthenticatedResponse }
     * 
     */
    public IsAuthenticatedResponse createIsAuthenticatedResponse() {
        return new IsAuthenticatedResponse();
    }

    /**
     * Create an instance of {@link UpdateSessionResponse }
     * 
     */
    public UpdateSessionResponse createUpdateSessionResponse() {
        return new UpdateSessionResponse();
    }

    /**
     * Create an instance of {@link LoginByGoogleIdResponse }
     * 
     */
    public LoginByGoogleIdResponse createLoginByGoogleIdResponse() {
        return new LoginByGoogleIdResponse();
    }

    /**
     * Create an instance of {@link ExecuteWithTimeoutResponse }
     * 
     */
    public ExecuteWithTimeoutResponse createExecuteWithTimeoutResponse() {
        return new ExecuteWithTimeoutResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link LoginExResponse }
     * 
     */
    public LoginExResponse createLoginExResponse() {
        return new LoginExResponse();
    }

    /**
     * Create an instance of {@link IsEnabled }
     * 
     */
    public IsEnabled createIsEnabled() {
        return new IsEnabled();
    }

    /**
     * Create an instance of {@link LoginByCookies }
     * 
     */
    public LoginByCookies createLoginByCookies() {
        return new LoginByCookies();
    }

    /**
     * Create an instance of {@link UpdateSession }
     * 
     */
    public UpdateSession createUpdateSession() {
        return new UpdateSession();
    }

    /**
     * Create an instance of {@link LoginByGoogleId }
     * 
     */
    public LoginByGoogleId createLoginByGoogleId() {
        return new LoginByGoogleId();
    }

    /**
     * Create an instance of {@link ExecuteResponse }
     * 
     */
    public ExecuteResponse createExecuteResponse() {
        return new ExecuteResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link IsEnabledResponse }
     * 
     */
    public IsEnabledResponse createIsEnabledResponse() {
        return new IsEnabledResponse();
    }

    /**
     * Create an instance of {@link ChangePasswordResponse }
     * 
     */
    public ChangePasswordResponse createChangePasswordResponse() {
        return new ChangePasswordResponse();
    }

    /**
     * Create an instance of {@link LoginEx }
     * 
     */
    public LoginEx createLoginEx() {
        return new LoginEx();
    }

    /**
     * Create an instance of {@link LoginByCookiesResponse }
     * 
     */
    public LoginByCookiesResponse createLoginByCookiesResponse() {
        return new LoginByCookiesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null, value);
    }

}
