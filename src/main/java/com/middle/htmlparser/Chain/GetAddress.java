package com.middle.htmlparser.Chain;

public class GetAddress implements Chain{
    private Chain nextInChain;
    @Override
    public void setNextChain(Chain chain) {
        nextInChain = chain;
    }

    @Override
    public String search() {
//        implement logic of searching for address
        return null;
    }
}
