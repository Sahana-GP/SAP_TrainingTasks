/**
*
*/
package org.myshoestore.storefront.controllers.pages.checkout.steps;



/**
* @author Administrator
*
*/
import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.checkout.steps.CheckoutStep;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.checkout.steps.AbstractCheckoutStepController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commerceservices.order.CommerceCartModificationException;

import javax.annotation.Resource;

import org.myshoestore.facades.LoyalityData;
import org.myshoestore.facades.loyality.impl.DefaultLoyalityPointsFacade;
import org.myshoestore.storefront.controllers.ControllerConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;





@Controller
@RequestMapping(value = "/checkout/multi/loyality-points")
public class LoyalityPointsCheckoutStepController extends AbstractCheckoutStepController
{
	@Resource(name = "loyalityPointsFacade")
	private DefaultLoyalityPointsFacade loyalityPointsFacade;





	private final static String LOYALITY_POINTS = "loyality-points";





	@RequestMapping(method = RequestMethod.GET)
	@RequireHardLogIn
	@Override
	public String enterStep(final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException, CommerceCartModificationException
	{
		final LoyalityData loyalityData = loyalityPointsFacade.defaultLoyalityPointsFacade();
		model.addAttribute("intloyalityPoints", loyalityData.getInitialLoyality());
		model.addAttribute("finalLoyalityPoints", loyalityData.getUpdatedLoyality());
		model.addAttribute("userName", loyalityData.getUserName());





		return ControllerConstants.Views.Pages.MultiStepCheckout.LoyalityPointsPage;
	}





	@RequireHardLogIn
	@Override
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String back(final RedirectAttributes redirectAttributes)
	{
		return getCheckoutStep().previousStep();
	}





	@RequireHardLogIn
	@Override
	@RequestMapping(value = "/next", method = RequestMethod.GET)
	public String next(final RedirectAttributes redirectAttributes)
	{





		return getCheckoutStep().nextStep();
	}





	protected CheckoutStep getCheckoutStep()
	{
		return getCheckoutStep(LOYALITY_POINTS);
	}
}