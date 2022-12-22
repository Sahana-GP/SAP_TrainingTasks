/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.ordermanagement.setup;

import static org.ordermanagement.constants.OrdermanagementConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import org.ordermanagement.constants.OrdermanagementConstants;
import org.ordermanagement.service.OrdermanagementService;


@SystemSetup(extension = OrdermanagementConstants.EXTENSIONNAME)
public class OrdermanagementSystemSetup
{
	private final OrdermanagementService ordermanagementService;

	public OrdermanagementSystemSetup(final OrdermanagementService ordermanagementService)
	{
		this.ordermanagementService = ordermanagementService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		ordermanagementService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return OrdermanagementSystemSetup.class.getResourceAsStream("/ordermanagement/sap-hybris-platform.png");
	}
}
