package com.tli.consumer.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tli.consumer.domain.entities.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{
    
}
