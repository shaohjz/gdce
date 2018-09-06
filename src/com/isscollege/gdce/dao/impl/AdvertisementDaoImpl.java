package com.isscollege.gdce.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.common.dao.impl.BasicDao;
import com.isscollege.gdce.dao.IAdvertisementDao;
import com.isscollege.gdce.domain.Advertisement;

public class AdvertisementDaoImpl extends BasicDao implements IAdvertisementDao
{
	private static final String QUERY_UNREVIEW_ADVERTISEMENT = "SELECT * FROM tbl_ads WHERE reviewState=0 ORDER BY id ASC LIMIT %d,%d";
	private static final String UPDATE_ADVERTISEMENT_REVIEW_STATE = "UPDATE tbl_ads SET reviewState=%d WHERE id=%d";
	private static final String QUERY_REVIEW_ADVERTISEMENT = "SELECT * FROM tbl_ads WHERE reviewState=%d ORDER BY id ASC LIMIT %d,%d";

	// ��Advertisement��ݿ��в���һ���µ�Advertisement��¼
	@Override
	public int addAdvertisement(Advertisement ad)
	{
		int i = 0;
		String INSERT_ADS = "INSERT INTO tbl_ads(companyId,position,email,adsImgPath,adsURL,releaseDate,endDate,note,reviewState) VALUES(?,?,?,?,?,?,?,?,?)";
		try
		{
			i = this.insert(INSERT_ADS, new Object[] { ad.getCompanyId(), ad.getPosition(), ad.getEmail(),
					ad.getAdsImgPath(), ad.getAdsURL(), ad.getReleaseDate(), ad.getEndDate(), ad.getNote(), 0 });
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Advertisement> queryAdvertisementByReviewState(int page, int size) throws SQLException
	{
		return this.query(String.format(QUERY_UNREVIEW_ADVERTISEMENT, page, size), Advertisement.class);
	}

	@Override
	public void updateAdvertisementReviewState(int advertisementId, int curStats) throws SQLException
	{
		this.update(String.format(UPDATE_ADVERTISEMENT_REVIEW_STATE, curStats, advertisementId), null);
	}

	@Override
	public List<Advertisement> queryAdvertisementByState(int reviewState, int page, int size) throws SQLException
	{
		// TODO Auto-generated method stub
		return this.query(String.format(QUERY_REVIEW_ADVERTISEMENT, reviewState, page, size), Advertisement.class);
	}
}
