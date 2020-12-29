/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.da.dastore.service;

public interface DastoreService
{
	String getHybrisLogoUrl(String logoCode);

	void createLogo(String logoCode);
}
