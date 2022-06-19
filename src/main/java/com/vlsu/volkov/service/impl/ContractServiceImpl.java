package com.vlsu.volkov.service.impl;

import com.vlsu.volkov.dto.AddContractDto;
import com.vlsu.volkov.model.Contract;
import com.vlsu.volkov.repository.ContractRepository;
import com.vlsu.volkov.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {
	private final ContractRepository contractRepository;

	@Override
	@Transactional
	public Contract addContract(AddContractDto addContractDto) {
		Contract contract = new Contract();
		contract.setContractUrl(addContractDto.getContractUrl());
		contract.setType(addContractDto.getType());
		contract.setDate(addContractDto.getDate());
		return contractRepository.save(contract);
	}
}
