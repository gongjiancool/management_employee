package com.study.dao;

import com.study.factory.DAOFactory;
import com.study.model.Information;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by HP on 2017/12/21.
 */
public class InformationDAOTest {
    private InformationDAO informationDAO;
    @Before
    public void setUp() throws Exception {
        informationDAO = DAOFactory.getInformationInstance();

    }

    @Test
    public void getInformation() throws Exception {
        Information information = informationDAO.getInformation("1602753107");
        System.out.println(information);

    }

}