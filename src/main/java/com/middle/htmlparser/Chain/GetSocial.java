package com.middle.htmlparser.Chain;

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
    public String search() {
//        there is a problem because
//        after searching for FB and Twitter links
//        we'll end up having two strings

//        String twitterLink = getTW.search(doc);
//        String fbLink = getFB.search(doc);
        return null;
    }
}
