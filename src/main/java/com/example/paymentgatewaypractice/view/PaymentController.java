package com.example.paymentgatewaypractice.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {

	// 결제 성공 페이지 이동
	@GetMapping("/success")
	public String successPage() {
		return "success"; // templates/success.html
	}

	// 결제 실패 페이지 이동
	@GetMapping("/fail")
	public String failPage() {
		return "fail"; // templates/fail.html
	}
}