
package servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SuspencionesLicencias complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SuspencionesLicencias">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocumentoSL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TipoDocSL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SuspencionesLicencias", propOrder = {
    "documentoSL",
    "tipoDocSL"
})
public class SuspencionesLicencias {

    @XmlElement(name = "DocumentoSL")
    protected String documentoSL;
    @XmlElement(name = "TipoDocSL")
    protected String tipoDocSL;

    /**
     * Obtiene el valor de la propiedad documentoSL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentoSL() {
        return documentoSL;
    }

    /**
     * Define el valor de la propiedad documentoSL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentoSL(String value) {
        this.documentoSL = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDocSL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDocSL() {
        return tipoDocSL;
    }

    /**
     * Define el valor de la propiedad tipoDocSL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDocSL(String value) {
        this.tipoDocSL = value;
    }

}
