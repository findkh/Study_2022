package com.hyuncode.cafe24.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class cafe24 {

  @SuppressWarnings("unchecked")
  @RequestMapping(value="/getAuthorizeCode")
  public String getAuthorizeCode() {

    try {

      String url = "url";

      URL obj = new URL(url);
      HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
      conn.setReadTimeout(5000);
      conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
      conn.addRequestProperty("User-Agent", "Mozilla");
      conn.addRequestProperty("Referer", "google.com");

      System.out.println("Request URL ... " + url);

      boolean redirect = false;

      // normally, 3xx is redirect
      int status = conn.getResponseCode();
      if (status != HttpURLConnection.HTTP_OK) {
        if (status == HttpURLConnection.HTTP_MOVED_TEMP
            || status == HttpURLConnection.HTTP_MOVED_PERM
            || status == HttpURLConnection.HTTP_SEE_OTHER)
          redirect = true;
      }

      System.out.println("Response Code ... " + status);

      if (redirect) {

        // get redirect url from "location" header field
        String newUrl = conn.getHeaderField("Location");

        // get the cookie if need, for login
        String cookies = conn.getHeaderField("Set-Cookie");

        // open the new connnection again
        conn = (HttpURLConnection) new URL(newUrl).openConnection();
        conn.setRequestProperty("Cookie", cookies);
        conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
        conn.addRequestProperty("User-Agent", "Mozilla");
        conn.addRequestProperty("Referer", "google.com");

        System.out.println("Redirect to URL : " + newUrl);

      }

      BufferedReader in = new BufferedReader(
          new InputStreamReader(conn.getInputStream()));
      String inputLine;
      StringBuffer html = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
        html.append(inputLine);
        html.append("\r\n");
      }
      in.close();

      System.out.println("URL Content... \r\n" + html.toString());

      return (html.toString());


    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;

  }

}

