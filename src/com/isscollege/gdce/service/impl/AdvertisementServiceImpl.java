package com.isscollege.gdce.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.dao.IAdvertisementDao;
import com.isscollege.gdce.dao.impl.AdvertisementDaoImpl;
import com.isscollege.gdce.domain.Advertisement;
import com.isscollege.gdce.service.IAdvertisementService;

public class AdvertisementServiceImpl implements IAdvertisementService {

    private IAdvertisementDao dao;

    public AdvertisementServiceImpl() {
        dao = new AdvertisementDaoImpl();
    }

    @Override
    public int addAdvertisement(Advertisement ad) {
        return dao.addAdvertisement(ad);
    }

	@Override
	public List<Advertisement> queryAdvertisementByState(int reviewState, int i, int j) throws SQLException
	{
		// TODO Auto-generated method stub
		return dao.queryAdvertisementByState(reviewState,0,7);
	}
}
