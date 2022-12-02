package com.middle.htmlparser.PrivateSpy;

import com.middle.htmlparser.Chain.Chain;
import com.middle.htmlparser.Chain.ChainWrapper;
import com.middle.htmlparser.Chain.GetName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@Setter @Getter @ToString
@RestController
@Table @Entity
public class PrivateSpy {
    @Id
    @GeneratedValue
    private int id;

    public void setDomain(String domain) throws IOException {
        this.domain = domain;
        this.document = Jsoup.connect(this.domain).get();
    }

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
    @Transient
    private Document document;

    public PrivateSpy(int id, String domain, String name, String address, String twitterUrl, String facebookUrl, String logo, String icon, String employees) {
        this.id = id;
        this.domain = domain;
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
