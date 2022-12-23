package com.techtest.domain.models;

public class Error {
  private String paymentId;
  private String type;
  private String description;

  public Error(String paymentId, String type, String description) {
    this.paymentId = paymentId;
    this.type = type;
    this.description = description;
  }

  public Error() {
  }

  public String getPaymentId() {
    return this.paymentId;
  }

  public String gettype() {
    return this.type;
  }

  public String getDescription() {
    return this.description;
  }
}
