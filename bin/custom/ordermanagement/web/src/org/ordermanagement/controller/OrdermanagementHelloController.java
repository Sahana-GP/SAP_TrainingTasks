/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.ordermanagement.controller;

import static org.ordermanagement.constants.OrdermanagementConstants.PLATFORM_LOGO_CODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.ordermanagement.service.OrdermanagementService;


@Controller
public class OrdermanagementHelloController
{
	@Autowired
	private OrdermanagementService ordermanagementService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model)
	{
		model.addAttribute("logoUrl", ordermanagementService.getHybrisLogoUrl(PLATFORM_LOGO_CODE));
		return "welcome";
	}
}
