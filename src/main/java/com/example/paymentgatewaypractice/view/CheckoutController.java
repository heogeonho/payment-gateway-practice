package com.example.paymentgatewaypractice.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {

	// Checkout 페이지 이동
	@GetMapping("/")
	public String checkoutPage() {
		return "checkout"; // templates/checkout.html
	}

}
