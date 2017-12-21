package com.study.dao;

import com.study.model.Employee;

import java.sql.SQLException;

/**
 * Created by 龚健
 * 2017/12/19.
 */
public interface EmployeeDAO {
    Employee get(String account) throws SQLException;
}
