package com.vlsu.volkov.service;

import com.vlsu.volkov.dto.AddDemoDto;
import com.vlsu.volkov.dto.BindDemoWithContractDto;
import com.vlsu.volkov.model.DemoDrop;

public interface DemoDropService {
	DemoDrop addDemoDrop(AddDemoDto addDemoDto);

	DemoDrop bindWithContract(BindDemoWithContractDto bindDemoWithContractDto);
}
