/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.entities.vehicles;

import com.google.auth.oauth2.GoogleCredentials;
import java.util.ArrayList;

import java.util.List;
import org.springframework.stereotype.Service;
import us.aosinternational.entities.customers.Customer;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Assist 02
 */
@Service
public class VehicleService {
    
    
    private List<Vehicle> vehiculossss = Arrays.asList(new Vehicle("RMX20", "mEDELLIN", new Customer("C.C.", "123456", "PABLO", "GOMEZ", "PABLO.GMAIL.COM", "3213456789")),
            new Vehicle("RGZ197", "mEDELLIN", new Customer("C.C.", "12345678", "PABLO", "GOMEZ", "PABLO.GMAIL.COM", "3213456789")),
    new Vehicle("REX020", "mEDELLIN", new Customer("C.C.", "123456", "PABLO", "GOMEZ", "PABLO.GMAIL.COM", "3213456789")),
            new Vehicle("TEP150", "mEDELLIN", new Customer("C.C.", "123456", "PABLO", "GOMEZ", "PABLO.GMAIL.COM", "3213456789")),
            new Vehicle("DAB444", "mEDELLIN", new Customer("C.C.", "123456", "PABLO", "GOMEZ", "PABLO.GMAIL.COM", "3213456789"))
    
    
    )
            
            ;
   


    
    
    
    
    
    public List<Vehicle> getVehicles() throws IOException  {

        //Autentificación por medio de Google Cloud SDK Shell
        //Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        //Autentificación por medio de FileInputStream
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println("File: " + ClassLoader.getSystemResource("taxRobot.json").getFile());
        DatastoreOptions options = DatastoreOptions.newBuilder()
                .setProjectId("taxrobot-51cb8")
                .setCredentials(GoogleCredentials.fromStream(new FileInputStream(ClassLoader.getSystemResource("taxRobot.json").getFile())))
                .build();
        
      

        /*Datastore datastore = options.getService();

        Query<Entity> query = Query.newEntityQueryBuilder().setKind("vehicle").build();

        QueryResults<Entity> results = datastore.run(query);

        List<Vehicle> vehicles = new ArrayList<>();

        while (results.hasNext()) {
            Entity entity = results.next();
            vehicles.add(new Vehicle(entity.getString("licensePlate"), entity.getString("financeSecretariat"), new Customer(entity.getEntity("customer").getString("idType"), entity.getEntity("customer").getString("idNumber"), entity.getEntity("customer").getString("firstName"), entity.getEntity("customer").getString("surname"), entity.getEntity("customer").getString("email"), entity.getEntity("customer").getString("cellPhone"))));
        }*/

        return vehiculossss;
    }

    public Vehicle getVehicle(String licensePlate) throws IOException {

        //Autentificación por medio de Google Cloud SDK Shell
        //Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        //Autentificación por medio de FileInputStream
        DatastoreOptions options = DatastoreOptions.newBuilder()
                .setProjectId("taxrobot-51cb8")
                .setCredentials(GoogleCredentials.fromStream(new FileInputStream("C:\\Users\\Assist 02\\Documents\\NetBeansProjects\\taxrobot-back\\vehicles\\src\\main\\resources\\taxRobot.json")))
                .build();

        Datastore datastore = options.getService();

        Query<Entity> query = Query.newEntityQueryBuilder().setKind("vehicle").build();

        QueryResults<Entity> results = datastore.run(query);

        List<Vehicle> vehicles = new ArrayList<>();

        while (results.hasNext()) {
            Entity entity = results.next();
            vehicles.add(new Vehicle(entity.getString("licensePlate"), entity.getString("financeSecretariat"), new Customer(entity.getEntity("customer").getString("idType"), entity.getEntity("customer").getString("idNumber"), entity.getEntity("customer").getString("firstName"), entity.getEntity("customer").getString("surname"), entity.getEntity("customer").getString("email"), entity.getEntity("customer").getString("cellPhone"))));
        }

        return vehicles.stream().filter(vehicle -> vehicle.getLicensePlate().equals(licensePlate)).findFirst().get();
    }

    public void createVehicle(Vehicle[] vehicles) throws IOException {

        for (Vehicle vehicle : vehicles) {

            //Autentificación por medio de Google Cloud SDK Shell
            //Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
            //Autentificación por medio de FileInputStream
            DatastoreOptions options = DatastoreOptions.newBuilder()
                    .setProjectId("taxrobot-51cb8")
                    .setCredentials(GoogleCredentials.fromStream(new FileInputStream("C:\\Users\\Assist 02\\Documents\\NetBeansProjects\\taxrobot-back\\vehicles\\src\\main\\resources\\taxRobot.json")))
                    .build();

            Datastore datastore = options.getService();

            // Selección del "Kind" donde se van a almacenar los datos
            KeyFactory keyFactory = datastore.newKeyFactory().setKind("vehicle");

            // Prepares the new entity
            FullEntity<IncompleteKey> customer = Entity.newBuilder()
                    .set("idType", vehicle.getCustomer().getIdType())
                    .set("idNumber", vehicle.getCustomer().getIdNumber())
                    .set("firstName", vehicle.getCustomer().getFirstName())
                    .set("surname", vehicle.getCustomer().getSurname())
                    .set("email", vehicle.getCustomer().getEmail())
                    .set("cellPhone", vehicle.getCustomer().getCellPhone())
                    .build();

            //Crea un ID automaticamente para cada registro
            Key vehicleKey = datastore.allocateId(keyFactory.newKey());
            Entity vehiculo = Entity.newBuilder(vehicleKey)
                    .set("licensePlate", vehicle.getLicensePlate())
                    .set("financeSecretariat", vehicle.getFinanceSecretariat())
                    .set("customer", customer)
                    .build();

            // Saves the entity
            datastore.put(vehiculo);
        }
    }
}
