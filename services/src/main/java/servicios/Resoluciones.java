
package servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Resoluciones complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Resoluciones">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocumentoRes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TipDocRes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Resoluciones", propOrder = {
    "documentoRes",
    "tipDocRes"
})
public class Resoluciones {

    @XmlElement(name = "DocumentoRes")
    protected String documentoRes;
    @XmlElement(name = "TipDocRes")
    protected int tipDocRes;

    /**
     * Obtiene el valor de la propiedad documentoRes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentoRes() {
        return documentoRes;
    }

    /**
     * Define el valor de la propiedad documentoRes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentoRes(String value) {
        this.documentoRes = value;
    }

    /**
     * Obtiene el valor de la propiedad tipDocRes.
     * 
     */
    public int getTipDocRes() {
        return tipDocRes;
    }

    /**
     * Define el valor de la propiedad tipDocRes.
     * 
     */
    public void setTipDocRes(int value) {
        this.tipDocRes = value;
    }

}
