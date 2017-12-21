package com.study.service;

import com.study.factory.ServiceFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by HP on 2017/12/21.
 */
public class LoginServiceTest {
    private LoginService loginService;
    @Before
    public void setUp() throws Exception {
        loginService = ServiceFactory.getLoginServiceInstance();
    }

    @Test
    public void employeeLogin() throws Exception {

    }

    @Test
    public void getInformation() throws Exception {

    }

}