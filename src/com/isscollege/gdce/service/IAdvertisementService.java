package com.isscollege.gdce.service;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.domain.Advertisement;

public interface IAdvertisementService {


    int addAdvertisement(Advertisement ad);

	List<Advertisement> queryAdvertisementByState(int reviewState, int i, int j) throws SQLException;
}
