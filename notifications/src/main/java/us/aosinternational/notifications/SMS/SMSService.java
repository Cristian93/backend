package us.aosinternational.notifications.SMS;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import us.aosinternational.notifications.connectDS.GoogleDataStoreComponent;
import us.aosinternational.notifications.connectDS.TwilioComponent;

/**
 *
 * @author Cristian David Franco Garcia
 */
@Service
public class SMSService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SMSService.class);

    private final Datastore datastore;

    public SMSService() {
        GoogleDataStoreComponent googleDataStoreComponent = new GoogleDataStoreComponent();
        this.datastore = googleDataStoreComponent.getDatastore();
    }

    /*private List<SMS> SMSs = new ArrayList<>(Arrays.asList(
            new SMS(
                    new Vehicle("ARD578", "Bogotá D.C"),
                    new Customer("Cédula de Ciudadanía", "1072654329", "Carlos", "Perez", "cristian.franco@aossas.com", "+573192518252"),
                    new Fine("1f", "Medellin", new BigInteger("1501105618416"), "Conducir un vehículo sin luces o con alguna de ellas dañada", 300654),
                    new Tax("1t", "Bogotá D.C.", 110000)),
            new SMS(
                    new Vehicle("DRD763", "Bogotá D.C"),
                    new Customer("Cédula de Ciudadanía", "2072654329", "Alberto", "Lopez", "cristian.franco@aossas.com", "+573192518252"),
                    new Fine("2f", "Barranquilla", new BigInteger("1501105618416"), "Conducir en estado de embriaguez, con grado 3 y primera reincidencia", 1897654),
                    new Tax()),
            new SMS(
                    new Vehicle("XFR987", "Bogotá D.C"),
                    new Customer("Cédula de Ciudadanía", "3072654329", "Sandra", "Bolaños", "cristian.franco@aossas.com", "+573192518252"),
                    new Fine(),
                    new Tax("03t", "Bogotá D.C.", 110000))
    ));*/
 /*public List<SMS> getSMSs() {
        return SMSs;
    }*/
    public void sendSMS(SMS[] SMSs) {

        TwilioComponent twilio = new TwilioComponent();
        twilio.getTwilioConnection();

        for (SMS SMS : SMSs) {

            //Multa
            if (!SMS.getFine().getId().equals("")) {
                //Calcular fechas de la infraccion
                //Fecha maxima descuesto del 50%
                Calendar paymentDateWithCourse50 = Calendar.getInstance();
                paymentDateWithCourse50.setTime(new Date(SMS.getFine().getInfringementDate().longValue()));
                paymentDateWithCourse50.add(Calendar.DAY_OF_YEAR, 5);

                //Fecha maxima descuesto del 25%
                Calendar paymentDateWithCourse25 = Calendar.getInstance();
                paymentDateWithCourse25.setTime(new Date(SMS.getFine().getInfringementDate().longValue()));
                paymentDateWithCourse25.add(Calendar.DAY_OF_YEAR, 20);

                //Fecha maxima del pago
                Calendar paymentDateWithoutCourse = Calendar.getInstance();
                paymentDateWithoutCourse.setTime(new Date(SMS.getFine().getInfringementDate().longValue()));
                paymentDateWithoutCourse.add(Calendar.DAY_OF_YEAR, 30);

                Message message = Message.creator(new PhoneNumber(SMS.getCustomer().getCellPhone()), new PhoneNumber(TwilioComponent.FROM), "Queremos informarle que el día " + new SimpleDateFormat("dd-MM-yyyy").format(new Date(SMS.getFine().getInfringementDate().longValue())) + " nos ha sido reportada una fotomulta por valor de $ " + SMS.getFine().getAmountPayWithoutCourse() + " para el vehículo de placas " + SMS.getVehicle().getLicensePlate() + ". Fechas maximas de pago: *Con curso: " + new SimpleDateFormat("dd-MM-yyyy").format(new Date(paymentDateWithCourse50.getTimeInMillis())) + " (50% Desc.), " + new SimpleDateFormat("dd-MM-yyyy").format(new Date(paymentDateWithCourse25.getTimeInMillis())) + " (25% Desc.). *Sin curso: " + new SimpleDateFormat("dd-MM-yyyy").format(new Date(paymentDateWithoutCourse.getTimeInMillis())) + ". Grupo Bancolombia.").create();
                LOGGER.info("Mensaje enviado: " + message.getSid());

            } //Tax
            else {

                Message message = Message.creator(new PhoneNumber(SMS.getCustomer().getCellPhone()), new PhoneNumber(TwilioComponent.FROM), "Queremos informarle que tiene un impuesto de vehiculo sin pagar por valor de $ " + SMS.getTax().getAmount() + " para el vehículo de placas " + SMS.getVehicle().getLicensePlate() + ". Fechas maximas de pago: *Con 10% de descuento: ,*Sin sanción:").create();
                LOGGER.info("Mensaje enviado: " + message.getSid());

            }

            try {

                // Preparing notification entities
                FullEntity<IncompleteKey> customer = Entity.newBuilder()
                        .set("idType", SMS.getCustomer().getIdType())
                        .set("idNumber", SMS.getCustomer().getIdNumber())
                        .set("firstName", SMS.getCustomer().getFirstName())
                        .set("surname", SMS.getCustomer().getSurname())
                        .set("email", SMS.getCustomer().getEmail())
                        .set("cellPhone", SMS.getCustomer().getCellPhone())
                        .build();

                FullEntity<IncompleteKey> vehicle = Entity.newBuilder()
                        .set("licensePlate", SMS.getVehicle().getLicensePlate())
                        .set("financeSecretariat", SMS.getVehicle().getFinanceSecretariat())
                        .build();

                FullEntity<IncompleteKey> fine = Entity.newBuilder()
                        .set("id", SMS.getFine().getId())
                        .set("secretariat", SMS.getFine().getSecretariat())
                        .set("infringementDate", SMS.getFine().getInfringementDate().longValue())
                        .set("infringementDescription", SMS.getFine().getInfringementDescription())
                        .set("amountPayWithoutCourse", SMS.getFine().getAmountPayWithoutCourse())
                        .build();

                FullEntity<IncompleteKey> tax = Entity.newBuilder()
                        .set("id", SMS.getTax().getId())
                        .set("secretariat", SMS.getTax().getSecretariat())
                        .set("amount", SMS.getTax().getAmount())
                        .build();

                //Guardar notificación
                // Selección del "Kind" donde se van a almacenar los datos
                KeyFactory keyFactory = datastore.newKeyFactory().setKind("notification");
                //Crea un ID automaticamente para cada registro
                Key notificationKey = datastore.allocateId(keyFactory.newKey());
                Entity notification = Entity.newBuilder(notificationKey)
                        .set("notificationDate", System.currentTimeMillis())
                        .set("type", "SMS")
                        .set("customer", customer)
                        .set("vehicle", vehicle)
                        .set("fine", fine)
                        .set("tax", tax)
                        .build();

                // Saves the entity
                datastore.put(notification);

            } catch (Exception e) {
                LOGGER.error(e.getClass() + " - " + e.getMessage());
            }
        }
    }

}
