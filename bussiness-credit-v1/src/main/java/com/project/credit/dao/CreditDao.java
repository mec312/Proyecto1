package com.project.credit.dao;

import com.project.credit.internal.BaseModel;
import com.project.credit.model.Credit;
import reactor.core.publisher.Flux;

public interface CreditDao {
    Flux<Credit> findAllCredit();
    Credit addCredit(double mount, int fee, BaseModel type, String outlay_date);
}
