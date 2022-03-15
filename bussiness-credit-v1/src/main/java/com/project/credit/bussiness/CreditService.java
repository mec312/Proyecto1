package com.project.credit.bussiness;

import com.project.credit.internal.BaseModel;
import com.project.credit.model.Credit;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {
    Flux<Credit> findAllCredit();
    ResponseEntity<Mono<Credit>> addCredit(double mount, int fee, BaseModel type, String outlay_date);
}
