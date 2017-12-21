package com.study.dao;

import com.study.model.Information;

import java.sql.SQLException;

/**
 * Created by HP on 2017/12/21.
 */
public interface InformationDAO {
    Information getInformation(String account)throws SQLException;
    int updateInformation(Information information) throws SQLException;
}
