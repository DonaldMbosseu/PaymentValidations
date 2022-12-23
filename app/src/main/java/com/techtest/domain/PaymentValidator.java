package com.techtest.domain;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.techtest.domain.models.Payment;

public class PaymentValidator {

  public static HttpStatus validatePayment(Payment payment){
    String url = "http://localhost:9000/payment";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    Map<String, Object> body = new HashMap<>();
    body.put("payment_id", payment.getId());
    body.put("account_id", payment.getAccountId());
    body.put("payment_type", payment.getType());
    body.put("credit_card", payment.getCreditCard());
    body.put("amount", payment.getAmount());

    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    RestTemplate restTemplate = restTemplateBuilder.build();

    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
    HttpStatus statusCode = null;

    try {
      ResponseEntity<Payment> response = restTemplate.postForEntity(url, entity, Payment.class);
      statusCode = response.getStatusCode();
    } catch (HttpStatusCodeException e){
      statusCode = HttpStatus.GATEWAY_TIMEOUT;
    }

    return statusCode;
  }
}
