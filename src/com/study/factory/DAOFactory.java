package com.study.factory;

import com.study.dao.EmployeeDAO;
import com.study.dao.InformationDAO;
import com.study.dao.PermissionDAO;
import com.study.dao.impl.EmployeeDAOImpl;
import com.study.dao.impl.InformationDAOImpl;
import com.study.dao.impl.PermissionDAOImpl;

/**
 * Created by HP on 2017/12/19.
 */
public class DAOFactory {
    public static PermissionDAO getPermissionDAOInstance(){
        return new PermissionDAOImpl();
    }

    public static EmployeeDAO getEmployeeDAOInstance(){
        return new EmployeeDAOImpl();
    }

    public  static InformationDAO getInformationInstance(){
        return new InformationDAOImpl();
    }
}
