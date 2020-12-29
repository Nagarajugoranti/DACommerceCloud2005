/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.da.custom.captcha;

import de.hybris.platform.servicelayer.config.ConfigurationService;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author nagaraju.g -- Class to verify user using google recaptcha
 */
public class CaptchaService
{
	private final static Logger LOGGER = LoggerFactory.getLogger(CaptchaService.class);

	@Autowired
	private ConfigurationService configurationService;

	private static final String RECAPTCHA_SERVICE_URL = "https://www.google.com/recaptcha/api/siteverify";
	private static String SECRET_KEY = "";


	public boolean processResponse(final String token) throws IOException
	{
		if (token == null || "".equals(token))
		{
			return false;
		}
		SECRET_KEY = configurationService.getConfiguration().getProperty("google.recaptcha.key.secret").toString();
		final URL obj = new URL(RECAPTCHA_SERVICE_URL);
		final HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		//add client result as post parameter
		final String postParams = "secret=" + SECRET_KEY + "&response=" + token;

		// send post request to google recaptcha server
		con.setDoOutput(true);
		final DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postParams);
		wr.flush();
		wr.close();

		int responseCode = 0;
		try
		{
			responseCode = con.getResponseCode();
		}
		catch (final IOException e)
		{
			// XXX Auto-generated catch block
			e.printStackTrace();
		}

		final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		final StringBuffer response = new StringBuffer();

		try
		{
			while ((inputLine = in.readLine()) != null)
			{
				response.append(inputLine);
			}
		}
		catch (final IOException e)
		{
			// XXX Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			in.close();
		}
		catch (final IOException e)
		{
			// XXX Auto-generated catch block
			e.printStackTrace();
		}


		final GoogleResponse googleResponse = new ObjectMapper().readValue(response.toString(), GoogleResponse.class);


		System.out.println("success : " + googleResponse.isSuccess());
		System.out.println("score : " + googleResponse.getScore());

		//result should be sucessfull and spam score above 0.5
		return (googleResponse.isSuccess() && googleResponse.getScore() >= 0.5);

	}
}

