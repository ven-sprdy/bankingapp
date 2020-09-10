package com.prasaddy.bankingapp.service;

import com.prasaddy.bankingapp.dto.BankDTO;
import com.prasaddy.bankingapp.model.Bank;
import com.prasaddy.bankingapp.repository.BankRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public Page<BankDTO> getAllBankDetails(Pageable pageable) {
        return bankRepository.findAll(pageable).map((bank -> modelMapper.map(bank, BankDTO.class)));
    }

    public ResponseEntity<BankDTO> getBankDetailsById(UUID bankId) {
        Bank bank = bankRepository.findById(bankId).orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(modelMapper.map(bank, BankDTO.class));
    }

    public ResponseEntity<BankDTO> createBank(BankDTO bankDTO) {
        Bank bank = modelMapper.map(bankDTO, Bank.class);
        bank = bankRepository.save(bank);
        return ResponseEntity.ok(modelMapper.map(bank, BankDTO.class));
    }

    public ResponseEntity<BankDTO> updateBankDetailsById(UUID bankId, BankDTO bankDTO) {
        Bank oldBank = bankRepository.findById(bankId).orElseThrow(EntityNotFoundException::new);
        Bank newBank = modelMapper.map(bankDTO, Bank.class);
        newBank.setBankId(oldBank.getBankId());
        Bank bank = bankRepository.save(newBank);
        return ResponseEntity.ok(modelMapper.map(bank, BankDTO.class));
    }

    public ResponseEntity<String> deleteAllBankDetails() {
        bankRepository.deleteAll();
        return ResponseEntity.ok("All bank details deleted.");
    }

    public ResponseEntity<String> deleteBankDetailsById(UUID bankId) {
        bankRepository.deleteById(bankId);
        return ResponseEntity.ok("Bank details deleted by ID: " +bankId);
    }

}