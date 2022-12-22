package org.myshoestore.core.facade.impl;

import org.apache.log4j.Logger;
import org.myshoestore.core.facade.MyEmployeeFacade;
import org.myshoestore.core.model.MyEmployeeModel;
import org.myshoestore.core.service.MyEmployeeService;
import org.myshoestore.facades.product.data.MyEmployeeData;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class MyEmployeeFacadeImpl implements MyEmployeeFacade
{
    private MyEmployeeService myEmployeeService;

    @Resource(name = "myEmployeeDataConverter")
    private Converter<MyEmployeeModel, MyEmployeeData> myEmployeeDataConverter;

    private static final Logger LOG = Logger.getLogger(MyEmployeeFacadeImpl.class);

    public MyEmployeeService getMyEmployeeService()
    {
        return myEmployeeService;
    }

    public void setMyEmployeeService(final MyEmployeeService myEmployeeService)
    {
        this.myEmployeeService = myEmployeeService;
    }


    public Converter<MyEmployeeModel, MyEmployeeData> getMyEmployeeDataConverter()
    {
        return myEmployeeDataConverter;
    }

    public void setMyEmployeeDataConverter(final Converter<MyEmployeeModel, MyEmployeeData> myEmployeeDataConverter)
    {
        this.myEmployeeDataConverter = myEmployeeDataConverter;
    }


    @Override
    public List<MyEmployeeData> getMyEmployeeDetails()
    {
        LOG.info("####################### MyEmployeeFacadeImpl ###################");
        final List<MyEmployeeData> employees = new ArrayList<MyEmployeeData>();
        final List<MyEmployeeModel> model = getMyEmployeeService().getMyEmployeeDetails();
        final List<MyEmployeeData> myEmployeeData = myEmployeeDataConverter.convertAll(model);
        employees.addAll(myEmployeeData);
        return employees;
    }

}