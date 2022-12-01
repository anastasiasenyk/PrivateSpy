package com.middle.htmlparser.PrivateSpy;

import com.middle.htmlparser.Chain.Chain;
import com.middle.htmlparser.Chain.ChainWrapper;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.RestController;



@Setter @Getter @ToString
@RestController
@Table @Entity
@NoArgsConstructor
public class PrivateSpy {
    @Id
    @GeneratedValue
    private int id;
    private String domain;
    private String name;
    private String address;

    private String twitterUrl;
    private String facebookUrl;

    private String logo;
    private String icon;

    private String employees;
    @Transient
    private Chain firstChain;
    @Transient
    private ChainWrapper chainWrapper;


    public PrivateSpy(Chain firstChain) {
        this.firstChain = firstChain;
        this.chainWrapper = new ChainWrapper(firstChain);
    }

    public void wrap(PrivateSpy spy) {
        this.id = spy.id;
        this.domain = spy.domain;
        this.name = spy.name;
        this.address = spy.address;
        this.twitterUrl = spy.twitterUrl;
        this.facebookUrl = spy.facebookUrl;
        this.logo = spy.logo;
        this.icon = spy.icon;
        this.employees = spy.employees;
    }

    void findAll() {
        firstChain.search(this);
    }

    void updateInfo() {
    }

    void deleteInfo() {
        this.domain = null;
        this.name = null;
        this.address = null;
        this.twitterUrl = null;
        this.facebookUrl = null;
        this.logo = null;
        this.icon = null;
        this.employees = null;
    }

}
