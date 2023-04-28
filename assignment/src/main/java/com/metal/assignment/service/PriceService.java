package com.metal.assignment.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
    /*
    * div and class elements of price
    * div= block___2RfAT
    * class= "strong___1JlBD priceDown___2TbRQ"
    */

    public String getPrice(String url) throws Exception {
        final Document document = Jsoup.connect(url).get();

        Element priceElement = document.selectFirst("span.strong___1JlBD.priceDown___2TbRQ");
        String price = priceElement.text();

        System.out.println(price);

        return price;
    }


}
