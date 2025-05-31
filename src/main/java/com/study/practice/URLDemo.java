package com.study.practice;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class URLDemo {
   public static void main(String args[]) throws IOException {
      //Instantiating the URL class
      URL url = new URL("https://kmc.kaltura.com/index.php/kmcng/content/entries/entry/1_e2ngq7dv/metadata");
      //Retrieving the contents of the specified page
      Scanner sc = new Scanner(url.openStream());
      //Instantiating the StringBuffer class to hold the result
      StringBuffer sb = new StringBuffer();
      while(sc.hasNext()) {
         sb.append(sc.next());
         //System.out.println(sc.next());
      }
      //Retrieving the String from the String Buffer object
      String result = sb.toString();
      
      result = result.replaceAll("<[^>]*>", "");
      System.out.println("Contents of the web page: "+result);
   }
}