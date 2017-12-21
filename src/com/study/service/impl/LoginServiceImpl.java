package com.study.service.impl;

import com.study.dao.EmployeeDAO;
import com.study.dao.InformationDAO;
import com.study.dao.PermissionDAO;
import com.study.factory.DAOFactory;
import com.study.model.Employee;
import com.study.model.Information;
import com.study.service.LoginService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HP on 2017/12/19.
 */
public class LoginServiceImpl implements LoginService{
    private EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAOInstance();
    private PermissionDAO permissionDAO = DAOFactory.getPermissionDAOInstance();
    private InformationDAO informationDAO = DAOFactory.getInformationInstance();

    @Override
    public Map<String, Object> employeeLogin(String account, String password) {
        Map<String, Object> map = new HashMap<>();
        Employee employee = null;
        Information information = null;
        try {
            employee = employeeDAO.get(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //找到指定
        if (employee != null) {
            if (employee.getPassword().equals(password)) {
                map.put("info", "登录成功");
                map.put("employee", employee);
                Map<String,List<String>> permissionMap = null;
                try {
                    permissionMap = permissionDAO.getPermission(account);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                map.put("permissionMap",permissionMap);
                map.put("information",information);
            } else {
                map.put("info", "密码错误");
            }
        } else {
            map.put("info", "账号不存在");
        }
        return map;
    }

    @Override
    public Information getInformation(String account) {
        Information information = null;
        try {
            information = informationDAO.getInformation(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  information;
    }
}
