package com.prasaddy.bankingapp.controller;

import com.prasaddy.bankingapp.dto.BankDTO;
import com.prasaddy.bankingapp.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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
    public ResponseEntity<BankDTO> getBankDetailsById(@PathVariable UUID bankId) {
        return bankService.getBankDetailsById(bankId);
    }

    @PostMapping(value = "/save", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<BankDTO> createBanksDetails(@RequestBody BankDTO bankDTO) {
        return bankService.createBank(bankDTO);
    }

    @PutMapping(value = "/{bankId}/update", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<BankDTO> updateBankDetailsById(@PathVariable UUID bankId, @RequestBody BankDTO bankDTO) {
        return bankService.updateBankDetailsById(bankId, bankDTO);
    }

    @DeleteMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> deleteAllBankDetails() {
        return bankService.deleteAllBankDetails();
    }

    @DeleteMapping(value = "/{bankId}/delete", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> deleteBankDetailsById(@PathVariable UUID bankId) {
        return bankService.deleteBankDetailsById(bankId);
    }

}