package com.middle.htmlparser.PrivateSpy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/info")
public class PrivateSpyController {
    private final PrivateSpyService privateSpyService;

    @Autowired
    public PrivateSpyController(PrivateSpyService privateSpyService) {
        this.privateSpyService = privateSpyService;
    }

    @GetMapping
    public List<String> getTable(){
        return privateSpyService.getTable();
    }
}
