package com.techtest.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.techtest.domain.ErrorLogger;
import com.techtest.domain.PaymentHandler;
import com.techtest.domain.models.Payment;
import com.techtest.util.ErrorType;

@Component
public class KafkaListeners {


  @Autowired
  PaymentHandler paymentHandler;;

  @KafkaListener(
    topics = "${spring.kafka.topic1}",
    groupId = "groupId"
  )
  void onlineListener(String data) {
    Payment payment = new Payment(data);
    try {
      paymentHandler.handlePayment(payment);
    } catch(Exception e){
      ErrorLogger.logError(payment, ErrorType.REST.toString(), e.getMessage());
    }
  }

  @KafkaListener(
    topics = "${spring.kafka.topic2}",
    groupId = "groupId"
  )
  void offlineListener(String data) {
    Payment payment = new Payment(data);
    try {
      paymentHandler.handlePayment(payment);
    } catch (Exception e) {
      ErrorLogger.logError(payment, ErrorType.REST.toString(), e.getMessage());
    }
  }

}
