package org.myshoestore.core.dao.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.myshoestore.core.dao.MyEmployeeDao;
import org.myshoestore.core.model.MyEmployeeModel;

import java.util.List;

public class MyEmployeeDaoImpl implements MyEmployeeDao
{
    private static final Logger LOG = Logger.getLogger(MyEmployeeDaoImpl.class);

    private FlexibleSearchService flexibleSearchService;

    public FlexibleSearchService getFlexibleSearchService()
    {
        return flexibleSearchService;
    }

    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
    {
        this.flexibleSearchService = flexibleSearchService;
    }


    @Override
    public List<MyEmployeeModel> getMyEmployeeDetails()
    {
        LOG.info("##### MyEmployeeDaoImpl ######");
        final String query = "SELECT {PK} FROM {MyEmployee}";
        final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(query.toString());
        final SearchResult searchResult = getFlexibleSearchService().search(searchQuery);
        return searchResult.getResult();
    }

}