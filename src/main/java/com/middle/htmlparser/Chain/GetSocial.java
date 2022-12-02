package com.middle.htmlparser.Chain;

import com.middle.htmlparser.PrivateSpy.PrivateSpy;
import com.middle.htmlparser.Social.GetFacebook;
import com.middle.htmlparser.Social.GetTwitter;

public class GetSocial implements Chain{
    private GetFacebook getFB;
    private GetTwitter getTW;
    private Chain nextInChain;
    @Override
    public void setNextChain(Chain chain) {
        nextInChain = chain;
    }

    @Override
    public void search(PrivateSpy spy) {
        getFB = new GetFacebook();
        getFB.search(spy.getDocument());
        String fb_url = getFB.getFacebook_url();
        getTW = new GetTwitter();
        getTW.search(spy.getDocument());
        String tw_url = getTW.getTwitter_url();
    }
}
