package com.example.paymentgatewaypractice.config;

import org.springframework.web.reactive.function.client.WebClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WebClientConfig {

	@Value("${PSP.toss.secretkey}")
	private String tossSecretKey;

	@Value("${PSP.toss.url}")
	private String tossUrl;

	@Bean
	public WebClient tossPaymentsWebClient() {
		String basicAuthHeader = "Basic " + encodeToBase64(tossSecretKey + ":");

		return WebClient.builder()
			.baseUrl(tossUrl)
			.defaultHeader("Authorization", basicAuthHeader)
			.defaultHeader("Content-Type", "application/json")
			.build();
	}

	private String encodeToBase64(String value) {
		return java.util.Base64.getEncoder().encodeToString(value.getBytes());
	}
}