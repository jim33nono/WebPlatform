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

import com.dev.api.request.Common;
import com.dev.api.request.GetDrawResultRequest;
import com.dev.api.response.GetDrawResultResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("getDrawResult")
@PropertySource("classpath:serviceUrl.properties")
public class GetDrawResultController {
	private static final Logger LOGGER = LoggerFactory.getLogger(GetDrawResultController.class);

	@Autowired
	private Environment env;

	@RequestMapping(value = "/prod", method = RequestMethod.POST)
	@ResponseBody
	public Object prod(@RequestBody GetDrawResultRequest getDrawResultRequest, @RequestParam boolean kenoOrIlotto) {
		try {
			LOGGER.info("Prod getDrawResult post request catched {}", getDrawResultRequest);
			putUUID(getDrawResultRequest);
			MultiValueMap<String, String> headers = initHeaders();
			String jsonRes = postProdServer(kenoOrIlotto, getDrawResultRequest, headers);

			GetDrawResultResponse getDrawResultResponse = dealResToObject(jsonRes);
			LOGGER.info("Prod getDrawResult response body {}", getDrawResultResponse.toString());
			return getDrawResultResponse;

		} catch (Exception e) {
			LOGGER.error("Error Prod getDrawResult: {}", e);
			return e;
		}
	}

	@RequestMapping(value = "/staging", method = RequestMethod.POST)
	@ResponseBody
	public Object postStaging(@RequestBody GetDrawResultRequest getDrawResultRequest, @RequestParam boolean kenoOrIlotto) {
		try {
			LOGGER.info("Staging getDrawResult post request catched {}", getDrawResultRequest);
			putUUID(getDrawResultRequest);
			MultiValueMap<String, String> headers = initHeaders();
			String jsonRes = postStagingServer(kenoOrIlotto, getDrawResultRequest, headers);

			GetDrawResultResponse getDrawResultResponse = dealResToObject(jsonRes);
			LOGGER.info("Staging getDrawResult response body {}", getDrawResultResponse.toString());
			return getDrawResultResponse;

		} catch (Exception e) {
			LOGGER.error("Error Staging getDrawResult: {}", e);
			return e;
		}
	}

	@RequestMapping(value = "/dev", method = RequestMethod.POST)
	@ResponseBody
	public Object postDev(@RequestBody GetDrawResultRequest getDrawResultRequest, @RequestParam boolean kenoOrIlotto) {
		try {
			LOGGER.info("Dev getDrawResult post request catched {}", getDrawResultRequest);
			putUUID(getDrawResultRequest);
			MultiValueMap<String, String> headers = initHeaders();
			String jsonRes = postDevServer(kenoOrIlotto, getDrawResultRequest, headers);

			GetDrawResultResponse getDrawResultResponse = dealResToObject(jsonRes);
			LOGGER.info("Dev getDrawResult response body {}", getDrawResultResponse.toString());
			return getDrawResultResponse;

		} catch (Exception e) {
			LOGGER.error("Error Dev getDrawResult: {}", e);
			return e;
		}
	}
	
	public MultiValueMap<String, String> initHeaders() {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add(Common.USER_AGENT, Common.USER_AGENT_PROP);
		headers.add(Common.DATATYPE, Common.JSON);
		headers.add(Common.API, Common.GET_DRAW_RESULT);
		return headers;
	}

	public void putUUID(GetDrawResultRequest getDrawResultRequest) {
		getDrawResultRequest.setSerialNo(UUID.randomUUID().toString());
	}
	
	public String postProdServer(boolean kenoOrIlotto, GetDrawResultRequest getDrawResultRequest, MultiValueMap<String, String> headers) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<GetDrawResultRequest> request = new HttpEntity<GetDrawResultRequest>(getDrawResultRequest, headers);
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
	
	public String postStagingServer(boolean kenoOrIlotto, GetDrawResultRequest getDrawResultRequest, MultiValueMap<String, String> headers) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<GetDrawResultRequest> request = new HttpEntity<GetDrawResultRequest>(getDrawResultRequest, headers);
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
	
	public String postDevServer(boolean kenoOrIlotto, GetDrawResultRequest getDrawResultRequest, MultiValueMap<String, String> headers) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<GetDrawResultRequest> request = new HttpEntity<GetDrawResultRequest>(getDrawResultRequest, headers);
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
	
	public GetDrawResultResponse dealResToObject(String jsonRes) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		GetDrawResultResponse getDrawResultResponse = new GetDrawResultResponse();
		getDrawResultResponse = mapper.readValue(jsonRes, GetDrawResultResponse.class);
		return getDrawResultResponse;
		
	}

}
