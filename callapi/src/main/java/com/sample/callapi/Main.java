package com.sample.callapi;

import java.net.URISyntaxException;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class Main {

	  public static void main(String[] args) {
        //SpringApplication.run(App.class, args);

    	Search s = new Search();
        try {
			s.execute("5000", "AAPL", false, "STK");
		} catch (URISyntaxException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

    }
}