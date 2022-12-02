package com.middle.htmlparser.Social;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetFacebook implements Social {
    private String facebook_url = "";

    public String getFacebook_url() {
        return facebook_url;
    }

    @Override
    public void search(Document doc) {
        Elements hrefs = doc.select("a[href^=https://]");
        Element hrefFacebook = hrefs.select("a[href^=https://www.facebook]").first();
        String data = String.valueOf(hrefFacebook.attributes());
        Pattern pattern = Pattern.compile("href=\"(.*?)\"");
        Matcher match = pattern.matcher(data);
        if (match.find()) {
            this.facebook_url = match.group(1);
        }
    }
}
