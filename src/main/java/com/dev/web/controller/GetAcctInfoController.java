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

import com.dev.api.request.Common;
import com.dev.api.request.GetAcctInfoRequest;
import com.dev.api.response.GetAcctInfoResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("getAcctInfo")
@PropertySource("classpath:serviceUrl.properties")
public class GetAcctInfoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(GetAcctInfoController.class);

	@Autowired
	private Environment env;

	@RequestMapping(value = "/prod", method = RequestMethod.POST)
	@ResponseBody
	public Object postProd(@RequestBody GetAcctInfoRequest getAcctInfoRequest) {
		try {
			LOGGER.info("Prod getAcctInfo post request catched {}", getAcctInfoRequest);
			putUUID(getAcctInfoRequest);
			MultiValueMap<String, String> headers = initHeaders();
			String jsonRes = postProdServer(getAcctInfoRequest.isKenoOrIlotto(), getAcctInfoRequest, headers);

			GetAcctInfoResponse getAcctInfoResponse = dealResToObject(jsonRes);
			LOGGER.info("Prod getAcctInfo response body {}", getAcctInfoResponse.toString());
			return getAcctInfoResponse;

		} catch (Exception e) {
			LOGGER.error("Error Prod getAcctInfo: {}", e);
			return e;
		}
	}

	@RequestMapping(value = "/staging", method = RequestMethod.POST)
	@ResponseBody
	public Object postStaging(@RequestBody GetAcctInfoRequest getAcctInfoRequest) {
		try {
			LOGGER.info("Staging getAcctInfo post request catched {}", getAcctInfoRequest);
			putUUID(getAcctInfoRequest);
			MultiValueMap<String, String> headers = initHeaders();
			String jsonRes = postStagingServer(getAcctInfoRequest.isKenoOrIlotto(), getAcctInfoRequest, headers);

			GetAcctInfoResponse getAcctInfoResponse = dealResToObject(jsonRes);
			LOGGER.info("Staging getAcctInfo response body {}", getAcctInfoResponse.toString());
			return getAcctInfoResponse;

		} catch (Exception e) {
			LOGGER.error("Error Staging getAcctInfo: {}", e);
			return e;
		}
	}

	@RequestMapping(value = "/dev", method = RequestMethod.POST)
	@ResponseBody
	public Object postDev(@RequestBody GetAcctInfoRequest getAcctInfoRequest) {
		try {
			LOGGER.info("Dev getAcctInfo post request catched {}", getAcctInfoRequest);
			putUUID(getAcctInfoRequest);
			MultiValueMap<String, String> headers = initHeaders();
			String jsonRes = postDevServer(getAcctInfoRequest.isKenoOrIlotto(), getAcctInfoRequest, headers);

			GetAcctInfoResponse getAcctInfoResponse = dealResToObject(jsonRes);
			LOGGER.info("Dev getAcctInfo response body {}", getAcctInfoResponse.toString());
			return getAcctInfoResponse;

		} catch (Exception e) {
			LOGGER.error("Error Dev getAcctInfo: {}", e);
			return e;
		}
	}
	
	public MultiValueMap<String, String> initHeaders() {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add(Common.USER_AGENT, Common.USER_AGENT_PROP);
		headers.add(Common.DATATYPE, Common.JSON);
		headers.add(Common.API, Common.GET_ACCTINFO);
		return headers;
	}

	public void putUUID(GetAcctInfoRequest getAcctInfoRequest) {
		getAcctInfoRequest.setSerialNo(UUID.randomUUID().toString());
	}
	
	public String postProdServer(boolean kenoOrIlotto, GetAcctInfoRequest getAcctInfoRequest, MultiValueMap<String, String> headers) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<GetAcctInfoRequest> request = new HttpEntity<GetAcctInfoRequest>(getAcctInfoRequest, headers);
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
	
	public String postStagingServer(boolean kenoOrIlotto, GetAcctInfoRequest getAcctInfoRequest, MultiValueMap<String, String> headers) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<GetAcctInfoRequest> request = new HttpEntity<GetAcctInfoRequest>(getAcctInfoRequest, headers);
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
	
	public String postDevServer(boolean kenoOrIlotto, GetAcctInfoRequest getAcctInfoRequest, MultiValueMap<String, String> headers) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<GetAcctInfoRequest> request = new HttpEntity<GetAcctInfoRequest>(getAcctInfoRequest, headers);
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
	
	public GetAcctInfoResponse dealResToObject(String jsonRes) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		GetAcctInfoResponse getAcctInfoResponse = new GetAcctInfoResponse();
		getAcctInfoResponse = mapper.readValue(jsonRes, GetAcctInfoResponse.class);
		return getAcctInfoResponse;
		
	}
	
}
