
package servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AcuerdosPagos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AcuerdosPagos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocumentoAC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TipDocAC" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AcuerdosPagos", propOrder = {
    "documentoAC",
    "tipDocAC"
})
public class AcuerdosPagos {

    @XmlElement(name = "DocumentoAC")
    protected String documentoAC;
    @XmlElement(name = "TipDocAC")
    protected int tipDocAC;

    /**
     * Obtiene el valor de la propiedad documentoAC.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentoAC() {
        return documentoAC;
    }

    /**
     * Define el valor de la propiedad documentoAC.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentoAC(String value) {
        this.documentoAC = value;
    }

    /**
     * Obtiene el valor de la propiedad tipDocAC.
     * 
     */
    public int getTipDocAC() {
        return tipDocAC;
    }

    /**
     * Define el valor de la propiedad tipDocAC.
     * 
     */
    public void setTipDocAC(int value) {
        this.tipDocAC = value;
    }

}
