package com.middle.htmlparser.Chain;

import com.middle.htmlparser.PrivateSpy.PrivateSpy;

public class GetAddress implements Chain{
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
