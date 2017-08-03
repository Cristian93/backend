package us.aosinternational.notifications.email;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;
import us.aosinternational.notifications.connectDS.GoogleDataStoreComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cristian David Franco Garcia
 */
@Service
public class EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    private final Datastore datastore;

    public EmailService() {
        GoogleDataStoreComponent googleDataStoreComponent = new GoogleDataStoreComponent();
        this.datastore = googleDataStoreComponent.getDatastore();
    }

    /*private List<Email> emailss = new ArrayList<>(Arrays.asList(
            new Email(
                    new Vehicle("ARD578", "Bogotá D.C"),
                    new Customer("Cédula de Ciudadanía", "1072654329", "Carlos", "Perez", "cristian.franco@aossas.com", "+573192518252"),
                    new Fine("0", "Medellin", new BigInteger("1501105618416"), "Conducir un vehículo sin luces o con alguna de ellas dañada", 300654),
                    new Tax("0", "Bogotá D.C.", 110000)
            ),
            new Email(
                    new Vehicle("DRD763", "Bogotá D.C"),
                    new Customer("Cédula de Ciudadanía", "2072654329", "Alberto", "Lopez", "cristian.franco@aossas.com", "+573192518252"),
                    new Fine("0", "Barranquilla", new BigInteger("1501105618416"), "Conducir en estado de embriaguez, con grado 3 y primera reincidencia", 1897654),
                    new Tax()
            ),
            new Email(
                    new Vehicle("XFR987", "Bogotá D.C"),
                    new Customer("Cédula de Ciudadanía", "3072654329", "Sandra", "Bolaños", "cristian.franco@aossas.com", "+573192518252"),
                    new Fine(),
                    new Tax("0", "Bogotá D.C.", 110000)
            )
    ));*/
 /*public List<Email> getEmails() {

        return emailss;
    }*/
    public void sendEmail(Email[] emails) throws IOException {

        Query<Entity> query = Query.newEntityQueryBuilder().setKind("parametrization").build();

        QueryResults<Entity> results = datastore.run(query);

        Entity entity = results.next();

        for (Email email : emails) {
            String subject = "";
            String contentText = "";
            //Fine
            if (!email.getFine().getId().equals("")) {
                //Calcular fechas de la infraccion para el pago de la multa
                //Fecha maxima descuesto del 50%
                Calendar paymentDateWithCourse50 = Calendar.getInstance();
                paymentDateWithCourse50.setTime(new Date(email.getFine().getInfringementDate().longValue()));
                paymentDateWithCourse50.add(Calendar.DAY_OF_YEAR, 5);
                //Fecha maxima descuesto del 25%
                Calendar paymentDateWithCourse25 = Calendar.getInstance();
                paymentDateWithCourse25.setTime(new Date(email.getFine().getInfringementDate().longValue()));
                paymentDateWithCourse25.add(Calendar.DAY_OF_YEAR, 20);
                //Fecha maxima del pago
                Calendar paymentDateWithoutCourse = Calendar.getInstance();
                paymentDateWithoutCourse.setTime(new Date(email.getFine().getInfringementDate().longValue()));
                paymentDateWithoutCourse.add(Calendar.DAY_OF_YEAR, 30);
                subject = entity.getString("customerEmailSubject").replace("${licensePlate}", email.getVehicle().getLicensePlate()).replace("${leasing}", "0003456").replace("${bank}", "Grupo Bancolombia");
                contentText = entity.getString("customerEmailTemplate").replace("${customerEmailContentText}", entity.getString("customerEmailContentText").replace("${secretariat}", email.getFine().getSecretariat()).replace("${infringementDate}", new SimpleDateFormat("dd-MM-yyyy").format(new Date(email.getFine().getInfringementDate().longValue()))).replace("${licensePlate}", email.getVehicle().getLicensePlate()).replace("${leasing}", "0003456").replace("${bank}", "Grupo Bancolombia").replace("${infringementDescription}", email.getFine().getInfringementDescription()).replace("${paymentDateWithCourse50}", new SimpleDateFormat("dd-MM-yyyy").format(paymentDateWithCourse50.getTimeInMillis())).replace("${amountPayWithCourse50}", String.valueOf(email.getFine().getAmountPayWithoutCourse() / 2)).replace("${paymentDateWithCourse25}", new SimpleDateFormat("dd-MM-yyyy").format(paymentDateWithCourse25.getTimeInMillis())).replace("${amountPayWithCourse25}", String.valueOf(email.getFine().getAmountPayWithoutCourse() - ((email.getFine().getAmountPayWithoutCourse() / 100) * 25))).replace("${paymentDateWithoutCourse}", new SimpleDateFormat("dd-MM-yyyy").format(paymentDateWithoutCourse.getTimeInMillis())).replace("${amountPayWithoutCourse}", Long.toString(email.getFine().getAmountPayWithoutCourse())).replace("${email}", "leasing@grupobancolombia.com.co").replace("${telephone}", "54 3459876").replaceAll("(\\r|\\n)", "<br>"));
            } //Tax
            else {
                subject = "asunto impuesto";
                contentText = entity.getString("customerEmailTemplate").replace("${customerEmailContentText}", entity.getString("customerEmailContentText").replace("${secretariat}", email.getFine().getSecretariat()).replace("${infringementDate}", new SimpleDateFormat("dd-MM-yyyy").format(new Date(email.getFine().getInfringementDate().longValue()))).replace("${licensePlate}", email.getVehicle().getLicensePlate()).replace("${leasing}", "0003456").replace("${bank}", "Grupo Bancolombia").replace("${infringementDescription}", email.getFine().getInfringementDescription()).replace("${amountPayWithCourse50}", String.valueOf(email.getFine().getAmountPayWithoutCourse() / 2)).replace("${amountPayWithCourse25}", String.valueOf(email.getFine().getAmountPayWithoutCourse() - ((email.getFine().getAmountPayWithoutCourse() / 100) * 25))).replace("${amountPayWithoutCourse}", Long.toString(email.getFine().getAmountPayWithoutCourse())).replace("${email}", "leasing@grupobancolombia.com.co").replace("${telephone}", "54 3459876").replaceAll("(\\r|\\n)", "<br>"));
            }
            //Enviar mensaje
            try {
                String FROM = "cristiandavidfrancogarcia@gmail.com";
                Properties props = new Properties();
                props.setProperty("mail.smtp.host", "smtp.gmail.com");
                props.setProperty("mail.smtp.ssl.enable", "true");
                props.setProperty("mail.smtp.starttls.enable", "true");
                props.setProperty("mail.smtp.auth", "true");
                props.setProperty("mail.smtp.port", "465");
                props.setProperty("mail.smtp.user", FROM);
                // Preparamos la sesion
                Session session = Session.getDefaultInstance(props);
                // Construimos el mensaje
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(FROM));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getCustomer().getEmail()));
                message.setSubject(subject);
                message.setContent(contentText, "text/html; charset=utf-8");
                // Lo enviamos.
                Transport t = session.getTransport("smtp");
                t.connect(FROM, "PRUEBASAOS");
                t.sendMessage(message, message.getAllRecipients());
                // Cierre.
                t.close();
                // Preparing notification entities
                FullEntity<IncompleteKey> customer = Entity.newBuilder().set("idType", email.getCustomer().getIdType()).set("idNumber", email.getCustomer().getIdNumber()).set("firstName", email.getCustomer().getFirstName()).set("surname", email.getCustomer().getSurname()).set("email", email.getCustomer().getEmail()).set("cellPhone", email.getCustomer().getCellPhone()).build();
                FullEntity<IncompleteKey> vehicle = Entity.newBuilder().set("licensePlate", email.getVehicle().getLicensePlate()).set("financeSecretariat", email.getVehicle().getFinanceSecretariat()).build();
                FullEntity<IncompleteKey> fine = Entity.newBuilder().set("id", email.getFine().getId()).set("secretariat", email.getFine().getSecretariat()).set("infringementDate", email.getFine().getInfringementDate().longValue()).set("infringementDescription", email.getFine().getInfringementDescription()).set("amountPayWithoutCourse", email.getFine().getAmountPayWithoutCourse()).build();
                FullEntity<IncompleteKey> tax = Entity.newBuilder().set("id", email.getTax().getId()).set("secretariat", email.getTax().getSecretariat()).set("amount", email.getTax().getAmount()).build();
                //Guardar notificación
                // Selección del "Kind" donde se van a almacenar los datos
                KeyFactory keyFactory = datastore.newKeyFactory().setKind("notification");
                //Crea un ID automaticamente para cada registro
                Key notificationKey = datastore.allocateId(keyFactory.newKey());
                Entity notification = Entity.newBuilder(notificationKey)
                        .set("notificationDate", System.currentTimeMillis())
                        .set("type", "email")
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

    /* public void sendEmailAdmin() throws IOException {

        final Runnable tarea = new Runnable() {

            public void run() {

                //Enviar mensaje
                try {

                    Query<Entity> query = Query.newEntityQueryBuilder().setKind("parametrization").build();

                    QueryResults<Entity> results = datastore.run(query);

                    Entity entity = results.next();

                    String FROM = "cristiandavidfrancogarcia@gmail.com";

                    Properties props = new Properties();
                    props.setProperty("mail.smtp.host", "smtp.gmail.com");
                    props.setProperty("mail.smtp.ssl.enable", "true");
                    props.setProperty("mail.smtp.starttls.enable", "true");
                    props.setProperty("mail.smtp.auth", "true");
                    props.setProperty("mail.smtp.port", "465");
                    props.setProperty("mail.smtp.user", FROM);

                    // Preparamos la sesion
                    Session session = Session.getDefaultInstance(props);

                    // Construimos el mensaje
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(FROM));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                            "cristian.franco@aossas.com"));
                    message.setSubject("Fotomulta al vehículo de placas");

                    message.setContent(entity.getString("administratorEmailTemplate"), "text/html; charset=utf-8");

                    // Lo enviamos.
                    Transport t = session.getTransport("smtp");
                    t.connect(FROM, "PRUEBASAOS");
                    t.sendMessage(message, message.getAllRecipients());
                    // Cierre.
                    t.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };

        Query<Entity> query = Query.newEntityQueryBuilder().setKind("parametrization").build();

        QueryResults<Entity> results = datastore.run(query);

        Entity entity = results.next();

        ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
        timer.scheduleAtFixedRate(tarea, entity.getLong("initialDelay"), entity.getLong("period"), TimeUnit.SECONDS);
    }*/
}
