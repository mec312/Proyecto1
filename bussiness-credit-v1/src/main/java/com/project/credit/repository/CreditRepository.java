package com.project.credit.repository;

import com.project.credit.model.Credit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreditRepository extends MongoRepository<Credit, String> {

}
