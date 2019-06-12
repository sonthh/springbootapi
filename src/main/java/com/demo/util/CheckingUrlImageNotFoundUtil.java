package com.demo.util;

import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckingUrlImageNotFoundUtil {
    public static void main(String[] args) throws IOException {
        System.out.println(checkUrlImage("http://img.tophinh.com/img/2013/02/hot-girl-korea-cuc-xinh-img.tophinh.com-16-2-6-230x142.jpg"));
    }

    public static boolean checkUrlImage(String url) {
        try {
            URL u = new URL(url);
            HttpURLConnection huc = (HttpURLConnection) u.openConnection();
            huc.setRequestMethod("GET");
            huc.connect();
            return huc.getResponseCode() != HttpStatus.NOT_FOUND.value();
        } catch (Exception e) {

        }
        return false;
    }
}
