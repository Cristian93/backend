
package servicios;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para clsSalidaResoluciones complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsSalidaResoluciones">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resoluciones" type="{http://Servicios/}clsDatosResoluciones" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsSalidaResoluciones", propOrder = {
    "resoluciones"
})
public class ClsSalidaResoluciones {

    @XmlElement(nillable = true)
    protected List<ClsDatosResoluciones> resoluciones;

    /**
     * Gets the value of the resoluciones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resoluciones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResoluciones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsDatosResoluciones }
     * 
     * 
     */
    public List<ClsDatosResoluciones> getResoluciones() {
        if (resoluciones == null) {
            resoluciones = new ArrayList<ClsDatosResoluciones>();
        }
        return this.resoluciones;
    }

}
