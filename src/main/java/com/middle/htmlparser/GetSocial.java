package com.middle.htmlparser;

import org.jsoup.nodes.Document;

public class GetSocial {
    String twitter_link = "";
    String facebook_link = "";
    public void search(Document doc) {
        twitter_link = new GetTwitter().search(doc);
        System.out.println(twitter_link);
        facebook_link = new GetFacebook().search(doc);
        System.out.println(facebook_link);
    }
}
