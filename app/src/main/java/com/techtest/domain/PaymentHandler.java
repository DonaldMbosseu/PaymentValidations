package com.techtest.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.techtest.domain.models.Account;
import com.techtest.domain.models.Payment;
import com.techtest.repositories.AccountRepository;
import com.techtest.repositories.PaymentRepository;
import com.techtest.util.ErrorType;

@Service
public class PaymentHandler {

  @Autowired
  private PaymentRepository paymentRepo;

  @Autowired
  private AccountRepository accountRepo;

  public void handlePayment(Payment payment) {
    HttpStatus statusCode = PaymentValidator.validatePayment(payment);

    if (payment.getType().equals("online") && !statusCode.is2xxSuccessful()) {
      ErrorLogger.logError(payment, ErrorType.NETWORK.toString(), statusCode.getReasonPhrase());
    } else {
      try {
        payment = this.paymentRepo.save(payment);
        Account account = this.accountRepo.findById(payment.getAccountId()).get();
        account.setLastPaymentDate(payment.getCreatedOn());
        this.accountRepo.save(account);
      } catch (Exception e) {
        ErrorLogger.logError(payment, ErrorType.DATABASE.toString(), e.getMessage());
      }
    }
  }
}
