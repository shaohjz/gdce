package com.isscollege.gdce.model;


import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.domain.Advertisement;

public interface IAdvertisementModel {

    //�����ݿ����һ��Advertisement��¼
    int addAdvertisement(Advertisement ad);
    
    List<Advertisement> getAdvertisment(int reviewState) throws SQLException;

}
