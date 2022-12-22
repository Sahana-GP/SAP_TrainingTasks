/**
 *
 */
package org.myshoestore.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.core.model.product.ProductModel;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.myshoestore.facades.productCompare.impl.DefaultProductCompareFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author admin
 *
 */
@Controller
@RequestMapping(value = "/compare/product/details")

public class ProductCompareDetailsController
{
	private static final Logger LOGGER = Logger.getLogger(ProductCompareDetailsController.class);

	@Resource(name = "productCompareFacade")
	DefaultProductCompareFacade productCompareFacade;

	@RequestMapping(method = RequestMethod.GET)
	@RequireHardLogIn
	public ModelAndView productDetails(@RequestParam
	final String ID, @CookieValue(value = "prodCode", defaultValue = "0001")
	final String prodCode)
	{
		final ProductModel productCmp = productCompareFacade.getCompareProduct(ID);
		final ProductModel initialproduct = productCompareFacade.getCompareProduct(prodCode);

		final ModelAndView model = new ModelAndView("pages/product/productCompareDetailsPage");
		model.addObject("compProd", productCmp);
		model.addObject("initialproduct", initialproduct);

		return model;
	}
}
