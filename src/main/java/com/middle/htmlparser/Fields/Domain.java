package com.middle.htmlparser.Fields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

@Getter @Setter
@NoArgsConstructor

public class Domain {
    private String domainName;
    private String url;

    public void setDomain(String domain) {
        this.domainName = domain.replaceAll("http(s)?://|www\\.|/.*", "");
    }

    public void setUrl() {
        this.url = "https://www." + domainName;
    }

    public Domain (String domain) {
        this.setDomain(domain);
        this.setUrl();
    }

    public Document jsoupConnect() throws IOException {
        return Jsoup.connect(this.url).get();
    }
}
