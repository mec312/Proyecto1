package com.project.credit.bussiness.impl;

import com.project.credit.bussiness.CreditService;
import com.project.credit.dao.CreditDao;
import com.project.credit.internal.BaseModel;
import com.project.credit.model.Credit;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreditServiceImpl implements CreditService {

    @Autowired
    private final CreditDao creditDao;

    @Override
    public Flux<Credit> findAllCredit() {
        return creditDao.findAllCredit();
    }

    @Override
    public ResponseEntity<Mono<Credit>> addCredit(double mount, int fee, BaseModel type, String outlay_date){
        return validaRespuesta(creditDao.addCredit(mount, fee, type, outlay_date));
    }

    private ResponseEntity<Mono<Credit>> validaRespuesta(Credit cred) {
        return (cred!=null)
                ? ResponseEntity.ok(Mono.just(cred))
                : ResponseEntity.noContent().build();
    }

}
