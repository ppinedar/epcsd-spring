package edu.uoc.epcsd.notification.services;

import edu.uoc.epcsd.notification.pojos.Category;
import edu.uoc.epcsd.notification.pojos.Show;
import edu.uoc.epcsd.notification.pojos.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class NotificationService {

    @Autowired
    private UserService userService;    // mock

    public void notifyShowCreation(Show show) {

        for (Category category : show.getCategories()) {
            for (User user : userService.getUsersByFavouriteCategory(category)) {
                notifyUser(user, show);
            }
        }
    }

    // mock notification
    private void notifyUser(User user, Show show) {
        // aqui s'enviaria un correu / notificació push / etc.
        log.info("S'ha afegit l'espectacle \"" + show.getName() + "\"!. S'ha enviat un correu electrònic a l'usuari \"" + user.getFullName() + "\"");
    }
}
