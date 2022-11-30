package com.middle.htmlparser.Chain;

import com.middle.htmlparser.Media.GetIcon;
import com.middle.htmlparser.Media.GetLogo;

public class GetMedia implements Chain{
    private GetIcon getIcon;
    private GetLogo getLogo;
    private Chain nextInChain;
    @Override
    public void setNextChain(Chain chain) {
        nextInChain = chain;
    }

    @Override
    public String search() {
//        String logo = getLogo.search(doc);
//        String icon = getIcon.search(doc);
        return null;
    }
}
