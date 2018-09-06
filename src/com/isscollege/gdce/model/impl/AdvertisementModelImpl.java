package com.isscollege.gdce.model.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.dao.IAdvertisementDao;
import com.isscollege.gdce.dao.impl.AdvertisementDaoImpl;
import com.isscollege.gdce.domain.Advertisement;
import com.isscollege.gdce.model.IAdvertisementModel;
import com.isscollege.gdce.service.IAdvertisementService;
import com.isscollege.gdce.service.impl.AdvertisementServiceImpl;

public class AdvertisementModelImpl implements IAdvertisementModel {

    private IAdvertisementService service;

    public AdvertisementModelImpl() {
        service = new AdvertisementServiceImpl();
    }

    @Override
    public int addAdvertisement(Advertisement ad) {
        return service.addAdvertisement(ad);
    }

	@Override
	public List<Advertisement> getAdvertisment(int reviewState) throws SQLException
	{
		// TODO Auto-generated method stub
		return service.queryAdvertisementByState(reviewState,0,7);
	}
}