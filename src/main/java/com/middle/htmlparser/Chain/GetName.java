package com.middle.htmlparser.Chain;

import com.middle.htmlparser.PrivateSpy.PrivateSpy;
import org.json.JSONException;
import org.jsoup.select.Elements;

import java.io.IOException;


public class GetName implements Chain {
    private Chain nextInChain;

    @Override
    public void setNextChain(Chain chain) {
        nextInChain = chain;
    }

    @Override
    public void search(PrivateSpy spy) throws JSONException, IOException {
        Elements hrefs = spy.getDocument().select("a[href^=https://]");
        try {
            spy.setName(spy.getDocument().title());
        }
        catch (Exception ex) {
            return;
        }finally {
            nextInChain.search(spy);
        }
    }
}
