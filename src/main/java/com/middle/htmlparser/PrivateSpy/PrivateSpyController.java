package com.middle.htmlparser.PrivateSpy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/info")
public class PrivateSpyController {

    private PrivateSpyService privateSpyService;

    @Autowired
    public PrivateSpyController(PrivateSpyService privateSpyService) {
        this.privateSpyService = privateSpyService;
    }

    @GetMapping
    public List<PrivateSpy> getSuperSpies(){
        return privateSpyService.getSuperSpies();
    }

    @PostMapping
    public void addSpy(@RequestBody PrivateSpy spy) {
        privateSpyService.addSpy(spy);
    }

    @DeleteMapping(path = "{spyID}")
    public void deleteSpy(@PathVariable("spyID") Integer spyID){
        privateSpyService.deleteSpy(spyID);
    }

}
