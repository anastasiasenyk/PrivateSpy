package com.middle.htmlparser.Chain;

import com.middle.htmlparser.Media.GetIcon;
import com.middle.htmlparser.Media.GetLogo;
import com.middle.htmlparser.PrivateSpy.PrivateSpy;

public class GetMedia implements Chain{
    private GetIcon getIcon;
    private GetLogo getLogo;
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
