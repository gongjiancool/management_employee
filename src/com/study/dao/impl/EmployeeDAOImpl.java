package com.study.dao.impl;

import com.study.dao.EmployeeDAO;
import com.study.model.Employee;
import com.study.utils.JDBCUtil;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by HP on 2017/12/19.
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public Employee get(String account) throws SQLException {
        String sql ="SELECT * FROM t_employee WHERE account = ? " ;
        Map<String,Object> map = jdbcUtil.executeQuerySingle(sql,new Object[]{account});
        if (map.size() != 0 ){
            Employee employee = new Employee(map.get("account").toString(),map.get("password").toString());
            return employee;
        }else {
            return null;
        }
    }
}
