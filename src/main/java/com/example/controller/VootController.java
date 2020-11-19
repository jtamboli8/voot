package com.example.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.VoteModel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class VootController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private RetryTemplate retryTemplate;
	
	private static final String[] emailProviders = {"gmail", "hotmail","yahoo","icloud"};
	
	@GetMapping(path="/vote")
	public void controller() {
		for(int i=0; i<10000; i++) {
			try {
				VoteModel voteModel = new VoteModel();
				voteModel.setCategoryId("");
				voteModel.setCategoryName("");
				voteModel.setContestantId("df95dda0-06ff-11eb-80dd-2d044fe699cd");
				voteModel.setContestantName("Nikki Tamboli");
				voteModel.setCycleId(UUID.randomUUID().toString());
				voteModel.setIp(getRandomIP());
				voteModel.setLoginProvider("Traditional");
				voteModel.setShowId("ec324230-02f2-11eb-bf8c-d128fef771cc");
				voteModel.setShowName("Bigg Boss 14");
				voteModel.setUserEmail(RandomStringUtils.random(10, true, true)+"@"+emailProviders[new Random().nextInt(emailProviders.length)]+".com");
				voteModel.setUserId(UUID.randomUUID().toString());
				voteModel.setUserName(RandomStringUtils.random(10, true, false));
				voteModel.setRegion("in");
				String json = mapper.writeValueAsString(voteModel);
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
				retryTemplate.execute(new RetryCallback<Void, RuntimeException>() {

					@Override
					public Void doWithRetry(RetryContext context) throws RuntimeException {
						ResponseEntity<String> response = restTemplate.exchange("https://voting-api.voot.com/v1/addvote", 
								HttpMethod.POST, httpEntity, String.class);
						System.out.println(response);
						return null;
					}
					
				});
				Thread.sleep(new Random().nextInt(499) + 1);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private String getRandomIP() {
		Random r = new Random();
		return r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
	}
	
}
