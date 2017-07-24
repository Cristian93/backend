
package servicios;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para clsSalidaComparendos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsSalidaComparendos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="comparendos" type="{http://Servicios/}clsDatosComparendos" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsSalidaComparendos", propOrder = {
    "comparendos"
})
public class ClsSalidaComparendos {

    @XmlElement(nillable = true)
    protected List<ClsDatosComparendos> comparendos;

    /**
     * Gets the value of the comparendos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comparendos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComparendos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsDatosComparendos }
     * 
     * 
     */
    public List<ClsDatosComparendos> getComparendos() {
        if (comparendos == null) {
            comparendos = new ArrayList<ClsDatosComparendos>();
        }
        return this.comparendos;
    }

}
