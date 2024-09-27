package pisa.training.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pisa.training.bookshop.model.Publisher;
import pisa.training.bookshop.service.PublisherService;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public List<Publisher> getAllPublishers(){
        return publisherService.getAllPublishers();
    }

    @PostMapping
    public Publisher addPublisher(@RequestBody Publisher publisher){
        return publisherService.addPublisher(publisher);
    }

    @DeleteMapping("/{publisherId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable Long publisherId){
        publisherService.deletePublisherById(publisherId);
    }

    @PutMapping("/{publisherId}")
    public Publisher updatePublisher(@PathVariable Long publisherId, @RequestBody Publisher updatePublisher){
        return publisherService.updatePublisherById(publisherId,updatePublisher);
    }



}
