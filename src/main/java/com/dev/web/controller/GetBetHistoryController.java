package com.dev.web.controller;

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
import com.dev.api.request.GetBetHistoryRequest;
import com.dev.api.response.GetBetHistoryLottoResponse;
import com.dev.api.response.GetBetHistoryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("getBetHistory")
@PropertySource("classpath:serviceUrl.properties")
public class GetBetHistoryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(GetBetHistoryController.class);
	
	@Autowired
	private Environment env;
	
	@RequestMapping(value = "/prod", method = RequestMethod.POST)
	@ResponseBody
	public Object postProd(@RequestBody GetBetHistoryRequest getBetHistoryRequest) {
		try {
			LOGGER.info("Prod getBetHistory post request catched {}", getBetHistoryRequest);
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add(Common.USER_AGENT, Common.USER_AGENT_PROP);
			headers.add(Common.DATATYPE, Common.JSON);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			getBetHistoryRequest.setSerialNo(UUID.randomUUID().toString());
			String jsonRes = "";
			if (getBetHistoryRequest.isKenoOrIlotto() == true) {
				headers.add(Common.API, Common.GET_BET_HISTORY);
				HttpEntity<GetBetHistoryRequest> request = new HttpEntity<GetBetHistoryRequest>(getBetHistoryRequest, headers);
				jsonRes = restTemplate.postForObject(env.getProperty("api.prod.keno.target.url"), request, String.class);
				ObjectMapper mapper = new ObjectMapper();
				GetBetHistoryResponse getBetHistoryResponse = mapper.readValue(jsonRes, GetBetHistoryResponse.class);
				LOGGER.info("Staging getBetHistory response body {}", getBetHistoryResponse.toString());
				return getBetHistoryResponse;
			} else {
				headers.add(Common.API, Common.GET_BET_HISTORY_H5);
				HttpEntity<GetBetHistoryRequest> request = new HttpEntity<GetBetHistoryRequest>(getBetHistoryRequest, headers);
				jsonRes = restTemplate.postForObject(env.getProperty("api.prod.ilotto.target.url"), request,
						String.class);
				ObjectMapper mapper = new ObjectMapper();
				GetBetHistoryLottoResponse getBetHistoryLottoResponse = new GetBetHistoryLottoResponse();
				getBetHistoryLottoResponse = mapper.readValue(jsonRes, GetBetHistoryLottoResponse.class);
				LOGGER.info("Prod getBetHistoryLotto response body {}", getBetHistoryLottoResponse.toString());
				return getBetHistoryLottoResponse;
			}
			

		} catch (Exception e) {
			LOGGER.error("Error Prod getBetHistory: {}", e);
			return e;
		}
	}

	@RequestMapping(value = "/staging", method = RequestMethod.POST)
	@ResponseBody
	public Object postStaging(@RequestBody GetBetHistoryRequest getBetHistoryRequest) {
		try {
			LOGGER.info("Staging getBetHistory post request catched {}", getBetHistoryRequest);
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add(Common.USER_AGENT, Common.USER_AGENT_PROP);
			headers.add(Common.DATATYPE, Common.JSON);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			getBetHistoryRequest.setSerialNo(UUID.randomUUID().toString());
			String jsonRes = "";
			if (getBetHistoryRequest.isKenoOrIlotto() == true) {
				headers.add(Common.API, Common.GET_BET_HISTORY);
				HttpEntity<GetBetHistoryRequest> request = new HttpEntity<GetBetHistoryRequest>(getBetHistoryRequest, headers);
				jsonRes = restTemplate.postForObject(env.getProperty("api.staging.keno.target.url"), request, String.class);
				ObjectMapper mapper = new ObjectMapper();
				GetBetHistoryResponse getBetHistoryResponse = mapper.readValue(jsonRes, GetBetHistoryResponse.class);
				LOGGER.info("Staging getBetHistory response body {}", getBetHistoryResponse.toString());
				return getBetHistoryResponse;
			} else {
				headers.add(Common.API, Common.GET_BET_HISTORY_H5);
				HttpEntity<GetBetHistoryRequest> request = new HttpEntity<GetBetHistoryRequest>(getBetHistoryRequest, headers);
				jsonRes = restTemplate.postForObject(env.getProperty("api.staging.ilotto.target.url"), request,
						String.class);
				ObjectMapper mapper = new ObjectMapper();
				GetBetHistoryLottoResponse getBetHistoryLottoResponse = new GetBetHistoryLottoResponse();
				getBetHistoryLottoResponse = mapper.readValue(jsonRes, GetBetHistoryLottoResponse.class);
				LOGGER.info("Staging getBetHistoryLotto response body {}", getBetHistoryLottoResponse.toString());
				return getBetHistoryLottoResponse;
			}
			

		} catch (Exception e) {
			LOGGER.error("Error Staging getBetHistory: {}", e);
			return e;
		}
	}

	@RequestMapping(value = "/dev", method = RequestMethod.POST)
	@ResponseBody
	public Object postDev(@RequestBody GetBetHistoryRequest getBetHistoryRequest) {
		try {
			LOGGER.info("Dev getBetHistory post request catched {}", getBetHistoryRequest);
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add(Common.USER_AGENT, Common.USER_AGENT_PROP);
			headers.add(Common.DATATYPE, Common.JSON);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			getBetHistoryRequest.setSerialNo(UUID.randomUUID().toString());
			String jsonRes = "";
			if (getBetHistoryRequest.isKenoOrIlotto() == true) {
				headers.add(Common.API, Common.GET_BET_HISTORY);
				HttpEntity<GetBetHistoryRequest> request = new HttpEntity<GetBetHistoryRequest>(getBetHistoryRequest, headers);
				jsonRes = restTemplate.postForObject(env.getProperty("api.dev.keno.target.url"), request, String.class);
				ObjectMapper mapper = new ObjectMapper();
				GetBetHistoryResponse getBetHistoryResponse = mapper.readValue(jsonRes, GetBetHistoryResponse.class);
				LOGGER.info("Dev getBetHistory response body {}", getBetHistoryResponse.toString());
				return getBetHistoryResponse;
			} else {
				headers.add(Common.API, Common.GET_BET_HISTORY_H5);
				HttpEntity<GetBetHistoryRequest> request = new HttpEntity<GetBetHistoryRequest>(getBetHistoryRequest, headers);
				jsonRes = restTemplate.postForObject(env.getProperty("api.dev.ilotto.target.url"), request,
						String.class);
				ObjectMapper mapper = new ObjectMapper();
				GetBetHistoryLottoResponse getBetHistoryLottoResponse = new GetBetHistoryLottoResponse();
				getBetHistoryLottoResponse = mapper.readValue(jsonRes, GetBetHistoryLottoResponse.class);
				LOGGER.info("Dev getBetHistoryLotto response body {}", getBetHistoryLottoResponse.toString());
				return getBetHistoryLottoResponse;
			}
			

		} catch (Exception e) {
			LOGGER.error("Error Dev getBetHistory: {}", e);
			return e;
		}
	}

}
