package org.myshoestore.core.interceptor;

import de.hybris.platform.servicelayer.interceptor.Interceptor;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;

public interface ValidateInterceptorInt extends Interceptor
{
    void onValidate(Object o, InterceptorContext ctx) throws InterceptorException;
}
