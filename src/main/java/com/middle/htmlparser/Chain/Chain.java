package com.middle.htmlparser.Chain;

import com.middle.htmlparser.PrivateSpy.PrivateSpy;
import org.json.JSONException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface Chain {
    void setNextChain(Chain chain);
    void search(PrivateSpy spy) throws JSONException, IOException;
}
