package com.vlsu.volkov.service.impl;

import com.vlsu.volkov.dto.AddDemoDto;
import com.vlsu.volkov.dto.BindDemoWithContractDto;
import com.vlsu.volkov.model.Contract;
import com.vlsu.volkov.model.DemoDrop;
import com.vlsu.volkov.repository.ContractRepository;
import com.vlsu.volkov.repository.DemoDropRepository;
import com.vlsu.volkov.service.DemoDropService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DemoDropServiceImpl implements DemoDropService {
	private final DemoDropRepository demoDropRepository;
	private final ContractRepository contractRepository;

	@Override
	@Transactional
	public DemoDrop addDemoDrop(AddDemoDto addDemoDto) {
		DemoDrop demoDrop = new DemoDrop();
		demoDrop.setDemoUrl(addDemoDto.getDemoUrl());
		demoDrop.setDescription(addDemoDto.getDescription());
		demoDrop.setMail(addDemoDto.getMail());
		return demoDropRepository.save(demoDrop);
	}

	@Override
	@Transactional
	public DemoDrop bindWithContract(BindDemoWithContractDto bindDemoWithContractDto) {
		DemoDrop demoDrop = demoDropRepository.findById(bindDemoWithContractDto.getDemoDropId()).get();
		Contract contract = contractRepository.findById(bindDemoWithContractDto.getContractId()).get();
		demoDrop.setContract(contract);
		return demoDrop;
	}
}
