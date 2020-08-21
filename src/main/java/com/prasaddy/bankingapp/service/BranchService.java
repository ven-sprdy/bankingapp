package com.prasaddy.bankingapp.service;

import com.prasaddy.bankingapp.dto.BankDTO;
import com.prasaddy.bankingapp.dto.BranchDTO;
import com.prasaddy.bankingapp.model.Bank;
import com.prasaddy.bankingapp.model.Branch;
import com.prasaddy.bankingapp.repository.BankRepository;
import com.prasaddy.bankingapp.repository.BranchRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BranchService {

    @Autowired
    BankRepository bankRepository;

    @Autowired
    BranchRepository branchRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public void createBranches(String bankId, List<BranchDTO> branchDTOS) {
        branchDTOS.forEach(branch -> {
            bankRepository.findById(bankId).map(bank -> {
                BankDTO bankDTO = modelMapper.map(bank, BankDTO.class);
                branch.setBank(bankDTO);
                Branch branchEntity = modelMapper.map(branch, Branch.class);
                return branchRepository.save(branchEntity);
            }).orElseThrow(EntityNotFoundException::new);
        });
    }

    public Page<BranchDTO> findBranchesByBankId(String bankId, Pageable pageable) {
        return branchRepository.findByBankBankId(bankId, pageable).map(branch -> modelMapper.map(branch, BranchDTO.class));
    }

    public void updateBranchById(String bankId, String branchId, BranchDTO branchDTO) {
        Bank bank = bankRepository.findById(bankId).orElseThrow(EntityNotFoundException::new);
        Branch oldBranch = branchRepository.findById(branchId).orElseThrow(EntityNotFoundException::new);
        Branch newBranch = modelMapper.map(branchDTO, Branch.class);
        newBranch.setBranchId(oldBranch.getBranchId());
        newBranch.getBranchAddress().setAddressId(oldBranch.getBranchAddress().getAddressId());
        newBranch.setBank(bank);
        branchRepository.save(newBranch);
    }

    public void deleteBranchById(String bankId, String branchId) {
        Branch branch = branchRepository.findByBranchIdAndBankBankId(branchId, bankId).orElseThrow(EntityNotFoundException::new);
        branchRepository.delete(branch);
    }

}
