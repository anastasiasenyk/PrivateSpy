package com.middle.htmlparser.PrivateSpy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/info")
public class PrivateSpyController {

    private final PrivateSpyService privateSpyService;

    @Autowired
    public PrivateSpyController(PrivateSpyService privateSpyService) {
        this.privateSpyService = privateSpyService;
    }

    @GetMapping
    public List<PrivateSpy> getSuperSpies(){
        return privateSpyService.getSuperSpies();
    }

    @GetMapping(path="/{domain}")
    public Optional<PrivateSpy> getSuperSpy(@PathVariable String domain){
        return privateSpyService.getSuperSpy(domain);
    }

    @PostMapping
    public void addSpy(@RequestBody String domain) {
        privateSpyService.addSpy(domain);
    }

    @DeleteMapping(path = "/delete/id/{spyID}")
    public void deleteSpyByID(@PathVariable("spyID") Integer spyID){
        privateSpyService.deleteSpyByID(spyID);
    }

    @DeleteMapping(path = "/delete/domain/{spyID}")
    public void deleteSpyByDomain(@PathVariable("spyID") String spyDomain){
        privateSpyService.deleteSpyByDomain(spyDomain);
    }

}
