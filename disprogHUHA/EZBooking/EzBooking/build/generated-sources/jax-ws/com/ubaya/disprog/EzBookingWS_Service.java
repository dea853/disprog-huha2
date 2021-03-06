
package com.ubaya.disprog;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.3
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "EzBookingWS", targetNamespace = "http://disprog.ubaya.com/", wsdlLocation = "http://localhost:8080/EzBookingWS3/EzBookingWS?wsdl")
public class EzBookingWS_Service
    extends Service
{

    private final static URL EZBOOKINGWS_WSDL_LOCATION;
    private final static WebServiceException EZBOOKINGWS_EXCEPTION;
    private final static QName EZBOOKINGWS_QNAME = new QName("http://disprog.ubaya.com/", "EzBookingWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/EzBookingWS3/EzBookingWS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        EZBOOKINGWS_WSDL_LOCATION = url;
        EZBOOKINGWS_EXCEPTION = e;
    }

    public EzBookingWS_Service() {
        super(__getWsdlLocation(), EZBOOKINGWS_QNAME);
    }

    public EzBookingWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), EZBOOKINGWS_QNAME, features);
    }

    public EzBookingWS_Service(URL wsdlLocation) {
        super(wsdlLocation, EZBOOKINGWS_QNAME);
    }

    public EzBookingWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, EZBOOKINGWS_QNAME, features);
    }

    public EzBookingWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EzBookingWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns EzBookingWS
     */
    @WebEndpoint(name = "EzBookingWSPort")
    public EzBookingWS getEzBookingWSPort() {
        return super.getPort(new QName("http://disprog.ubaya.com/", "EzBookingWSPort"), EzBookingWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {&#064;link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the &lt;code&gt;features&lt;/code&gt; parameter will have their default values.
     * @return
     *     returns EzBookingWS
     */
    @WebEndpoint(name = "EzBookingWSPort")
    public EzBookingWS getEzBookingWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://disprog.ubaya.com/", "EzBookingWSPort"), EzBookingWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (EZBOOKINGWS_EXCEPTION!= null) {
            throw EZBOOKINGWS_EXCEPTION;
        }
        return EZBOOKINGWS_WSDL_LOCATION;
    }

}
