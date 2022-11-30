package com.middle.htmlparser.Chain;

public class GetEmployees implements Chain{
    private Chain nextInChain;
    @Override
    public void setNextChain(Chain chain) {
        nextInChain = chain;
    }

    @Override
    public String search() {
//        implement logic of searching for number of employees
        return null;
    }
}
