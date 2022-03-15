package com.project.credit.dao.impl;

import com.project.credit.dao.CreditDao;
import com.project.credit.internal.BaseModel;
import com.project.credit.model.Credit;
import com.project.credit.repository.CreditRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CreditDaoImpl implements CreditDao {

    @Autowired
    private CreditRepository repository;

    @Override
    public Flux<Credit> findAllCredit() {
        return Flux.fromIterable(repository.findAll());
    }

    @Override
    public Credit addCredit(double mount, int fee, BaseModel type, String outlay_date) {
        Credit cred = repository.save(Credit.builder().mount(mount).fee(fee).type(type).outlay_date(outlay_date).build());
        return  cred;
    }
}
