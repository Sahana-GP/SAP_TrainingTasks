/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.ordermanagement.service;

public interface OrdermanagementService
{
	String getHybrisLogoUrl(String logoCode);

	void createLogo(String logoCode);
}
