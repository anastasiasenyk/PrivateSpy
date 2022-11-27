package com.middle.htmlparser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetFacebook implements Social{
    String facebook_url = "";
    @Override
    public String search(Document doc) {
        Elements hrefs = doc.select("a[href^=https://]");
        Element hrefFacebook = hrefs.select("a[href^=https://www.facebook]").first();
        String data = String.valueOf(hrefFacebook.attributes());
        Pattern pattern = Pattern.compile("href=\"(.*?)\"");
        Matcher match = pattern.matcher(data);
        if (match.find()) {
            facebook_url = match.group(1); // this variable should contain the link URL
        }
        return facebook_url;
    }
}
