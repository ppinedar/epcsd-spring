package edu.uoc.epcsd.showcatalog.controllers;

import edu.uoc.epcsd.showcatalog.dtos.ShowDTO;
import edu.uoc.epcsd.showcatalog.entities.Category;
import edu.uoc.epcsd.showcatalog.entities.Show;
import edu.uoc.epcsd.showcatalog.kafka.KafkaConstants;
import edu.uoc.epcsd.showcatalog.repositories.CategoryRepository;
import edu.uoc.epcsd.showcatalog.repositories.ShowRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private KafkaTemplate<String, Show> kafkaTemplate;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Show> getAllShows() {
        log.trace("getAllShows");

        return showRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getById(@PathVariable Long id) {
        log.trace("getById");

        Optional<Show> show = showRepository.findById(id);
        if (show.isPresent()) {
            return ResponseEntity.ok(show.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Show> create(@RequestBody ShowDTO showDTO) {
        log.trace("create");

        List<Category> categories = new LinkedList<>();
        for (Long categoryId : showDTO.getCategories()) {
            Optional<Category> category = categoryRepository.findById(categoryId);

            if (category.isPresent()) {
                categories.add(category.get());
            } else {
                log.warn("The specified category ID does not exist");
            }
        }

        Show show = Show.builder().name(showDTO.getName()).categories(categories).build();
        log.trace("Creating show " + show);
        Show persistedShow = showRepository.save(show);

        log.trace("Sending " + persistedShow + " to " + KafkaConstants.SHOW_TOPIC + KafkaConstants.SEPARATOR + KafkaConstants.COMMAND_ADD + " topic.");
        kafkaTemplate.send(KafkaConstants.SHOW_TOPIC + KafkaConstants.SEPARATOR + KafkaConstants.COMMAND_ADD, persistedShow);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(persistedShow.getId())
                .toUri();

        return ResponseEntity.created(uri).body(persistedShow);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Show> update(@PathVariable Long id, @RequestBody ShowDTO showDTO) {

        Optional<Show> show = showRepository.findById(id);

        if (show.isPresent()) {
            Show repositoryShow = show.get();
            repositoryShow.setName(showDTO.getName());
            repositoryShow.getCategories().clear();
            for (Long categoryId : showDTO.getCategories()) {
                Optional<Category> category = categoryRepository.findById(categoryId);

                if (category.isPresent()) {
                    repositoryShow.getCategories().add(category.get());
                } else {
                    log.warn("The specified category ID does not exist");
                }
            }

            showRepository.save(repositoryShow);
            return new ResponseEntity<>(repositoryShow, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Show> delete(@PathVariable Long id) {

        Optional<Show> show = showRepository.findById(id);

        if (show.isPresent()) {
            showRepository.delete(show.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
