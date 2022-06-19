package com.vlsu.volkov.service;

import com.vlsu.volkov.dto.AddContractDto;
import com.vlsu.volkov.model.Contract;

public interface ContractService {
	Contract addContract(AddContractDto addContractDto);
}
