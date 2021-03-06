
package ua.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WebServiceSoap", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebServiceSoap {


    /**
     * 
     * @param password
     * @param login
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Login", action = "http://tempuri.org/Login")
    @WebResult(name = "LoginResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Login", targetNamespace = "http://tempuri.org/", className = "org.tempuri.Login")
    @ResponseWrapper(localName = "LoginResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.LoginResponse")
    public String login(
        @WebParam(name = "login", targetNamespace = "http://tempuri.org/")
        String login,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        String password);

    /**
     * 
     * @param password
     * @param login
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "LoginEx", action = "http://tempuri.org/LoginEx")
    @WebResult(name = "LoginExResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "LoginEx", targetNamespace = "http://tempuri.org/", className = "org.tempuri.LoginEx")
    @ResponseWrapper(localName = "LoginExResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.LoginExResponse")
    public String loginEx(
        @WebParam(name = "login", targetNamespace = "http://tempuri.org/")
        String login,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        String password);

    /**
     * 
     * @param value
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "LoginByCookies", action = "http://tempuri.org/LoginByCookies")
    @WebResult(name = "LoginByCookiesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "LoginByCookies", targetNamespace = "http://tempuri.org/", className = "org.tempuri.LoginByCookies")
    @ResponseWrapper(localName = "LoginByCookiesResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.LoginByCookiesResponse")
    public String loginByCookies(
        @WebParam(name = "value", targetNamespace = "http://tempuri.org/")
        String value);

    /**
     * 
     */
    @WebMethod(operationName = "SignOut", action = "http://tempuri.org/SignOut")
    @RequestWrapper(localName = "SignOut", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SignOut")
    @ResponseWrapper(localName = "SignOutResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SignOutResponse")
    public void signOut();

    /**
     * 
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "IsAuthenticated", action = "http://tempuri.org/IsAuthenticated")
    @WebResult(name = "IsAuthenticatedResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "IsAuthenticated", targetNamespace = "http://tempuri.org/", className = "org.tempuri.IsAuthenticated")
    @ResponseWrapper(localName = "IsAuthenticatedResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.IsAuthenticatedResponse")
    public boolean isAuthenticated();

    /**
     * 
     * @param token
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "LoginByGoogleId", action = "http://tempuri.org/LoginByGoogleId")
    @WebResult(name = "LoginByGoogleIdResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "LoginByGoogleId", targetNamespace = "http://tempuri.org/", className = "org.tempuri.LoginByGoogleId")
    @ResponseWrapper(localName = "LoginByGoogleIdResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.LoginByGoogleIdResponse")
    public String loginByGoogleId(
        @WebParam(name = "token", targetNamespace = "http://tempuri.org/")
        String token);

    /**
     * 
     * @param args
     * @param calcId
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Execute", action = "http://tempuri.org/Execute")
    @WebResult(name = "ExecuteResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Execute", targetNamespace = "http://tempuri.org/", className = "org.tempuri.Execute")
    @ResponseWrapper(localName = "ExecuteResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ExecuteResponse")
    public String execute(
        @WebParam(name = "calcId", targetNamespace = "http://tempuri.org/")
        String calcId,
        @WebParam(name = "args", targetNamespace = "http://tempuri.org/")
        String args);

    /**
     * 
     * @param args
     * @param ticket
     * @param calcId
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "ExecuteEx", action = "http://tempuri.org/ExecuteEx")
    @WebResult(name = "ExecuteExResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ExecuteEx", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ExecuteEx")
    @ResponseWrapper(localName = "ExecuteExResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ExecuteExResponse")
    public String executeEx(
        @WebParam(name = "calcId", targetNamespace = "http://tempuri.org/")
        String calcId,
        @WebParam(name = "args", targetNamespace = "http://tempuri.org/")
        String args,
        @WebParam(name = "ticket", targetNamespace = "http://tempuri.org/")
        String ticket);

    /**
     * 
     * @param args
     * @param ticket
     * @param calcId
     * @param timeout
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "ExecuteWithTimeout", action = "http://tempuri.org/ExecuteWithTimeout")
    @WebResult(name = "ExecuteWithTimeoutResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ExecuteWithTimeout", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ExecuteWithTimeout")
    @ResponseWrapper(localName = "ExecuteWithTimeoutResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ExecuteWithTimeoutResponse")
    public String executeWithTimeout(
        @WebParam(name = "calcId", targetNamespace = "http://tempuri.org/")
        String calcId,
        @WebParam(name = "args", targetNamespace = "http://tempuri.org/")
        String args,
        @WebParam(name = "ticket", targetNamespace = "http://tempuri.org/")
        String ticket,
        @WebParam(name = "timeout", targetNamespace = "http://tempuri.org/")
        int timeout);

    /**
     * 
     * @param ticket
     * @param sessionId
     */
    @WebMethod(operationName = "UpdateSession", action = "http://tempuri.org/UpdateSession")
    @RequestWrapper(localName = "UpdateSession", targetNamespace = "http://tempuri.org/", className = "org.tempuri.UpdateSession")
    @ResponseWrapper(localName = "UpdateSessionResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.UpdateSessionResponse")
    public void updateSession(
        @WebParam(name = "ticket", targetNamespace = "http://tempuri.org/")
        String ticket,
        @WebParam(name = "sessionId", targetNamespace = "http://tempuri.org/")
        String sessionId);

    /**
     * 
     * @param ticket
     * @param oldPassword
     * @param newPassword
     * @param login
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "ChangePassword", action = "http://tempuri.org/ChangePassword")
    @WebResult(name = "ChangePasswordResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ChangePassword", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ChangePassword")
    @ResponseWrapper(localName = "ChangePasswordResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ChangePasswordResponse")
    public String changePassword(
        @WebParam(name = "login", targetNamespace = "http://tempuri.org/")
        String login,
        @WebParam(name = "oldPassword", targetNamespace = "http://tempuri.org/")
        String oldPassword,
        @WebParam(name = "newPassword", targetNamespace = "http://tempuri.org/")
        String newPassword,
        @WebParam(name = "ticket", targetNamespace = "http://tempuri.org/")
        String ticket);

    /**
     * 
     * @return
     *     returns java.lang.Object
     */
    @WebMethod(operationName = "IsEnabled", action = "http://tempuri.org/IsEnabled")
    @WebResult(name = "IsEnabledResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "IsEnabled", targetNamespace = "http://tempuri.org/", className = "org.tempuri.IsEnabled")
    @ResponseWrapper(localName = "IsEnabledResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.IsEnabledResponse")
    public Object isEnabled();

}
