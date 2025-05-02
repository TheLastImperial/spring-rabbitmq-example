package com.tli.producer.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tli.producer.domain.entities.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{
    
}
