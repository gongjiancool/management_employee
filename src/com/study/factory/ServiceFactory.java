package com.study.factory;

import com.study.service.LoginService;
import com.study.service.impl.LoginServiceImpl;

/**
 * Created by HP on 2017/12/19.
 */
public class ServiceFactory {
    public static LoginService getLoginServiceInstance(){
        return new LoginServiceImpl();
    }
}
