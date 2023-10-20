package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.masai.config.GptRequest;
import com.masai.config.GptResponse;
import com.masai.model.TextGenerator;

@Service
public class TextGeneratorImpl implements TextGeneratorService {
	

	@Value("${openai.model}")
	private String model;

	@Value("${openai.api.url}")
	private String url;

	@Autowired
	private RestTemplate templete;

	public String getResponse(TextGenerator textGenrator) {
		String prompt = "I want to generate large-sized" + textGenrator.getLanguage() + textGenrator.getLanguage() + "with emojis in the description of" + textGenrator.getDescription();
		
		GptRequest req = new GptRequest(model, prompt);
		GptResponse resp = templete.postForObject(url, req, GptResponse.class);
		return resp.getChoices().get(0).getMessage().getContent();
	}

	@Override
	public String genrateText(TextGenerator textGenerator) {
		// TODO Auto-generated method stub
		return getResponse(textGenerator);
	}

}
