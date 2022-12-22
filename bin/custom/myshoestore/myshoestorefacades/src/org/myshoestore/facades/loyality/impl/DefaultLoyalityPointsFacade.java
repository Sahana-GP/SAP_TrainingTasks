package org.myshoestore.facades.loyality.impl;

import de.hybris.platform.commercefacades.order.CartFacade;
import de.hybris.platform.commerceservices.strategies.CheckoutCustomerStrategy;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.order.CartService;
import de.hybris.platform.servicelayer.model.ModelService;

import org.myshoestore.facades.LoyalityData;
import org.myshoestore.facades.loyality.LoyalityPointsFacades;


public class DefaultLoyalityPointsFacade implements LoyalityPointsFacades
{

	private ModelService modelService;
	private CheckoutCustomerStrategy checkoutCustomerStrategy;
	private CartService cartService;
	private CartFacade cartFacade;

	public CartService getCartService()
	{
		return cartService;
	}

	public void setCartService(final CartService cartService)
	{
		this.cartService = cartService;
	}

	public CartFacade getCartFacade()
	{
		return cartFacade;
	}

	public void setCartFacade(final CartFacade cartFacade)
	{
		this.cartFacade = cartFacade;
	}

	public ModelService getModelService()
	{
		return modelService;
	}

	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	public CheckoutCustomerStrategy getCheckoutCustomerStrategy()
	{
		return checkoutCustomerStrategy;
	}

	public void setCheckoutCustomerStrategy(final CheckoutCustomerStrategy checkoutCustomerStrategy)
	{
		this.checkoutCustomerStrategy = checkoutCustomerStrategy;
	}

	public boolean hasCheckoutCart()
	{
		return getCartFacade().hasSessionCart();
	}

	public CartModel getCart()
	{
		return hasCheckoutCart() ? getCartService().getSessionCart() : null;
	}

	@Override
	public LoyalityData defaultLoyalityPointsFacade()
	{
		final CustomerModel customerModel = getCheckoutCustomerStrategy().getCurrentUserForCheckout();
		final CartModel cartModel = getCart();
		return deductLoyalityPoints(cartModel, customerModel);
	}


	public LoyalityData deductLoyalityPoints(final CartModel cartModel, final CustomerModel customerModel)
	{


		final LoyalityData loyalityData = new LoyalityData();
		int newloyalityPoints = 0;
		final int loyalityPoints = customerModel.getLoyalityPoints();
		loyalityData.setInitialLoyality(loyalityPoints);
		final Double cartTotal = cartModel.getTotalPrice();

		if (cartTotal > loyalityPoints)
		{
			final double newCartTotal = cartTotal - loyalityPoints;
			customerModel.setLoyalityPoints(newloyalityPoints);
			modelService.save(customerModel);
			cartModel.setTotalPrice(newCartTotal);
			modelService.save(cartModel);
		}
		else
		{
			newloyalityPoints = (int) (loyalityPoints - cartTotal);
			final double newCartTotal = 0.0;
			customerModel.setLoyalityPoints(newloyalityPoints);
			modelService.save(customerModel);
			cartModel.setTotalPrice(newCartTotal);
			modelService.save(cartModel);
		}
		loyalityData.setUpdatedLoyality(newloyalityPoints);
		loyalityData.setUserName(customerModel.getName());
		return loyalityData;
	}
}