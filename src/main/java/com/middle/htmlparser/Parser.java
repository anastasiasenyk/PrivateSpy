package com.middle.htmlparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser {
    public static void main(String[] args) throws IOException {
        String a[] = {"https://medcenter.lviv.ua/", "https://khmilclinic.com.ua/", "https://lpnu.ua/", "https://kpi.ua/", "https://lnu.edu.ua/en/", "https://dou.ua/", "https://nmuofficial.com/"};
        final String url = "https://kubg.edu.ua/";
        final Document document = Jsoup.connect(url).get();
        Finder g = new Finder();

//        String address = "";

//        try {
//            address = new GetAddress().search(document);
//            System.out.println(address);
//
//        }
//        catch (Exception ex) {
//            System.out.println("There is no Twitter url :(");
//        }
//        try {
//
//        }
//        catch (Exception ex) {
//            System.out.println("There is no Facebook url :(");
//        }
//    }
    }
}
