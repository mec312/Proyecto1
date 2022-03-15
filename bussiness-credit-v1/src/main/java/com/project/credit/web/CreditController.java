package com.project.credit.web;

import com.project.credit.bussiness.CreditService;
import com.project.credit.internal.CreditAddRequest;
import com.project.credit.model.Credit;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    private CreditService service;

    @GetMapping(value = "/findAll")
    public Flux<Credit> findAllCredit() {
        return service.findAllCredit();
    }
    @PostMapping(value = "/addCredit")
    public HttpStatus addCredit(@Valid @RequestBody CreditAddRequest request){
        service.addCredit(request.getMount(), request.getFee(), request.getType(), request.getOutlay_date());
        try{
            log.info("ENTROOOOO > "+request.toString());
            return HttpStatus.CREATED;
        }catch(Exception er) {
            String erro = er.getMessage();
            log.info(erro);
            return HttpStatus.OK;
        }

    }

}
