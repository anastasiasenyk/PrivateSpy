package com.middle.htmlparser;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetIcon implements GetImg {
    //    private Chain nextInChain;

    @Override
    public String search(Document document) {
        try {
//            System.out.println(document.outerHtml());
            Element href = document.select("[href~=icon]").first();
            Pattern pattern = Pattern.compile("\"/.*icon.*\"");
            assert href != null;
            Matcher matcher = pattern.matcher(href.toString());
            if (matcher.find()) {
                System.out.println(matcher.group(0));
                return matcher.group(0);
            }
            else {
                return "Not found";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return "Not found";
        }
    }

}
