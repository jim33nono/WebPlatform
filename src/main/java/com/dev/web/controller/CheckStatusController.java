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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.dev.api.request.CheckStatusRequest;
import com.dev.api.request.Common;
import com.dev.api.response.CheckStatusResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("checkStatus")
@PropertySource("classpath:serviceUrl.properties")
public class CheckStatusController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CheckStatusController.class);

	@Autowired
	private Environment env;

	@RequestMapping(value = "/dev", method = RequestMethod.POST)
	@ResponseBody
	public Object postDev(@RequestBody CheckStatusRequest checkStatusRequest) {
		try {
			LOGGER.info("Dev checkStatus post request catched {}", checkStatusRequest);
			putUUID(checkStatusRequest);
			MultiValueMap<String, String> headers = initHeaders();
			String jsonRes = postDevServer(checkStatusRequest.isKenoOrIlotto(), checkStatusRequest, headers);

			CheckStatusResponse checkStatusResponse = dealResToObject(jsonRes);
			LOGGER.info("Dev checkStatus response body {}", checkStatusResponse.toString());
			return checkStatusResponse;

		} catch (Exception e) {
			LOGGER.error("Error Dev checkStatus: {}", e);
			return e;
		}
	}

	@RequestMapping(value = "/staging", method = RequestMethod.POST)
	@ResponseBody
	public Object postStaging(@RequestBody CheckStatusRequest checkStatusRequest) {
		try {
			LOGGER.info("Staging checkStatus post request catched {}", checkStatusRequest);
			putUUID(checkStatusRequest);
			MultiValueMap<String, String> headers = initHeaders();
			String jsonRes = postStagingServer(checkStatusRequest.isKenoOrIlotto(), checkStatusRequest, headers);

			CheckStatusResponse checkStatusResponse = dealResToObject(jsonRes);
			LOGGER.info("Staging checkStatus response body {}", checkStatusResponse.toString());
			return checkStatusResponse;

		} catch (Exception e) {
			LOGGER.error("Error staging checkStatus: {}", e);
			return e;
		}
	}

	@RequestMapping(value = "/prod", method = RequestMethod.POST)
	@ResponseBody
	public Object postProd(@RequestBody CheckStatusRequest checkStatusRequest) {
		try {
			LOGGER.info("Prod checkStatus post request catched {}", checkStatusRequest);
			putUUID(checkStatusRequest);
			MultiValueMap<String, String> headers = initHeaders();
			String jsonRes = postProdServer(checkStatusRequest.isKenoOrIlotto(), checkStatusRequest, headers);

			CheckStatusResponse checkStatusResponse = dealResToObject(jsonRes);
			LOGGER.info("Prod checkStatus response body {}", checkStatusResponse.toString());
			return checkStatusResponse;

		} catch (Exception e) {
			LOGGER.error("Error prod checkStatus: {}", e);
			return e;
		}
	}
	
	public MultiValueMap<String, String> initHeaders() {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add(Common.USER_AGENT, Common.USER_AGENT_PROP);
		headers.add(Common.DATATYPE, Common.JSON);
		headers.add(Common.API, Common.CHECK_STATUS);
		return headers;
	}

	public void putUUID(CheckStatusRequest checkStatusRequest) {
		checkStatusRequest.setSerialNo(UUID.randomUUID().toString());
	}
	
	public String postProdServer(boolean kenoOrIlotto, CheckStatusRequest checkStatusRequest, MultiValueMap<String, String> headers) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<CheckStatusRequest> request = new HttpEntity<CheckStatusRequest>(checkStatusRequest, headers);
		String jsonRes = "";
		if (kenoOrIlotto == true) {
			jsonRes = restTemplate.postForObject(env.getProperty("api.prod.keno.target.url"), request, String.class);
		} else {
			jsonRes = restTemplate.postForObject(env.getProperty("api.prod.ilotto.target.url"), request,
					String.class);
		}
		LOGGER.info("Prod server res {}: ", jsonRes);
		return jsonRes;
	}
	
	public String postStagingServer(boolean kenoOrIlotto, CheckStatusRequest checkStatusRequest, MultiValueMap<String, String> headers) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<CheckStatusRequest> request = new HttpEntity<CheckStatusRequest>(checkStatusRequest, headers);
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
	
	public String postDevServer(boolean kenoOrIlotto, CheckStatusRequest checkStatusRequest, MultiValueMap<String, String> headers) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<CheckStatusRequest> request = new HttpEntity<CheckStatusRequest>(checkStatusRequest, headers);
		String jsonRes = "";
		if (kenoOrIlotto == true) {
			jsonRes = restTemplate.postForObject(env.getProperty("api.dev.keno.target.url"), request, String.class);
		} else {
			jsonRes = restTemplate.postForObject(env.getProperty("api.dev.ilotto.target.url"), request,
					String.class);
		}
		LOGGER.info("Dev server res {}: ", jsonRes);
		return jsonRes;
	}
	
	public CheckStatusResponse dealResToObject(String jsonRes) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		CheckStatusResponse checkStatusResponse = new CheckStatusResponse();
		checkStatusResponse = mapper.readValue(jsonRes, CheckStatusResponse.class);
		return checkStatusResponse;
		
	}

}
