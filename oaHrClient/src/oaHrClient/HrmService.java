
package oaHrClient;

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
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HrmService", targetNamespace = "http://localhost/services/HrmService", wsdlLocation = "http://kyoa.kpc.com.cn/services/HrmService?wsdl")
public class HrmService
    extends Service
{

    private final static URL HRMSERVICE_WSDL_LOCATION;
    private final static WebServiceException HRMSERVICE_EXCEPTION;
    private final static QName HRMSERVICE_QNAME = new QName("http://localhost/services/HrmService", "HrmService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://kyoa.kpc.com.cn/services/HrmService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HRMSERVICE_WSDL_LOCATION = url;
        HRMSERVICE_EXCEPTION = e;
    }

    public HrmService() {
        super(__getWsdlLocation(), HRMSERVICE_QNAME);
    }

    public HrmService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HRMSERVICE_QNAME, features);
    }

    public HrmService(URL wsdlLocation) {
        super(wsdlLocation, HRMSERVICE_QNAME);
    }

    public HrmService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HRMSERVICE_QNAME, features);
    }

    public HrmService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HrmService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HrmServicePortType
     */
    @WebEndpoint(name = "HrmServiceHttpPort")
    public HrmServicePortType getHrmServiceHttpPort() {
        return super.getPort(new QName("http://localhost/services/HrmService", "HrmServiceHttpPort"), HrmServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HrmServicePortType
     */
    @WebEndpoint(name = "HrmServiceHttpPort")
    public HrmServicePortType getHrmServiceHttpPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://localhost/services/HrmService", "HrmServiceHttpPort"), HrmServicePortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HRMSERVICE_EXCEPTION!= null) {
            throw HRMSERVICE_EXCEPTION;
        }
        return HRMSERVICE_WSDL_LOCATION;
    }

}
