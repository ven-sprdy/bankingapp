package com.prasaddy.bankingapp.service;

import com.prasaddy.bankingapp.dto.BankDTO;
import com.prasaddy.bankingapp.model.Bank;
import com.prasaddy.bankingapp.repository.BankRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public Page<BankDTO> getAllBankDetails(Pageable pageable) {
        return bankRepository.findAll(pageable).map((bank -> modelMapper.map(bank, BankDTO.class)));
    }

    public BankDTO getBankDetailsById(String bankId) {
        Bank bank = bankRepository.findById(bankId).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(bank, BankDTO.class);
    }

    public void createBank(BankDTO bankDTO) {
            Bank bank = modelMapper.map(bankDTO, Bank.class);
            bankRepository.save(bank);
    }

    public void updateBankDetailsById(String bankId, BankDTO bankDTO) {
        Bank oldBank = bankRepository.findById(bankId).orElseThrow(EntityNotFoundException::new);
        Bank newBank = modelMapper.map(bankDTO, Bank.class);
        BeanUtils.copyProperties(newBank, oldBank);
        bankRepository.save(newBank);
    }

    public void deleteAllBankDetails() {
        bankRepository.deleteAll();
    }

    public void deleteBankDetailsById(String bankId) {
        bankRepository.deleteById(bankId);
    }


}
