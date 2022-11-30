package com.middle.htmlparser.Chain;

public class GetName implements Chain {
    private Chain nextInChain;

    @Override
    public void setNextChain(Chain chain) {
        nextInChain = chain;
    }

    @Override
    public String search() {
//        implement logic of searching domain name(probably another class)
        return null;
    }
}
