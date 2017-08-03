package com.taxrobot.services.services;

import com.taxrobot.services.connectDS.GoogleDataStoreComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.google.cloud.datastore.*;
import com.taxrobot.services.dto.CustomerDto;
import com.taxrobot.services.dto.NotificationType;
import com.taxrobot.services.dto.VehicleDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cristian David Franco Garcia
 */
@Component
public class VehicleService {

    private final Datastore datastore;
    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleService.class);

    public VehicleService() {
        GoogleDataStoreComponent googleDataStoreComponent = new GoogleDataStoreComponent();
        this.datastore = googleDataStoreComponent.getDatastore();
    }

    public List<VehicleDto> getVehicles() {

        Query<Entity> query = Query.newEntityQueryBuilder().setKind("vehicle").build();
        List<VehicleDto> vehicles = new ArrayList<>();
        QueryResults<Entity> results;
        try {
            results = datastore.run(query);

            while (results.hasNext()) {
                Entity entity = results.next();
                vehicles.add(new VehicleDto(entity.getString("licensePlate"), entity.getString("financeSecretariat"), new CustomerDto(entity.getEntity("customer").getString("idType"), entity.getEntity("customer").getString("idNumber"), entity.getEntity("customer").getString("firstName"), entity.getEntity("customer").getString("surname"), entity.getEntity("customer").getString("email"), entity.getEntity("customer").getString("cellPhone")), new NotificationType(entity.getEntity("notificationType").getBoolean("email"), entity.getEntity("notificationType").getBoolean("sms"))));
            }
            LOGGER.info("Se encontraron " + vehicles.size() + " vehiculos");
        } catch (Exception e) {
            LOGGER.error(e.getClass() + " - " + e.getMessage());
        }

        return vehicles;
    }

    public VehicleDto getVehicle(String licensePlate) {

        List<VehicleDto> vehicles = getVehicles();

        VehicleDto vehicleDto = null;
        if (licensePlate != null && !licensePlate.equals("")) {
            vehicleDto = vehicles.stream().filter(vehicle -> vehicle.getLicensePlate().equals(licensePlate)).findFirst().get();
        }
        return vehicleDto;
    }

    public void createVehicle(VehicleDto[] vehicles) throws IOException {

        for (VehicleDto vehicle : vehicles) {

            LOGGER.info("Vehiculo a ser agregado: " + vehicle.getLicensePlate());
            // Selección del "Kind" donde se van a almacenar los datos
            //KeyFactory keyFactory;
            try {

                Key vehicleKey = datastore.newKeyFactory().setKind("vehicle").newKey(vehicle.getLicensePlate());

                // Prepares the new entity
                FullEntity<IncompleteKey> customer = Entity.newBuilder()
                        .set("idType", vehicle.getCustomer().getIdType())
                        .set("idNumber", vehicle.getCustomer().getIdNumber())
                        .set("firstName", vehicle.getCustomer().getFirstName())
                        .set("surname", vehicle.getCustomer().getSurname())
                        .set("email", vehicle.getCustomer().getEmail())
                        .set("cellPhone", "+57" + vehicle.getCustomer().getCellPhone())
                        .build();

                FullEntity<IncompleteKey> notificationType = Entity.newBuilder()
                        .set("email", vehicle.getNotificationType().isEmail())
                        .set("sms", vehicle.getNotificationType().isSMS())
                        .build();

                Entity vehiculo = Entity.newBuilder(vehicleKey)
                        .set("licensePlate", vehicle.getLicensePlate())
                        .set("financeSecretariat", vehicle.getFinanceSecretariat())
                        .set("customer", customer)
                        .set("notificationType", notificationType)
                        .build();

                // Saves the entity
                datastore.put(vehiculo);
                LOGGER.info("Vehiculo agregado: " + vehicle.getLicensePlate());
            } catch (Exception e) {
                LOGGER.error(e.getClass() + " - " + e.getMessage());
            }
        }
    }
}