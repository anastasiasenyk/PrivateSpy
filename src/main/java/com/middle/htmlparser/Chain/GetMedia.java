package com.middle.htmlparser.Chain;

import com.middle.htmlparser.Media.GetIcon;
import com.middle.htmlparser.Media.GetLogo;
import com.middle.htmlparser.PrivateSpy.PrivateSpy;
import org.json.JSONException;

import java.io.IOException;

public class GetMedia implements Chain{
    private GetIcon getIcon;
    private GetLogo getLogo;
    private Chain nextInChain;
    @Override
    public void setNextChain(Chain chain) {
        nextInChain = chain;
    }

    @Override
    public void search(PrivateSpy spy) throws JSONException, IOException {
        getIcon = new GetIcon();
        getLogo = new GetLogo();
        spy.setLogo(getLogo.search(spy));
        spy.setIcon(getIcon.search(spy));

    }

}
