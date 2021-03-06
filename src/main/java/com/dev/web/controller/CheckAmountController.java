package com.dev.web.controller;

import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.dev.api.request.CheckAmountRequest;
import com.dev.api.request.Common;
import com.dev.api.response.CheckAmountResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("checkAmount")
@PropertySource("classpath:serviceUrl.properties")
public class CheckAmountController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CheckAmountController.class);

	@Autowired
	private Environment env;

	@RequestMapping(value = "/prod", method = RequestMethod.POST)
	@ResponseBody
	public Object postProd(@RequestBody CheckAmountRequest checkAmountRequest, @RequestParam boolean kenoOrIlotto) {
		try {
			LOGGER.info("Prod checkAmount post request catched {}", checkAmountRequest);
			putUUID(checkAmountRequest);
			MultiValueMap<String, String> headers = initHeaders();
			String jsonRes = postProdServer(kenoOrIlotto, checkAmountRequest, headers);

			CheckAmountResponse checkAmountResponse = dealResToObject(jsonRes);
			LOGGER.info("Prod checkAmount response body {}", checkAmountResponse.toString());
			return checkAmountResponse;

		} catch (Exception e) {
			LOGGER.error("Error Prod checkAmount: {}", e);
			return e;
		}
	}

	@RequestMapping(value = "/staging", method = RequestMethod.POST)
	@ResponseBody
	public Object postStaging(@RequestBody CheckAmountRequest checkAmountRequest, @RequestParam boolean kenoOrIlotto) {
		try {
			LOGGER.info("Staging checkAmount post request catched {}", checkAmountRequest);
			putUUID(checkAmountRequest);
			MultiValueMap<String, String> headers = initHeaders();
			String jsonRes = postStagingServer(kenoOrIlotto, checkAmountRequest, headers);

			CheckAmountResponse checkAmountResponse = dealResToObject(jsonRes);
			LOGGER.info("Staging checkAmount response body {}", checkAmountResponse.toString());
			return checkAmountResponse;

		} catch (Exception e) {
			LOGGER.error("Error Staging checkAmount: {}", e);
			return e;
		}
	}

	@RequestMapping(value = "/dev", method = RequestMethod.POST)
	@ResponseBody
	public Object postDev(@RequestBody CheckAmountRequest checkAmountRequest, @RequestParam boolean kenoOrIlotto) {
		try {
			LOGGER.info("Dev checkAmount post request catched {}", checkAmountRequest);
			putUUID(checkAmountRequest);
			MultiValueMap<String, String> headers = initHeaders();
			String jsonRes = postDevServer(kenoOrIlotto, checkAmountRequest, headers);

			CheckAmountResponse checkAmountResponse = dealResToObject(jsonRes);
			LOGGER.info("Dev checkAmount response body {}", checkAmountResponse.toString());
			return checkAmountResponse;

		} catch (Exception e) {
			LOGGER.error("Error Dev checkAmount: {}", e);
			return e;
		}
	}

	public MultiValueMap<String, String> initHeaders() {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add(Common.USER_AGENT, Common.USER_AGENT_PROP);
		headers.add(Common.DATATYPE, Common.JSON);
		headers.add(Common.API, Common.CHECK_AMOUNT);
		return headers;
	}

	public void putUUID(CheckAmountRequest checkAmountRequest) {
		checkAmountRequest.setSerialNo(UUID.randomUUID().toString());
	}

	public String postProdServer(boolean kenoOrIlotto, CheckAmountRequest checkAmountRequest,
			MultiValueMap<String, String> headers) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<CheckAmountRequest> request = new HttpEntity<CheckAmountRequest>(checkAmountRequest, headers);
		String jsonRes = "";
		if (kenoOrIlotto == true) {
			jsonRes = restTemplate.postForObject(env.getProperty("api.prod.keno.target.url"), request, String.class);
		} else {
			jsonRes = restTemplate.postForObject(env.getProperty("api.prod.ilotto.target.url"), request, String.class);
		}
		LOGGER.info("Prod server res {}: ", jsonRes);
		return jsonRes;
	}

	public String postStagingServer(boolean kenoOrIlotto, CheckAmountRequest checkAmountRequest,
			MultiValueMap<String, String> headers) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<CheckAmountRequest> request = new HttpEntity<CheckAmountRequest>(checkAmountRequest, headers);
		String jsonRes = "";
		if (kenoOrIlotto == true) {
			jsonRes = restTemplate.postForObject(env.getProperty("api.staging.keno.target.url"), request, String.class);
		} else {
			jsonRes = restTemplate.postForObject(env.getProperty("api.staging.ilotto.target.url"), request,
					String.class);
		}
		LOGGER.info("Staging server res {}: ", jsonRes);
		return jsonRes;
	}

	public String postDevServer(boolean kenoOrIlotto, CheckAmountRequest checkAmountRequest,
			MultiValueMap<String, String> headers) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<CheckAmountRequest> request = new HttpEntity<CheckAmountRequest>(checkAmountRequest, headers);
		String jsonRes = "";
		if (kenoOrIlotto == true) {
			jsonRes = restTemplate.postForObject(env.getProperty("api.dev.keno.target.url"), request, String.class);
		} else {
			jsonRes = restTemplate.postForObject(env.getProperty("api.dev.ilotto.target.url"), request, String.class);
		}
		
		LOGGER.info("Dev server res {}: ", jsonRes);
		return jsonRes;
	}

	public CheckAmountResponse dealResToObject(String jsonRes)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		CheckAmountResponse checkAmountResponse = new CheckAmountResponse();
		checkAmountResponse = mapper.readValue(jsonRes, CheckAmountResponse.class);
		return checkAmountResponse;

	}

}
