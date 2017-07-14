
package servicios;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servicios package. 
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

    private final static QName _ResolucionesResponse_QNAME = new QName("http://Servicios/", "ResolucionesResponse");
    private final static QName _SuspencionesLicencias_QNAME = new QName("http://Servicios/", "SuspencionesLicencias");
    private final static QName _ComparendosResponse_QNAME = new QName("http://Servicios/", "ComparendosResponse");
    private final static QName _AcuerdosPagos_QNAME = new QName("http://Servicios/", "AcuerdosPagos");
    private final static QName _AcuerdosPagosResponse_QNAME = new QName("http://Servicios/", "AcuerdosPagosResponse");
    private final static QName _Comparendos_QNAME = new QName("http://Servicios/", "Comparendos");
    private final static QName _Exception_QNAME = new QName("http://Servicios/", "Exception");
    private final static QName _SuspencionesLicenciasResponse_QNAME = new QName("http://Servicios/", "SuspencionesLicenciasResponse");
    private final static QName _Resoluciones_QNAME = new QName("http://Servicios/", "Resoluciones");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servicios
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Resoluciones }
     * 
     */
    public Resoluciones createResoluciones() {
        return new Resoluciones();
    }

    /**
     * Create an instance of {@link SuspencionesLicenciasResponse }
     * 
     */
    public SuspencionesLicenciasResponse createSuspencionesLicenciasResponse() {
        return new SuspencionesLicenciasResponse();
    }

    /**
     * Create an instance of {@link ComparendosResponse }
     * 
     */
    public ComparendosResponse createComparendosResponse() {
        return new ComparendosResponse();
    }

    /**
     * Create an instance of {@link AcuerdosPagos }
     * 
     */
    public AcuerdosPagos createAcuerdosPagos() {
        return new AcuerdosPagos();
    }

    /**
     * Create an instance of {@link AcuerdosPagosResponse }
     * 
     */
    public AcuerdosPagosResponse createAcuerdosPagosResponse() {
        return new AcuerdosPagosResponse();
    }

    /**
     * Create an instance of {@link ResolucionesResponse }
     * 
     */
    public ResolucionesResponse createResolucionesResponse() {
        return new ResolucionesResponse();
    }

    /**
     * Create an instance of {@link SuspencionesLicencias }
     * 
     */
    public SuspencionesLicencias createSuspencionesLicencias() {
        return new SuspencionesLicencias();
    }

    /**
     * Create an instance of {@link Comparendos }
     * 
     */
    public Comparendos createComparendos() {
        return new Comparendos();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link ClsDatosComparendos }
     * 
     */
    public ClsDatosComparendos createClsDatosComparendos() {
        return new ClsDatosComparendos();
    }

    /**
     * Create an instance of {@link ClsSalidaComparendos }
     * 
     */
    public ClsSalidaComparendos createClsSalidaComparendos() {
        return new ClsSalidaComparendos();
    }

    /**
     * Create an instance of {@link ClsDatosResoluciones }
     * 
     */
    public ClsDatosResoluciones createClsDatosResoluciones() {
        return new ClsDatosResoluciones();
    }

    /**
     * Create an instance of {@link ClsDatosAcuerdosPagos }
     * 
     */
    public ClsDatosAcuerdosPagos createClsDatosAcuerdosPagos() {
        return new ClsDatosAcuerdosPagos();
    }

    /**
     * Create an instance of {@link ClsSalidaResoluciones }
     * 
     */
    public ClsSalidaResoluciones createClsSalidaResoluciones() {
        return new ClsSalidaResoluciones();
    }

    /**
     * Create an instance of {@link ClsSalidaAcuerdosPagos }
     * 
     */
    public ClsSalidaAcuerdosPagos createClsSalidaAcuerdosPagos() {
        return new ClsSalidaAcuerdosPagos();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResolucionesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servicios/", name = "ResolucionesResponse")
    public JAXBElement<ResolucionesResponse> createResolucionesResponse(ResolucionesResponse value) {
        return new JAXBElement<ResolucionesResponse>(_ResolucionesResponse_QNAME, ResolucionesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SuspencionesLicencias }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servicios/", name = "SuspencionesLicencias")
    public JAXBElement<SuspencionesLicencias> createSuspencionesLicencias(SuspencionesLicencias value) {
        return new JAXBElement<SuspencionesLicencias>(_SuspencionesLicencias_QNAME, SuspencionesLicencias.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComparendosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servicios/", name = "ComparendosResponse")
    public JAXBElement<ComparendosResponse> createComparendosResponse(ComparendosResponse value) {
        return new JAXBElement<ComparendosResponse>(_ComparendosResponse_QNAME, ComparendosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcuerdosPagos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servicios/", name = "AcuerdosPagos")
    public JAXBElement<AcuerdosPagos> createAcuerdosPagos(AcuerdosPagos value) {
        return new JAXBElement<AcuerdosPagos>(_AcuerdosPagos_QNAME, AcuerdosPagos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcuerdosPagosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servicios/", name = "AcuerdosPagosResponse")
    public JAXBElement<AcuerdosPagosResponse> createAcuerdosPagosResponse(AcuerdosPagosResponse value) {
        return new JAXBElement<AcuerdosPagosResponse>(_AcuerdosPagosResponse_QNAME, AcuerdosPagosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Comparendos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servicios/", name = "Comparendos")
    public JAXBElement<Comparendos> createComparendos(Comparendos value) {
        return new JAXBElement<Comparendos>(_Comparendos_QNAME, Comparendos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servicios/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SuspencionesLicenciasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servicios/", name = "SuspencionesLicenciasResponse")
    public JAXBElement<SuspencionesLicenciasResponse> createSuspencionesLicenciasResponse(SuspencionesLicenciasResponse value) {
        return new JAXBElement<SuspencionesLicenciasResponse>(_SuspencionesLicenciasResponse_QNAME, SuspencionesLicenciasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Resoluciones }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servicios/", name = "Resoluciones")
    public JAXBElement<Resoluciones> createResoluciones(Resoluciones value) {
        return new JAXBElement<Resoluciones>(_Resoluciones_QNAME, Resoluciones.class, null, value);
    }

}
