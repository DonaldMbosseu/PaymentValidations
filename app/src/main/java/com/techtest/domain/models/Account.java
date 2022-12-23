package com.techtest.domain.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
  @Id
  @Column(name = "account_id")
  private int id;

  @Column(name = "last_payment_date")
  private Date lastPaymentDate;

  public void setLastPaymentDate(Date lastPaymentDate) {
    this.lastPaymentDate = lastPaymentDate;
  }

  public int getId() {
    return this.id;
  }
}
