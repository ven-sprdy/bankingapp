package com.prasaddy.bankingapp.service;

import com.prasaddy.bankingapp.dto.BankDTO;
import com.prasaddy.bankingapp.model.Address;
import com.prasaddy.bankingapp.model.Bank;
import com.prasaddy.bankingapp.repository.AddressRepository;
import com.prasaddy.bankingapp.repository.BankRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private AddressRepository addressRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public List<BankDTO> getAllBankDetails() {
//        Page<Bank> banks = bankRepository.findAll(pageable);
//        banks.forEach(bank -> {
//            Address address = addressRepository.findById(bank.getBankAddress().getAddressId()).orElseThrow(EntityNotFoundException:: new);
//            bank.setBankAddress(address);
//            BankDTO bankDTO = modelMapper.map(bank, BankDTO.class);
//            System.out.println("Test");
//        });
//        return bankRepository.findAll(pageable).map((bank -> modelMapper.map(bank, BankDTO.class)));
        List<Bank> banks = bankRepository.findAll();
        banks.forEach(bank -> {
            BankDTO bankDTO = modelMapper.map(bank, BankDTO.class);
            System.out.println(bankDTO);
        });
        return null;
    }

    public BankDTO getBankDetailsById(UUID bankId) {
        Bank bank = bankRepository.findById(bankId).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(bank, BankDTO.class);
    }

    public BankDTO createBank(BankDTO bankDTO) {
            Bank bank = modelMapper.map(bankDTO, Bank.class);
            bank = bankRepository.save(bank);
            return modelMapper.map(bank, BankDTO.class);
    }

    public BankDTO updateBankDetailsById(UUID bankId, BankDTO bankDTO) {
        Bank oldBank = bankRepository.findById(bankId).orElseThrow(EntityNotFoundException::new);
        Bank newBank = modelMapper.map(bankDTO, Bank.class);
        newBank.getBankAddress().setAddressId(oldBank.getBankAddress().getAddressId());
        newBank.setBankId(oldBank.getBankId());
        newBank = bankRepository.save(newBank);
        return modelMapper.map(newBank, BankDTO.class);
    }

    public void deleteAllBankDetails() {
        bankRepository.deleteAll();
    }

    public void deleteBankDetailsById(UUID bankId) {
        bankRepository.deleteById(bankId);
    }


}
