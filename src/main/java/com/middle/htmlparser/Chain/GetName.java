package com.middle.htmlparser.Chain;

import com.middle.htmlparser.PrivateSpy.PrivateSpy;

public class GetName implements Chain {
    private Chain nextInChain;

    @Override
    public void setNextChain(Chain chain) {
        nextInChain = chain;
    }

    @Override
    public String search(PrivateSpy spy) {
        return null;
    }
}
