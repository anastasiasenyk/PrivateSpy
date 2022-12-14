package com.middle.htmlparser.PrivateSpy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.middle.htmlparser.Chain.Chain;
import com.middle.htmlparser.Chain.ChainWrapper;
import com.middle.htmlparser.Chain.GetName;
import com.middle.htmlparser.Fields.Domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONException;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@Setter @Getter @ToString
@RestController
@Table @Entity
public class PrivateSpy {
    public static int num_inst=5;
    @Id
    @GeneratedValue
    private int id;
    @Transient
    @JsonIgnore
    private Domain domain;
    private String domainName;
    private String name;
    private String address;
    private String twitterUrl;
    private String facebookUrl;
    private String logo;
    private String icon;
    private String employees;
    @Transient
    @JsonIgnore
    private Chain firstChain;
    @Transient
    @JsonIgnore
    private ChainWrapper chainWrapper;
    @Transient
    @JsonIgnore
    private Document document;

    public void setDomain(String domain) throws IOException {
        this.domain = new Domain(domain);
        this.domainName = this.domain.getDomainName();
        this.document = this.domain.jsoupConnect();
    }

    public PrivateSpy(int id, String domain, String name, String address, String twitterUrl, String facebookUrl, String logo, String icon, String employees) {
        this.id = id;
        this.domain.setDomain(domain);
        this.name = name;
        this.address = address;
        this.twitterUrl = twitterUrl;
        this.facebookUrl = facebookUrl;
        this.logo = logo;
        this.icon = icon;
        this.employees = employees;
    }



    public PrivateSpy() throws IOException {

        this.firstChain = new GetName();
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

    void findAll() throws JSONException, IOException {
        firstChain.search(this);
    }

    void updateInfo() {
    }

    void deleteInfo() {
        this.domain = new Domain();
        this.name = null;
        this.address = null;
        this.twitterUrl = null;
        this.facebookUrl = null;
        this.logo = null;
        this.icon = null;
        this.employees = null;
    }
}