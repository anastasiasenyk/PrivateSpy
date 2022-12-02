package com.middle.htmlparser.Chain;

import com.middle.htmlparser.PrivateSpy.PrivateSpy;
import com.middle.htmlparser.Social.GetFacebook;
import com.middle.htmlparser.Social.GetTwitter;
import com.middle.htmlparser.Social.Social;

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
        return;
    }
}
