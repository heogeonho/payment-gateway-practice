package com.example.paymentgatewaypractice.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequestDto {
	private String paymentKey;
	private String orderId;
	private BigDecimal amount;
}