package com.middle.htmlparser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetTwitter implements Social{
    String twitter_url = "";
    @Override
    public String search(Document doc) {
        Elements hrefs = doc.select("a[href^=https://]");
        Element hrefTwitter= hrefs.select("a[href^=https://twitter]").first();
        String data = String.valueOf(hrefTwitter.attributes());
        Pattern pattern = Pattern.compile("href=\"(.*?)\"");
        Matcher match = pattern.matcher(data);
        if (match.find()) {
            twitter_url = match.group(1);
        }
        return twitter_url;
    }

}
