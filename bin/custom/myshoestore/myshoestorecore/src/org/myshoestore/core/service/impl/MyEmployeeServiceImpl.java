package org.myshoestore.core.service.impl;

import org.apache.log4j.Logger;
import org.myshoestore.core.dao.MyEmployeeDao;
import org.myshoestore.core.model.MyEmployeeModel;
import org.myshoestore.core.service.MyEmployeeService;

import java.util.List;

public class MyEmployeeServiceImpl implements MyEmployeeService
{
    private MyEmployeeDao myEmployeeDetailsDao;

    private static final Logger LOG = Logger.getLogger(MyEmployeeServiceImpl.class);


    public MyEmployeeDao getMyEmployeeDetailsDao()
    {
        return myEmployeeDetailsDao;
    }

    public void setMyEmployeeDetailsDao(final MyEmployeeDao myEmployeeDetailsDao)
    {
        this.myEmployeeDetailsDao = myEmployeeDetailsDao;
    }


    @Override
    public List<MyEmployeeModel> getMyEmployeeDetails()
    {
        LOG.info("###### MyEmployeeServiceImpl ######");
        return myEmployeeDetailsDao.getMyEmployeeDetails();
    }

}
