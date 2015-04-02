package com.carnote.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class HttpUtils {
	 public static String get(String strUrl) {
		    HttpURLConnection conn = null;
		    URL url;
		    StringBuilder sb = new StringBuilder();
		    try {
		      url = new URL(strUrl);
		      conn = (HttpURLConnection) url.openConnection();
		      conn.setReadTimeout(1000 * 60);
		      conn.setConnectTimeout(1000 * 30);
		      conn.setRequestMethod("GET");
		      conn.setDoInput(true);
		      conn.connect();
		      switch (conn.getResponseCode()) {
		        case 200:
		          try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
		            String str = null;
		            sb.setLength(0);
		            while ((str = br.readLine()) != null) {
		              sb.append(str);
		            }
		          }
		          break;
		        default:
		          try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream()))) {
		            String str = null;
		            sb.setLength(0);
		            while ((str = br.readLine()) != null) {
		              sb.append(str);
		            }
		          }
		      }
		      return sb.toString();
		    } catch (Exception e) {
		      
		        throw new RuntimeException(e);
		      
		    } finally {
		      if (conn != null) {
		        conn.disconnect();
		      }
		    }
		  }
	 
	 
	 
	 
	 
	 	
	 
	 
	 
	 
}
