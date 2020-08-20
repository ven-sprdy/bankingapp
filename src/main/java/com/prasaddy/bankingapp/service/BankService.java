package com.prasaddy.bankingapp.service;

import com.prasaddy.bankingapp.dto.BankDTO;
import com.prasaddy.bankingapp.model.BankEntity;
import com.prasaddy.bankingapp.repository.BankRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public Page<BankDTO> getAllBankDetails(Pageable pageable) {
        return bankRepository.findAll(pageable).map((object -> modelMapper.map(object, BankDTO.class)));
    }

    public BankDTO getBankDetailsById(String bankId) {
        BankEntity bankEntity = bankRepository.findById(bankId).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(bankEntity, BankDTO.class);
    }

    public void createBanksDetails(List<BankDTO> bankDetails) {
        bankDetails.forEach(bank -> {
            BankEntity bankEntity = modelMapper.map(bank, BankEntity.class);
            bankRepository.save(bankEntity);
        });
    }

    public void updateBankDetailsById(String bankId, BankDTO bankDetails) {
        BankEntity oldBankEntity = bankRepository.findById(bankId).orElseThrow(EntityNotFoundException::new);
        BankEntity newBankEntity = modelMapper.map(bankDetails, BankEntity.class);
        BeanUtils.copyProperties(newBankEntity, oldBankEntity);
        bankRepository.save(newBankEntity);
    }

    public void deleteAllBankDetails() {
        bankRepository.deleteAll();
    }

    public void deleteBankDetailsById(String bankId) {
        bankRepository.deleteById(bankId);
    }


}
