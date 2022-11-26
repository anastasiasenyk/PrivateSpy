package com.middle.htmlparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HtmlparserApplication {


	
	public static void main(String[] args) {
		final String url = "https://toscrape.com/";
		try{
			final Document document = Jsoup.connect(url).timeout(10000).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36").get();
			for( Element row: document.select("table.table.table-hover tr")){
				final String ticker = row.select("td:nth-of-type(2)").text();
				System.out.println(ticker);
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		SpringApplication.run(HtmlparserApplication.class, args);
	}

}
