package org.myshoestore.core.attributes;


import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;
import org.myshoestore.core.model.MyEmployeeModel;

import java.util.Calendar;
import java.util.Date;

public class EmployeeCompanyAgeHandler extends
        AbstractDynamicAttributeHandler<Integer, MyEmployeeModel>
{
    @Override
    public Integer get(final MyEmployeeModel model)
    {
        int employeeCompanyAge = 0;
        try
        {
            final Date employeeRegisteredDate = model.getCreationtime();
            final Calendar cal = Calendar.getInstance();
            cal.setTime(employeeRegisteredDate);
            final int registeredDate = cal.get(Calendar.DATE);
            final int currentDate = Calendar.getInstance().get(Calendar.DATE);
            employeeCompanyAge = currentDate - registeredDate;
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
        return employeeCompanyAge;
    }
}