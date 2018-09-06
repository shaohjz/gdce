package com.isscollege.gdce.model;

import java.util.List;

import com.isscollege.gdce.domain.Contract;
import com.isscollege.gdce.domain.Product;


public interface IContractModel
{
	boolean addContract(Contract contract);
	int updateState(Contract constract,String ID);
	List<Contract> querConstractById(String ID);
	boolean updateProductStatezero(Product product);
}
