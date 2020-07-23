package com.stripe.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.param.PaymentIntentCreateParams;

public class PaymentIntentTest {
	
	@Test
	public void test() throws StripeException {
		// Set your secret key. Remember to switch to your live secret key in production!
		// See your keys here: https://dashboard.stripe.com/account/apikeys
		Stripe.apiKey = "sk_test_51H6qwzLsMtG1Vxx6bEOW5j1ark5MCy17XAqvzwiWAqLzci2VkanH8YpNS6OoGFtbivvOu2nzkCyQK4X3cE0rf2VC004GywB1Y1";

		PaymentIntentCreateParams params =
		  PaymentIntentCreateParams.builder()
		    .setAmount(1000L)
		    .setCurrency("usd")
		    .addPaymentMethodType("card")
		    .setReceiptEmail("jenny.rosen@example.com")
		    .build();

		PaymentIntent paymentIntent = PaymentIntent.create(params);
		
		paymentIntent = PaymentIntent.retrieve(paymentIntent.id);
		
		System.out.println(paymentIntent);
		
		
	}
}
