package com.isscollege.gdce.dao;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.domain.Advertisement;

public interface IAdvertisementDao
{
	// ����ݿ����һ��Adviertisement��¼
	int addAdvertisement(Advertisement ad);

	void updateAdvertisementReviewState(int advertisementId, int curStats) throws SQLException;

	List<Advertisement> queryAdvertisementByReviewState(int page, int size) throws SQLException;

	List<Advertisement> queryAdvertisementByState(int reviewState, int i, int j) throws SQLException;

}
