package com.middle.htmlparser.Chain;

import com.middle.htmlparser.Finder;
import com.middle.htmlparser.PrivateSpy.PrivateSpy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetAddress implements Chain{
    private String address = "";
    private Chain nextInChain;
    @Override
    public void setNextChain(Chain chain) {
        nextInChain = chain;
    }

    @Override
    public void search(PrivateSpy spy) {
        String contain = spy.getDocument().outerHtml();
        Pattern pattern = Pattern.compile("вул\\. .*, [0-9]*");
        Matcher match = pattern.matcher(contain);
        if (match.find()) {
            address = match.group(0);
        }
        else {
            Finder f = new Finder();
        }
    }
}
