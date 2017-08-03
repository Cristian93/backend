package us.aosinternational.notifications;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cristian David Franco Garcia
 */
@RestController
public class NotificationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/notifications")
    public List<Notification> getNotifications() {
        LOGGER.info("Ingresa consulta de todas las notificaciones");
        return notificationService.getNotifications();
    }

    @RequestMapping("/notificationsReport")
    public List<NotificationReport> notificationsReport() {
        LOGGER.info("Ingresa consulta de notificaciones por carro");
        return notificationService.getNotificationsReport();
    }

    @RequestMapping("/notifications/{obligationType}/{obligationId}")
    public List<Notification> getNotificationsByobligationTypeAndobligationId(@PathVariable String obligationType, @PathVariable String obligationId) {
        LOGGER.info("Ingresa consulta de notificaciones por tipo y ID de obligación: " + obligationType + " - " + obligationId);
        return notificationService.getNotificationsByobligationTypeAndobligationId(obligationType, obligationId);
    }

}
