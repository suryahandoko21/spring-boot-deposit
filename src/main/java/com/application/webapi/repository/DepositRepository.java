package com.application.webapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.application.webapi.model.Deposit;

public interface DepositRepository extends MongoRepository<Deposit,String> {
    
}
