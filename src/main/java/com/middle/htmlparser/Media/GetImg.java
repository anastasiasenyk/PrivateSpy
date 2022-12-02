package com.middle.htmlparser.Media;


import com.middle.htmlparser.PrivateSpy.PrivateSpy;
import org.json.JSONException;

import java.io.IOException;

public interface GetImg {
//    implementing strategy pattern for
//    searching logo and icon
    String search(PrivateSpy spy) throws IOException, JSONException;
}
