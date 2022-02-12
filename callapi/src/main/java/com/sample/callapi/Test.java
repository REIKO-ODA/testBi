package com.sample.callapi;

import java.net.URI;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



public class Test {

	private String  URL = "https://newsapi.org/v2/top-headlines?country=jp&category=business&apiKey=be9a955e3f3a45078971f14d4109214b";


	public void execute () throws Exception {

		RestTemplate restTemplate = new RestTemplate();

	    URI uri = new URI(URL);

		String  resNews = restTemplate.getForObject(uri, String.class);

		ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(resNews);

            JsonNode article = node.get("articles");

            int i= 0;

            do {
            	if (article.has(i)==true) {
            		JsonNode oneA = article.get(i);
	             	System.out.println(oneA.get("title").asText());
	            	i++;
            	} else {
            		i = -1;
            	}
            }	while (i > -1 );

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

	}

}
