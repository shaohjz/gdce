package com.isscollege.gdce.dao;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.domain.Contract;
import com.isscollege.gdce.domain.Product;

public interface IContractDao
{
	boolean addContract(Contract contract) throws SQLException;
	int updateState(Contract constract,String ID);
	List<Contract> querConstractById(String ID) throws SQLException;
	public boolean updateProductStatezero(Product product) throws SQLException;
}
