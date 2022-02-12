package com.sample.callapi;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;


@RestController
public class Search {
	private String URL = "https://localhost:{port}/demo/iserver/secdef/search";

	public void execute (String port, String p1, Boolean p2, String p3) throws URISyntaxException {

		SearchEntity param = new SearchEntity(p1, p2, p3);

		RestTemplate restTemplate = new RestTemplate();
	    // 1. エンドポイントからUriComponentsBuilderを作成する.
	    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL);
	    // 2. クエリパラメータを設定して文字列化する.
	    //String uri = builder.queryParam("aaa", 123).toUriString();
	    String uri = builder.port(Integer.valueOf( port)).toUriString();
    	// 3. パラメータを設定したURLからRequestEntityを作成する.
    	RequestEntity<SearchEntity> request = RequestEntity
    	        .post(new URI(uri))
    	        .accept(MediaType.APPLICATION_JSON)
    	        .body(param);


	     // 4. exchangeでAPIを呼び出す.
	    ResponseEntity<JsonNode> response = restTemplate.exchange(request, JsonNode.class);
	    JsonNode Node = response.getBody();


	}

	@Component
	class SearchEntity {
	    //id
	    private String symbol ;
	    //名前
	    private Boolean name;
	    //コメント
	    private String sectype; //"STK"

	    public SearchEntity(String p1, Boolean p2, String p3) {

	    	this.symbol = p1;
	    	this.name = p2;
	    	this.sectype = p3;

	    }

	    public SearchEntity() {

	    	this.symbol = "";
	    	this.name = false;
	    	this.sectype = "STK";

	    }
	}
}
