/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.da.custom.setup;

import static com.da.custom.constants.DacustomConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.da.custom.constants.DacustomConstants;
import com.da.custom.service.DacustomService;


@SystemSetup(extension = DacustomConstants.EXTENSIONNAME)
public class DacustomSystemSetup
{
	private final DacustomService dacustomService;

	public DacustomSystemSetup(final DacustomService dacustomService)
	{
		this.dacustomService = dacustomService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		dacustomService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return DacustomSystemSetup.class.getResourceAsStream("/dacustom/sap-hybris-platform.png");
	}
}
