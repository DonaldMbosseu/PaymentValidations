package com.techtest.domain;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.techtest.domain.models.Error;
import com.techtest.domain.models.Payment;

public class ErrorLogger {

  public static void logError(Payment payment, String type, String description) {
    Error error = new Error(payment.getId(), type, description);
    String url = "http://localhost:9000/log";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    Map<String, Object> body = new HashMap<>();
    body.put("payment_id", error.getPaymentId());
    body.put("error_type", error.gettype());
    body.put("error_description", error.getDescription());

    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    RestTemplate restTemplate = restTemplateBuilder.build();

    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

    try {
      restTemplate.postForEntity(url, entity,
          Error.class);
    } catch (Exception e) {
        System.out.println(e);
    }
  }
}
