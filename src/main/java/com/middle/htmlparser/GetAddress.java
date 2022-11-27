package com.middle.htmlparser;

import org.jsoup.nodes.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetAddress {
    String address = "";
    public void search(Document doc) {
        String contain = doc.outerHtml();
        Pattern pattern = Pattern.compile("вул\\. .*, [0-9]*");
        Matcher match = pattern.matcher(contain);
        if (match.find()) {
            address = match.group(0);
        }
    }
}
