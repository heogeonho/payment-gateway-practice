package com.example.paymentgatewaypractice.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.paymentgatewaypractice.dto.PaymentRequestDto;
import com.example.paymentgatewaypractice.service.TossPaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/toss")
@RequiredArgsConstructor
public class TossPaymentController {

	private final TossPaymentService tossPaymentService;

	@PostMapping("/confirm")
	public ResponseEntity<?> confirmPayment(
		@RequestBody PaymentRequestDto paymentRequestDto) {

		// TossPaymentsService 호출
		ResponseEntity<?> responseEntity =
			tossPaymentService.confirmPayment(paymentRequestDto.getPaymentKey(), paymentRequestDto.getOrderId(), paymentRequestDto.getAmount())
			.block(); // WebClient 호출 결과를 동기적으로 처리

		return responseEntity;
	}

}