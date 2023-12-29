package com.application.webapi.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.application.webapi.model.Deposit;
import com.application.webapi.model.Dokumen;
import com.application.webapi.service.DepositService;

@RestController
@RequestMapping("/deposits")
public class DepositController {
    private final DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }
    
    @PostMapping
    public Deposit saveDeposit(@RequestBody Deposit deposit) {
        return depositService.saveDeposit(deposit);
    }

     /* source data from mongodb*/
    @GetMapping
    public List<Deposit> getAllDeposits() {
        return depositService.getAllDeposit();
    }
    /* source data from elastic search*/
    @RequestMapping(value = "/elastic-list", method = RequestMethod.GET)
    public Iterable<Dokumen>get(){
        return depositService.getAllDepositElastic();
    }
    
}
