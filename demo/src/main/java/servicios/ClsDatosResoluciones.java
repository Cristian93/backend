
package servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para clsDatosResoluciones complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsDatosResoluciones">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="apellidosInfractores" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadosResoluciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaComparendo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaResolucion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDSecretarias" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombresInfractores" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroComparendo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resoluciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secretarias" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "clsDatosResoluciones", propOrder = {
    "apellidosInfractores",
    "estadosResoluciones",
    "fechaComparendo",
    "fechaResolucion",
    "idSecretarias",
    "nombresInfractores",
    "numeroComparendo",
    "resoluciones",
    "secretarias",
    "total"
})
public class ClsDatosResoluciones {

    protected String apellidosInfractores;
    protected String estadosResoluciones;
    protected String fechaComparendo;
    protected String fechaResolucion;
    @XmlElement(name = "IDSecretarias")
    protected String idSecretarias;
    protected String nombresInfractores;
    protected String numeroComparendo;
    protected String resoluciones;
    protected String secretarias;
    protected Double total;

    /**
     * Obtiene el valor de la propiedad apellidosInfractores.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidosInfractores() {
        return apellidosInfractores;
    }

    /**
     * Define el valor de la propiedad apellidosInfractores.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidosInfractores(String value) {
        this.apellidosInfractores = value;
    }

    /**
     * Obtiene el valor de la propiedad estadosResoluciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadosResoluciones() {
        return estadosResoluciones;
    }

    /**
     * Define el valor de la propiedad estadosResoluciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadosResoluciones(String value) {
        this.estadosResoluciones = value;
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
     * Obtiene el valor de la propiedad fechaResolucion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaResolucion() {
        return fechaResolucion;
    }

    /**
     * Define el valor de la propiedad fechaResolucion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaResolucion(String value) {
        this.fechaResolucion = value;
    }

    /**
     * Obtiene el valor de la propiedad idSecretarias.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDSecretarias() {
        return idSecretarias;
    }

    /**
     * Define el valor de la propiedad idSecretarias.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDSecretarias(String value) {
        this.idSecretarias = value;
    }

    /**
     * Obtiene el valor de la propiedad nombresInfractores.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombresInfractores() {
        return nombresInfractores;
    }

    /**
     * Define el valor de la propiedad nombresInfractores.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombresInfractores(String value) {
        this.nombresInfractores = value;
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
     * Obtiene el valor de la propiedad resoluciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResoluciones() {
        return resoluciones;
    }

    /**
     * Define el valor de la propiedad resoluciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResoluciones(String value) {
        this.resoluciones = value;
    }

    /**
     * Obtiene el valor de la propiedad secretarias.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecretarias() {
        return secretarias;
    }

    /**
     * Define el valor de la propiedad secretarias.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecretarias(String value) {
        this.secretarias = value;
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
