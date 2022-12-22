/**
 *
 */
package org.myshoestore.facades.productCompare.impl;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;

import java.util.List;

import javax.annotation.Resource;


/**
 * @author admin
 *
 */
public class DefaultProductCompareFacade
{
	@Resource(name = "productService")
	private ProductService productService;

	@Resource(name = "catalogVersionService")
	private CatalogVersionService catalogVersionService;

	private CatalogVersionModel getCatalog()
	{
		final CatalogVersionModel onlineCatalogVersion = catalogVersionService.getCatalogVersion("myshoestoreProductCatalog",
				"Online");
		return onlineCatalogVersion;
	}


	public List<ProductModel> getListOfCompareProducts()
	{
		final List<ProductModel> productList = productService.getAllProductsForCatalogVersion(getCatalog());
		return productList;
	}

	public ProductModel getCompareProduct(final String prodId)
	{
		final ProductModel productCmp = productService.getProductForCode(getCatalog(), prodId);
		return productCmp;

	}

}
