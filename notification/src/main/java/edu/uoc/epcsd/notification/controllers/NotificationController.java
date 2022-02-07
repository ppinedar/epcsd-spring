package edu.uoc.epcsd.notification.controllers;

import edu.uoc.epcsd.notification.pojos.Show;
import edu.uoc.epcsd.notification.services.NotificationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Log4j2
@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final String showCatalogUrl = "http://localhost:8080/show/{id}";

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/{id}")
    public ResponseEntity sendShowCreated(@PathVariable Long id) {
        log.trace("sendShowCreated");

        // retrieve show details
        RestTemplate restTemplate = new RestTemplate();
        Show show = restTemplate.getForObject(showCatalogUrl, Show.class, id);

        if (show != null) {
            notificationService.notifyShowCreation(show);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
