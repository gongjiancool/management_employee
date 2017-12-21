package com.study.service;

import com.study.model.Information;
import com.study.panel.SalaryPanel;

import java.util.Map;

/**
 * Created by HP on 2017/12/19.
 */
public interface LoginService {
    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    Map<String,Object> employeeLogin(String account , String password);

    /**
     *获得登入人的信息
     * @param account
     * @return
     */
    Information getInformation(String account);

}
