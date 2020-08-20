package com.prasaddy.bankingapp.controller;

import com.prasaddy.bankingapp.dto.BankDTO;
import com.prasaddy.bankingapp.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Page<BankDTO> getAllBankDetails(Pageable pageable) {
        return bankService.getAllBankDetails(pageable);
    }

    @GetMapping(value = "/{bankId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public BankDTO getBankDetailsById(@PathVariable String bankId) {
        return bankService.getBankDetailsById(bankId);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public void createBanksDetails(@RequestBody BankDTO bankDetails) {
        bankService.createBank(bankDetails);
    }

    @PutMapping(value = "/{bankId}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public void updateBankDetailsById(@PathVariable String bankId, @RequestBody BankDTO bankDetails) {
        bankService.updateBankDetailsById(bankId, bankDetails);
    }

    @DeleteMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public void deleteAllBankDetails() {
        bankService.deleteAllBankDetails();
    }

    @DeleteMapping(value = "/{bankId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public void deleteBankDetailsById(@PathVariable String bankId) {
        bankService.deleteBankDetailsById(bankId);
    }

}
