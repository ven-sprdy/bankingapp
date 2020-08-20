package com.prasaddy.bankingapp.service;

import com.prasaddy.bankingapp.dto.BankDTO;
import com.prasaddy.bankingapp.dto.BranchDTO;
import com.prasaddy.bankingapp.model.BranchEntity;
import com.prasaddy.bankingapp.repository.BankRepository;
import com.prasaddy.bankingapp.repository.BranchRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BranchService {

    @Autowired
    BankRepository bankRepository;

    @Autowired
    BranchRepository branchRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public void createBranches(String bankId, List<BranchDTO> branches) {
        branches.forEach(branch -> {
            bankRepository.findById(bankId).map(bank -> {
                BankDTO bankDTO = modelMapper.map(bank, BankDTO.class);
                branch.setBank(bankDTO);
                BranchEntity branchEntity = modelMapper.map(branch, BranchEntity.class);
                return branchRepository.save(branchEntity);
            }).orElseThrow(EntityNotFoundException::new);
        });
    }

}
