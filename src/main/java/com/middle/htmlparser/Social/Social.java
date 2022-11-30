package com.middle.htmlparser.Social;

import org.jsoup.nodes.Document;

public interface Social {
//    implementing strategy pattern for searching
//    Twitter & FB links
    String search(Document doc);
}
