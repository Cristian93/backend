
package servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para clsDatosComparendos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsDatosComparendos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoInfraccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionInfraccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direccionComparendo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoComparendo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaComparendo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fotodeteccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="infractorComparendo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroComparendo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="placaVehiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secretariaComparendo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="servicioVehiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoVehiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsDatosComparendos", propOrder = {
    "codigoInfraccion",
    "descripcionInfraccion",
    "direccionComparendo",
    "estadoComparendo",
    "fechaComparendo",
    "fotodeteccion",
    "infractorComparendo",
    "numeroComparendo",
    "placaVehiculo",
    "secretariaComparendo",
    "servicioVehiculo",
    "tipoVehiculo",
    "total"
})
public class ClsDatosComparendos {

    protected String codigoInfraccion;
    protected String descripcionInfraccion;
    protected String direccionComparendo;
    protected String estadoComparendo;
    protected String fechaComparendo;
    protected String fotodeteccion;
    protected String infractorComparendo;
    protected String numeroComparendo;
    protected String placaVehiculo;
    protected String secretariaComparendo;
    protected String servicioVehiculo;
    protected String tipoVehiculo;
    protected Double total;

    /**
     * Obtiene el valor de la propiedad codigoInfraccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoInfraccion() {
        return codigoInfraccion;
    }

    /**
     * Define el valor de la propiedad codigoInfraccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoInfraccion(String value) {
        this.codigoInfraccion = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionInfraccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionInfraccion() {
        return descripcionInfraccion;
    }

    /**
     * Define el valor de la propiedad descripcionInfraccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionInfraccion(String value) {
        this.descripcionInfraccion = value;
    }

    /**
     * Obtiene el valor de la propiedad direccionComparendo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccionComparendo() {
        return direccionComparendo;
    }

    /**
     * Define el valor de la propiedad direccionComparendo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccionComparendo(String value) {
        this.direccionComparendo = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoComparendo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoComparendo() {
        return estadoComparendo;
    }

    /**
     * Define el valor de la propiedad estadoComparendo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoComparendo(String value) {
        this.estadoComparendo = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaComparendo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaComparendo() {
        return fechaComparendo;
    }

    /**
     * Define el valor de la propiedad fechaComparendo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaComparendo(String value) {
        this.fechaComparendo = value;
    }

    /**
     * Obtiene el valor de la propiedad fotodeteccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFotodeteccion() {
        return fotodeteccion;
    }

    /**
     * Define el valor de la propiedad fotodeteccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFotodeteccion(String value) {
        this.fotodeteccion = value;
    }

    /**
     * Obtiene el valor de la propiedad infractorComparendo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfractorComparendo() {
        return infractorComparendo;
    }

    /**
     * Define el valor de la propiedad infractorComparendo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfractorComparendo(String value) {
        this.infractorComparendo = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroComparendo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroComparendo() {
        return numeroComparendo;
    }

    /**
     * Define el valor de la propiedad numeroComparendo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroComparendo(String value) {
        this.numeroComparendo = value;
    }

    /**
     * Obtiene el valor de la propiedad placaVehiculo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    /**
     * Define el valor de la propiedad placaVehiculo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlacaVehiculo(String value) {
        this.placaVehiculo = value;
    }

    /**
     * Obtiene el valor de la propiedad secretariaComparendo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecretariaComparendo() {
        return secretariaComparendo;
    }

    /**
     * Define el valor de la propiedad secretariaComparendo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecretariaComparendo(String value) {
        this.secretariaComparendo = value;
    }

    /**
     * Obtiene el valor de la propiedad servicioVehiculo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServicioVehiculo() {
        return servicioVehiculo;
    }

    /**
     * Define el valor de la propiedad servicioVehiculo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServicioVehiculo(String value) {
        this.servicioVehiculo = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoVehiculo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Define el valor de la propiedad tipoVehiculo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoVehiculo(String value) {
        this.tipoVehiculo = value;
    }

    /**
     * Obtiene el valor de la propiedad total.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotal() {
        return total;
    }

    /**
     * Define el valor de la propiedad total.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotal(Double value) {
        this.total = value;
    }

}
