package com.example.demo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

@Service
public class ApiService {

	 public String getCulturalData() {
	        try {
	            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6480000/gyeongnamcultural/gyeongnamculturallist");
	            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=서비스키");
	            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=1");
	            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=10");
	            urlBuilder.append("&" + URLEncoder.encode("resultType", "UTF-8") + "=json");

	            URL url = new URL(urlBuilder.toString());
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");

	            BufferedReader rd;
	            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            } else {
	                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	            }

	            StringBuilder sb = new StringBuilder();
	            String line;
	            while ((line = rd.readLine()) != null) {
	                sb.append(line);
	            }

	            rd.close();
	            conn.disconnect();
	            return sb.toString();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	 
	 
	 
}
