package com.isscollege.gdce.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.common.dao.impl.BasicDao;
import com.isscollege.gdce.dao.IContractDao;
import com.isscollege.gdce.domain.Contract;
import com.isscollege.gdce.domain.Product;

public class ContractDaoImpl extends BasicDao implements IContractDao {
	private int productState = 0;
	private static final String INSERT_USER = "INSERT INTO tbl_contract_info ( id, contractid, buyercompanyid, sellercompanyid, "
			+ "productid, buyercontractstate,sellercontractstate, createdate, enddate) values(?,?,?,?,?,?,?,?,?); ";

	private static final String QUERY_CONSTRACT = "SELECT id,contractId,buyerCompanyId,sellerCompanyId,productId,buyerContractState,sellerContractState,createDate,endDate "
			+ "FROM tbl_contract_info WHERE sellerCompanyId='%s'OR buyerCompanyId='%s';";

	private static final String UPDATE_STATE = "UPDATE tbl_contract_info SET sellerContractState=?, buyerContractState=true WHERE contractId='%s';";

	@Override
	public int updateState(Contract contract, String ID) {
		try {
			String s = String.format(UPDATE_STATE, ID);
			int state = this.update(s, new Object[] { true });
			return state;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public List<Contract> querConstractById(String ID) throws SQLException {
		String s = String.format(QUERY_CONSTRACT, ID, ID);
		List<Contract> constractList = this.query(s, Contract.class);
		return constractList;
	}

	@Override
	public boolean addContract(Contract contract) throws SQLException {
		int state = this.insert(INSERT_USER,
				new Object[] { contract.getId(), contract.getContractId(), contract.getBuyerCompanyId(),
						contract.getSellerCompanyId(), contract.getProductId(), contract.isBuyerContractState(),
						contract.isSellerContractState(), contract.getCreateDate(), contract.getEndDate() });
		if (state > 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean updateProductStatezero(Product product) throws SQLException {
		String updateProductsql = "UPDATE tbl_product_info SET productState = ? WHERE productId = ?";
		int state = this.update(updateProductsql, new Object[] { productState, product.getProductId() });
		return state > 0 ? true : false;
	}

}
