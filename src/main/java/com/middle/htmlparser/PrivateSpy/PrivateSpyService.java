package com.middle.htmlparser.PrivateSpy;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class PrivateSpyService {
    public PrivateSpyRepository privateSpyRepository;

    @Autowired
    public PrivateSpyService(PrivateSpyRepository privateSpyRepository) throws IOException {
        this.privateSpyRepository = privateSpyRepository;
    }

    public List<PrivateSpy> getSuperSpies(){
        return privateSpyRepository.findAll();
    }

    public Optional<PrivateSpy> getSuperSpy(String domain){
        return privateSpyRepository.findSpyByDomain(domain);
    }

    public void addSpy(String domain) throws JSONException, IOException {
        PrivateSpy privateSpy = new PrivateSpy();
        privateSpy.setDomain(domain);
        Optional<PrivateSpy> spyOptional = privateSpyRepository.findSpyByDomain(domain);
        if (spyOptional.isPresent()){
            privateSpy.wrap(spyOptional.get());
        } else {
            int id = privateSpy.getId();
            privateSpy.setId(PrivateSpy.num_inst++);
            privateSpy.deleteInfo();
            privateSpy.findAll();
        }
        privateSpyRepository.save(privateSpy);
    }

    public void deleteSpyByID(Integer spyID) {
        if (!privateSpyRepository.existsById(spyID)){
            throw new IllegalStateException("spy with this" + spyID + " does not exists");
        }
        privateSpyRepository.deleteById(spyID);
    }

    public void deleteSpyByDomain(String domain) {
        if (privateSpyRepository.findSpyByDomain(domain).isPresent()){
            throw new IllegalStateException("spy with this" + domain + " does not exists");
        }
        privateSpyRepository.deleteSpyByDomain(domain);
    }
}
