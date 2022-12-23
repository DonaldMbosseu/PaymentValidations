package com.techtest.domain.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

import org.json.JSONObject;

@Entity
@Table(name = "payments")
public class Payment {
  @Id
  @Column(name = "payment_id")
  private String id;

  @Column(name = "account_id")
  private int accountId;

  @Column(name = "payment_type")
  private String type;

  @Column(name = "credit_card")
  private String creditCard;

  @Column(name = "amount")
  private int amount;

  @Column(name = "created_on")
  private Date createdOn;

  public Payment(String data) {
    JSONObject obj = new JSONObject(data);

    this.id = obj.getString("payment_id");
    this.accountId = obj.getInt("account_id");
    this.type = obj.getString("payment_type");
    this.creditCard = obj.getString("credit_card");
    this.amount = obj.getInt("amount");
    this.createdOn = new Date(System.currentTimeMillis());
  }

  public Payment() {
  }

  public String getId(){
    return id;
  }

  public Integer getAccountId() {
    return accountId;
  }

  public String getType() {
    return type;
  }

  public String getCreditCard() {
    return creditCard;
  }

  public Integer getAmount() {
    return amount;
  }

  public Date getCreatedOn() {
    return createdOn;
  }
}
