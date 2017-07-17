/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.vehiculos.vehiculos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import us.aosinternational.usuario.Usuario;

/**
 *
 * @author Assist 02
 */
@Service
public class VehiculoService {

    private List<Vehiculo> vehiculos = new ArrayList<>(Arrays.asList(
            new Vehiculo("RMX200",
                    "ML500", "Vehiculo", "BMW", "2006", "Bogotá D.C.", new Usuario(
                            "Cédula de Ciudadanía", "1020715321", "Pepito", "Perez", "pablo.angola@aossas.com", "+573214567777")),
            new Vehiculo("REX020",
                    "ML500", "Vehiculo", "BMW", "2006", "Bogotá D.C.", new Usuario(
                            "Cédula de Ciudadanía", "10207155151", "Pepito", "Perez", "michael.gallego@aossas.com", "+573214567777")),
            new Vehiculo("TEP150",
                    "ML500", "Vehiculo", "BMW", "2006", "Bogotá D.C.", new Usuario(
                            "Cédula de Ciudadanía", "1011526262", "Luis", "Rodriguez", "michael.gallego@aossas.com", "+573214567777")),
            new Vehiculo("ARD578",
                    "ML500", "Vehiculo", "BMW", "2006", "Bogotá D.C.", new Usuario(
                            "Cédula de Ciudadanía", "1013641983", "Cristian", "Franco", "cristian.franco@aossas.com", "+573192518252"))
    ));

    public List<Vehiculo> getVehiculos() {

        return vehiculos;
    }

}
