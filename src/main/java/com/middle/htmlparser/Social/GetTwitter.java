package com.middle.htmlparser.Social;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetTwitter implements Social{
    private String twitter_url = "";

    public String getTwitter_url() {
        return twitter_url;
    }



    @Override
    public void search(Document doc) {
        Elements hrefs = doc.select("a[href^=https://]");
        Element hrefTwitter= hrefs.select("a[href^=https://twitter]").first();
        String data = String.valueOf(hrefTwitter.attributes());
        Pattern pattern = Pattern.compile("href=\"(.*?)\"");
        Matcher match = pattern.matcher(data);
        try {
            if (match.find()) {
                this.twitter_url = match.group(1);
            }
        }
        catch (Exception ex) {
            return;
        }
    }
}
