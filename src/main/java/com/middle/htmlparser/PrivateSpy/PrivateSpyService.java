package com.middle.htmlparser.PrivateSpy;

import com.middle.htmlparser.Chain.Chain;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class PrivateSpyService {
    public PrivateSpyRepository privateSpyRepository;
    private PrivateSpy privateSpy;

    @Autowired
    public PrivateSpyService(PrivateSpyRepository privateSpyRepository){
        this.privateSpyRepository = privateSpyRepository;
    }

    public List<PrivateSpy> getSuperSpies(){
        return privateSpyRepository.findAll();
    }

    public void addSpy(String domain) throws JSONException, IOException {
        Optional<PrivateSpy> spyOptional = privateSpyRepository.findSpyByDomain(domain);
        if (spyOptional.isPresent()){
            privateSpy.wrap(spyOptional.get());
        } else {
            int id = privateSpy.getId();
            privateSpy.setId(++id);
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
}
