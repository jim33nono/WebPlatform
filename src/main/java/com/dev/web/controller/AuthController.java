package com.dev.web.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.dev.auth.Url;

@Controller
@PropertySource("classpath:authorizeUrlAndRes.properties")
public class AuthController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
	private static final String ERRORURL = "urlError";

	@Autowired
	private Environment env;


	@RequestMapping(value = "/lotto/prod/authorization", method = RequestMethod.POST)
	@ResponseBody
	public Url lottoProdAuth() {
		LOGGER.info("Lotoo prod post request catched");
		RestTemplate restTemplate = new RestTemplate();
		try {
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			HttpEntity<String> request = new HttpEntity<String>("parameters", headers);
			String str = restTemplate.postForObject(env.getProperty("lotto.auth.prod.target.url"), request,
					String.class);
			LOGGER.info("Lotoo prod: http post to api server, return data: {}", str);
			Document doc = Jsoup.parse(str);
			str = doc.select("a").first().attr("href");
			LOGGER.info("Return data after clipped {}", str);
			Url url = new Url(str);
			return url;

		} catch (Exception e) {
			LOGGER.error("Exceptions happens:{}", e);
			return new Url(ERRORURL);
		}

	}

	@RequestMapping(value = "/lotto/staging/authorization", method = RequestMethod.POST)
	@ResponseBody
	public Url lottoStagingAuth() {
		LOGGER.info("Lotoo staging post request catched");
		RestTemplate restTemplate = new RestTemplate();
		try {
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			HttpEntity<String> request = new HttpEntity<String>("parameters", headers);
			String str = restTemplate.postForObject(env.getProperty("lotto.auth.staging.target.url"), request,
					String.class);
			LOGGER.info("Lotoo staging: http post to api server, return data: {}", str);
			Document doc = Jsoup.parse(str);
			str = doc.select("a").first().attr("href");
			LOGGER.info("Return data after clipped {}", str);
			Url url = new Url(str);
			return url;

		} catch (Exception e) {
			LOGGER.error("Exceptions happens:{}", e);
			return new Url(ERRORURL);
		}

	}

	@RequestMapping(value = "/lotto/dev/authorization", method = RequestMethod.POST)
	@ResponseBody
	public Url lottoDevAuth() {
		LOGGER.info("Lotoo dev post request catched");
		RestTemplate restTemplate = new RestTemplate();
		try {
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			HttpEntity<String> request = new HttpEntity<String>("parameters", headers);
			String str = restTemplate.postForObject(env.getProperty("lotto.auth.dev.target.url"), request,
					String.class);
			LOGGER.info("Lotoo dev: http post to api server, return data: {}", str);
			Document doc = Jsoup.parse(str);
			str = doc.select("a").first().attr("href");
			LOGGER.info("Return data after clipped {}", str);
			Url url = new Url(str);
			return url;

		} catch (Exception e) {
			LOGGER.error("Exceptions happens:{}", e);
			return new Url(ERRORURL);
		}

	}

	@RequestMapping(value = "/keno/prod/authorization", method = RequestMethod.POST)
	@ResponseBody
	public Url kenoProdAuth() {
		LOGGER.info("Keno prod post request catched");
		RestTemplate restTemplate = new RestTemplate();
		try {
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			HttpEntity<String> request = new HttpEntity<String>("parameters", headers);
			String str = restTemplate.postForObject(env.getProperty("keno.auth.prod.target.url"), request,
					String.class);
			LOGGER.info("Keno prod: http post to api server, return data: {}", str);
			Document doc = Jsoup.parse(str);
			str = doc.select("a").first().attr("href");
			LOGGER.info("Return data after clipped {}", str);
			Url url = new Url(str);
			return url;
		} catch (Exception e) {
			LOGGER.error("Exceptions happens:{}", e);
			return new Url(ERRORURL);
		}

	}

	@RequestMapping(value = "/keno/staging/authorization", method = RequestMethod.POST)
	@ResponseBody
	public Url kenoStagingAuth() {
		LOGGER.info("Keno staging post request catched");
		RestTemplate restTemplate = new RestTemplate();
		try {
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			HttpEntity<String> request = new HttpEntity<String>("parameters", headers);
			String str = restTemplate.postForObject(env.getProperty("keno.auth.staging.target.url"), request,
					String.class);
			LOGGER.info("Keno staging: http post to api server, return data: {}", str);
			Document doc = Jsoup.parse(str);
			str = doc.select("a").first().attr("href");
			LOGGER.info("Return data after clipped {}", str);
			Url url = new Url(str);
			return url;

		} catch (Exception e) {
			LOGGER.error("Exceptions happens:{}", e);
			return new Url(ERRORURL);
		}

	}

	@RequestMapping(value = "/keno/dev/authorization", method = RequestMethod.POST)
	@ResponseBody
	public Url kenoDevAuth() {
		LOGGER.info("Keno dev post request catched");
		RestTemplate restTemplate = new RestTemplate();
		try {
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			HttpEntity<String> request = new HttpEntity<String>("parameters", headers);
			String str = restTemplate.postForObject(env.getProperty("keno.auth.dev.target.url"), request, String.class);
			LOGGER.info("Keno dev: http post to api server, return data: {}", str);
			Document doc = Jsoup.parse(str);
			str = doc.select("a").first().attr("href");
			LOGGER.info("Return data after clipped {}", str);
			Url url = new Url(str);
			return url;

		} catch (Exception e) {
			LOGGER.error("Exceptions happens:{}", e);
			return new Url(ERRORURL);
		}

	}
	
	@RequestMapping(value = "/keno/staging/onewallet", method = RequestMethod.POST)
	@ResponseBody
	public Url kenoStagingOneWallet() {
		LOGGER.info("One wallet Keno staging post request catched");
		RestTemplate restTemplate = new RestTemplate();
		try {
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			HttpEntity<String> request = new HttpEntity<String>("parameters", headers);
			String str = restTemplate.postForObject(env.getProperty("keno.onewallet.staging.target.url"), request,
					String.class);
			LOGGER.info("Keno staging: http post to api server, return data: {}", str);
			Document doc = Jsoup.parse(str);
			str = doc.select("a").first().attr("href");
			LOGGER.info("Return data after clipped {}", str);
			Url url = new Url(str);
			return url;

		} catch (Exception e) {
			LOGGER.error("Exceptions happens:{}", e);
			return new Url(ERRORURL);
		}

	}
	
	@RequestMapping(value = "/keno/dev/onewallet", method = RequestMethod.POST)
	@ResponseBody
	public Url kenoDevOneWallet() {
		LOGGER.info("One wallet Keno dev post request catched");
		RestTemplate restTemplate = new RestTemplate();
		try {
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			HttpEntity<String> request = new HttpEntity<String>("parameters", headers);
			String str = restTemplate.postForObject(env.getProperty("keno.onewallet.dev.target.url"), request, String.class);
			LOGGER.info("Keno dev: http post to api server, return data: {}", str);
			Document doc = Jsoup.parse(str);
			str = doc.select("a").first().attr("href");
			LOGGER.info("Return data after clipped {}", str);
			Url url = new Url(str);
			return url;

		} catch (Exception e) {
			LOGGER.error("Exceptions happens:{}", e);
			return new Url(ERRORURL);
		}

	}

	

}
