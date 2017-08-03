package us.aosinternational.notifications;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import us.aosinternational.notifications.connectDS.GoogleDataStoreComponent;
import us.aosinternational.notifications.entities.Customer;
import us.aosinternational.notifications.entities.Fine;
import us.aosinternational.notifications.entities.Tax;
import us.aosinternational.notifications.entities.Vehicle;

/**
 *
 * @author Cristian David Franco Garcia
 */
@Service
public class NotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);

    private final Datastore datastore;

    public NotificationService() {
        GoogleDataStoreComponent googleDataStoreComponent = new GoogleDataStoreComponent();
        this.datastore = googleDataStoreComponent.getDatastore();
    }

    public List<Notification> getNotifications() {
        Query<Entity> query = Query.newEntityQueryBuilder().setKind("notification").build();
        QueryResults<Entity> results = datastore.run(query);
        List<Notification> notifications = new ArrayList<>();
        while (results.hasNext()) {
            Entity entity = results.next();
            notifications.add(new Notification(
                    new BigInteger(String.valueOf(entity.getLong("notificationDate"))),
                    entity.getString("type"),
                    new Vehicle(entity.getEntity("vehicle").getString("licensePlate"), entity.getEntity("vehicle").getString("financeSecretariat")),
                    new Customer(entity.getEntity("customer").getString("idType"), entity.getEntity("customer").getString("idNumber"), entity.getEntity("customer").getString("firstName"), entity.getEntity("customer").getString("surname"), entity.getEntity("customer").getString("email"), entity.getEntity("customer").getString("cellPhone")),
                    new Fine(entity.getEntity("fine").getString("id"), entity.getEntity("fine").getString("secretariat"), new BigInteger(String.valueOf(entity.getEntity("fine").getLong("infringementDate"))), entity.getEntity("fine").getString("infringementDescription"), entity.getEntity("fine").getLong("amountPayWithoutCourse")),
                    new Tax(entity.getEntity("tax").getString("id"), entity.getEntity("tax").getString("secretariat"), entity.getEntity("tax").getLong("amount"))
            ));
        }

        LOGGER.info("Se encontraron " + notifications.size() + " vehiculos");

        return notifications;
    }

    public List<Notification> getNotificationsByobligationTypeAndobligationId(String obligationType, String obligationId) {

        List<Notification> notifications = getNotifications();

        if (obligationType.equals("fine")) {
            return notifications.stream().filter(notification -> notification.getFine().getId().equals(obligationId)).collect(Collectors.toList());
        } else {
            return notifications.stream().filter(notification -> notification.getTax().getId().equals(obligationId)).collect(Collectors.toList());
        }
    }

    public List<NotificationReport> getNotificationsReport() {
        List<NotificationReport> notificationsReports = new ArrayList<>();

        List<Notification> allNotifications = getNotifications();

        List<String> licensePlates = new ArrayList<>();

        allNotifications.stream().filter((notification) -> (!licensePlates.contains(notification.getVehicle().getLicensePlate()))).forEach((notification) -> {
            licensePlates.add(notification.getVehicle().getLicensePlate());
        });

        licensePlates.stream().forEach((String licensePlate) -> {
            notificationsReports.add(new NotificationReport(
                    licensePlate,
                    (allNotifications.stream().filter(notification -> notification.getVehicle().getLicensePlate().equals(licensePlate)).collect(Collectors.toList()))
                    .stream().filter(notification -> notification.getType().equals("email")).collect(Collectors.toList()).size(),
                    (allNotifications.stream().filter(notification -> notification.getVehicle().getLicensePlate().equals(licensePlate)).collect(Collectors.toList()))
                    .stream().filter(notification -> notification.getType().equals("SMS")).collect(Collectors.toList()).size(),
                    allNotifications.stream().filter(notification -> notification.getVehicle().getLicensePlate().equals(licensePlate)).collect(Collectors.toList())
            ));
        });
        LOGGER.info("Se generarón " + notificationsReports.size() + " filas");
        return notificationsReports;

    }

}
