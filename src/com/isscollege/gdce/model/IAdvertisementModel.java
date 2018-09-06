package com.isscollege.gdce.model;


import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.domain.Advertisement;

public interface IAdvertisementModel {

    //向数据库添加一条Advertisement记录
    int addAdvertisement(Advertisement ad);
    
    List<Advertisement> getAdvertisment(int reviewState) throws SQLException;

}
