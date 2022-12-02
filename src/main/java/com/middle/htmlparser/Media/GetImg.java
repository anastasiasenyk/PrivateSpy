package com.middle.htmlparser.Media;


import com.middle.htmlparser.PrivateSpy.PrivateSpy;
import org.json.JSONException;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;

public interface GetImg {
//    implementing strategy pattern for
//    searching logo and icon
    String search(PrivateSpy spy) throws IOException, JSONException;
}
