package com.middle.htmlparser.Chain;

import com.middle.htmlparser.PrivateSpy.PrivateSpy;
import com.middle.htmlparser.Social.GetTwitter;
import org.springframework.core.SpringVersion;

public class ChainWrapper {
    Chain firstChain;
    private static Chain getSocial = new GetSocial();
    private static Chain getMedia = new GetMedia();
    private static Chain getEmployees = new GetEmployees();
    private static Chain getAddress = new GetAddress();

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
