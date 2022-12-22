package org.myshoestore.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.log4j.Logger;
import org.myshoestore.core.model.MyEmployeeModel;
import org.myshoestore.facades.product.data.MyEmployeeData;
import org.springframework.util.Assert;
public class MyEmployeeDataPopulator implements Populator<MyEmployeeModel, MyEmployeeData> {

    private static final Logger LOG = Logger.getLogger(MyEmployeeDataPopulator.class);

    @Override
    public void populate(final MyEmployeeModel source, final MyEmployeeData target) throws ConversionException
    {
        LOG.info("########## MyEmployeeDetailsDataPopulator ###########");
        Assert.notNull(source, "Parameter source can not be null");
        Assert.notNull(target, "Parameter target can not be null");
        target.setEmpid(source.getEmpid());
        target.setName(source.getName());
        target.setSalary(source.getSalary());
        target.setEmployeeWorkType(source.getEmployeeWorkType());
        target.setEmployee_company_age(source.getEmployee_company_age());
    }
}