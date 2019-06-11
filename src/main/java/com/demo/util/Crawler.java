package com.demo.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crawler {
    public static void main(String[] args) throws IOException {
        System.out.println(getAllImage());

    }


    public static List<String> getAllImage() throws IOException {
        List<String> list = new ArrayList<>();
        Document doc = Jsoup.connect("http://tophinh.com/anh-girl-xinh").get();
        Elements listLinkPost = doc.select(".list .item .thumb");
        for (Element e : listLinkPost) {
            Document post = Jsoup.connect(e.attr("href")).get();
            Elements images = post.select(".no-content img");
            for (Element img : images) {
                list.add(img.attr("src"));
            }
        }
        return list;
    }
}
