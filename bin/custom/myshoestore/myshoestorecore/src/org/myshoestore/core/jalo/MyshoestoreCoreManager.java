/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.myshoestore.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.myshoestore.core.constants.MyshoestoreCoreConstants;
import org.myshoestore.core.setup.CoreSystemSetup;


/**
 * Do not use, please use {@link CoreSystemSetup} instead.
 * 
 */
public class MyshoestoreCoreManager extends GeneratedMyshoestoreCoreManager
{
	public static final MyshoestoreCoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (MyshoestoreCoreManager) em.getExtension(MyshoestoreCoreConstants.EXTENSIONNAME);
	}
}
