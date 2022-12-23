package com.techtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtest.domain.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {
}
