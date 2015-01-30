package com.abvarun226.NetworkingDemo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by bharghav on 1/30/15.
 */
public class HttpURLConnectionDemo1 {
    public static void main(String... args) throws Exception {
        URL hp = new URL("http://www.google.com");
        HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();

        System.out.println("Request Method : " + hpCon.getRequestMethod());
        System.out.println("Response Code  : " + hpCon.getResponseCode());
        System.out.println("Response Msg   : " + hpCon.getResponseMessage());

        Map<String, List<String>> hdrMap = hpCon.getHeaderFields();
        for (Map.Entry<String,List<String>> temp : hdrMap.entrySet()) {
            System.out.println(temp.getKey() + " : " + temp.getValue());
        }
    }
}
