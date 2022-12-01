package com.middle.htmlparser.PrivateSpy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PrivateSpyService {
    public PrivateSpyRepository privateSpyRepository;

    @Autowired
    public PrivateSpyService(PrivateSpyRepository privateSpyRepository){
        this.privateSpyRepository = privateSpyRepository;
    }

    public List<PrivateSpy> getSuperSpies(){
        return privateSpyRepository.findAll();
    }

    public void addSpy(PrivateSpy spy) {

        Optional<PrivateSpy> spyOptional = privateSpyRepository.findSpyById(spy.getId());
        if (spyOptional.isPresent()){
            throw new IllegalStateException("flower with this Id present");
        }
        privateSpyRepository.save(spy);
    }

    public void deleteSpy(Integer spyID) {
        if (!privateSpyRepository.existsById(spyID)){
            throw new IllegalStateException("spy with this" + spyID + " does not exists");
        }
        privateSpyRepository.deleteById(spyID);
    }
}
