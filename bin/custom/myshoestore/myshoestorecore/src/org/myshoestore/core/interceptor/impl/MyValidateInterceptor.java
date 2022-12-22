package org.myshoestore.core.interceptor.impl;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;
import org.myshoestore.core.model.MyEmployeeModel;

public class MyValidateInterceptor implements ValidateInterceptor
{
    @Override
    public void onValidate(final Object o, final InterceptorContext ctx) throws InterceptorException
    {
        if (o instanceof MyEmployeeModel)
        {
            final MyEmployeeModel empEntry = (MyEmployeeModel) o;
            if ((empEntry.getSalary()) > 5000)
            {
                throw new InterceptorException("Salary should not be greater than 5000");
            }
        }
    }
}