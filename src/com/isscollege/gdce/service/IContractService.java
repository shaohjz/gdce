package com.isscollege.gdce.service;

import java.util.List;

import com.isscollege.gdce.domain.Contract;
import com.isscollege.gdce.domain.Product;

public interface IContractService
{
	
	boolean addContract(Contract contract);
	int updateState(Contract constract,String ID);
	List<Contract> querConstractById(String ID);
	boolean updateProductStatezero(Product product);
}
