package com.example.paymentgatewaypractice.service;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.paymentgatewaypractice.dto.PaymentRequestDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class TossPaymentService {

	private final WebClient tossPaymentsWebClient;

	public Mono<ResponseEntity<Object>> confirmPayment(String paymentKey, String orderId, BigDecimal amount) {
		return tossPaymentsWebClient.post()
			.uri("/v1/payments/confirm")
			.bodyValue(buildPaymentRequest(paymentKey, orderId, amount))
			.retrieve()
			.toEntity(Object.class);
	}

	private PaymentRequestDto buildPaymentRequest(String paymentKey, String orderId, BigDecimal amount) {
		return PaymentRequestDto.builder().paymentKey(paymentKey).orderId(orderId).amount(amount).build();
	}

}