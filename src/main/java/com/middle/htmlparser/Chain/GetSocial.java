package com.middle.htmlparser.Chain;

import com.middle.htmlparser.PrivateSpy.PrivateSpy;
import com.middle.htmlparser.Social.GetFacebook;
import com.middle.htmlparser.Social.GetTwitter;
import org.json.JSONException;

import java.io.IOException;

public class GetSocial implements Chain{
    private GetFacebook getFB = new GetFacebook();
    private GetTwitter getTW = new GetTwitter();
    private Chain nextInChain;
    @Override
    public void setNextChain(Chain chain) {
        nextInChain = chain;
    }

    @Override
    public void search(PrivateSpy spy) throws JSONException, IOException {
        getFB.search(spy.getDocument());
        String fb_url = getFB.getFacebook_url();
        spy.setFacebookUrl(fb_url);
        getTW.search(spy.getDocument());
        String tw_url = getTW.getTwitter_url();
        spy.setTwitterUrl(tw_url);
        nextInChain.search(spy);
    }
}
