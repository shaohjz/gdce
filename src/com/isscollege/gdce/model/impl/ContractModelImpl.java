package com.isscollege.gdce.model.impl;

import java.util.List;

import com.isscollege.gdce.domain.Contract;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.model.IContractModel;
import com.isscollege.gdce.service.IContractService;
import com.isscollege.gdce.service.impl.ContractServiceImpl;

public class ContractModelImpl implements IContractModel
{

	private IContractService service;

	public ContractModelImpl()
	{
		service = new ContractServiceImpl();
	}

	@Override
	public boolean addContract(Contract contract)
	{
		// TODO Auto-generated method stub
		return service.addContract(contract);
	}

	@Override
	public int updateState(Contract constract, String ID)
	{
		return service.updateState(constract, ID);
	}

	@Override
	public List<Contract> querConstractById(String ID)
	{
		
		return service.querConstractById(ID);
	}

	@Override
	public boolean updateProductStatezero(Product product)
	{

		return service.updateProductStatezero(product);
	}
}
