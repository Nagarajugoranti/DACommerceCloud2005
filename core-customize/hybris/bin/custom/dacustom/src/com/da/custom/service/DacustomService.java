/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.da.custom.service;

public interface DacustomService
{
	String getHybrisLogoUrl(String logoCode);

	void createLogo(String logoCode);
}
