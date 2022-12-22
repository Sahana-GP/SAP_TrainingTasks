package org.myshoestore.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;

import java.util.List;

import org.apache.log4j.Logger;
import org.myshoestore.core.facade.MyEmployeeFacade;
import org.myshoestore.facades.product.data.MyEmployeeData;
import org.myshoestore.storefront.controllers.ControllerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/employee")
public class MyEmployeeDetailsController extends AbstractPageController
{
    @Autowired
    private MyEmployeeFacade myEmployeeFacade;

    private static final String MYEMPLOYEE_CMS_PAGE = "myEmployee";

    private static final Logger LOG = Logger.getLogger(MyEmployeeDetailsController.class);


    public static String getMyemployeeCmsPage()
    {
        return MYEMPLOYEE_CMS_PAGE;
    }

    public MyEmployeeFacade getMyEmployeeFacade()
    {
        return myEmployeeFacade;
    }

    public void setMyEmployeeFacade(final MyEmployeeFacade myEmployeeFacade)
    {
        this.myEmployeeFacade = myEmployeeFacade;
    }

    @RequestMapping(value = "/myemployee", method = RequestMethod.GET)
    public String getMyEmployeeDetails(final Model model) throws CMSItemNotFoundException
    {
        LOG.info("######## MyEmployeeController ####");

        final List<MyEmployeeData> myEmployeeData = myEmployeeFacade.getMyEmployeeDetails();

        model.addAttribute("myEmployeeData", myEmployeeData);

        storeCmsPageInModel(model, getContentPageForLabelOrId(MYEMPLOYEE_CMS_PAGE));
        setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MYEMPLOYEE_CMS_PAGE));

        return ControllerConstants.Views.Pages.Misc.MyEmployeeDetails;

    }
}
