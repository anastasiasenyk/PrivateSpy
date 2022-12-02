package com.middle.htmlparser.Chain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ChainWrapper {
    Chain firstChain;
    private static final Chain getSocial = new GetSocial();
    private static final Chain getMedia = new GetMedia();
    private static final Chain getEmployees = new GetEmployees();
    private static final Chain getAddress = new GetAddress();

    public ChainWrapper(Chain firstChain) {
        this.firstChain = firstChain;
        buildChain();
    }

    public void buildChain() {
        firstChain.setNextChain(getSocial);
        getSocial.setNextChain(getMedia);
        getMedia.setNextChain(getEmployees);
        getEmployees.setNextChain(getAddress);
    }
}
