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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.dev.api.request.Common;
import com.dev.api.request.TransferRequest;
import com.dev.api.response.TransferResponse;
import com.dev.recaptcha.VerifyRecaptcha;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("transfering")
@PropertySource("classpath:serviceUrl.properties")
public class TransferController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransferController.class);

	@Autowired
	private Environment env;

	@RequestMapping(value = "/dev/ilotto", method = RequestMethod.GET)
	public String devIlotto() {
		LOGGER.info("test api catched");
		return "/html/transfer.html";
	}

	@RequestMapping(value = "/dev/deposit", method = RequestMethod.POST)
	@ResponseBody
	public TransferResponse devDeposit(@RequestParam("token") String token, @RequestBody TransferRequest transferRequest) {
		try {
			LOGGER.info("Dev deposit post request catched {},\n token = {}", transferRequest, token);
			String response = VerifyRecaptcha.postVerifyServer(token);
			if (!VerifyRecaptcha.scanJsonNodeSuccess(response)) {
				return  new TransferResponse("", "", 5, "Fail to verify you are not a bot", "");
			};
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add(Common.USER_AGENT, Common.USER_AGENT_PROP);
			headers.add(Common.DATATYPE, Common.JSON);
			headers.add(Common.API, Common.DEPOSIT);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			transferRequest.setSerialNo(UUID.randomUUID().toString());
			// MerchantCode must be TEST
			transferRequest.setMerchantCode("TEST");
			HttpEntity<TransferRequest> request = new HttpEntity<TransferRequest>(transferRequest, headers);
			String jsonRes = "";
			if (transferRequest.isKenoOrIlotto() == true) {
				jsonRes = restTemplate.postForObject(env.getProperty("api.dev.keno.target.url"), request, String.class);
			} else {
				jsonRes = restTemplate.postForObject(env.getProperty("api.dev.ilotto.target.url"), request,
						String.class);
			}
			ObjectMapper mapper = new ObjectMapper();
			TransferResponse transferRes = new TransferResponse();
			transferRes = mapper.readValue(jsonRes, TransferResponse.class);
			LOGGER.info("Dev deposit response body {}", transferRes.toString());
			return transferRes;

		} catch (Exception e) {
			LOGGER.error("Error Dev deposit: {}", e);
			return new TransferResponse();
		}

	}

	@RequestMapping(value = "/dev/withdraw", method = RequestMethod.POST)
	@ResponseBody
	public TransferResponse devWithdraw(@RequestParam("token") String token, @RequestBody TransferRequest transferRequest) {
		try {
			LOGGER.info("Dev withdraw post request catched {},\n token = {}", transferRequest, token);
			String response = VerifyRecaptcha.postVerifyServer(token);
			if (!VerifyRecaptcha.scanJsonNodeSuccess(response)) {
				return  new TransferResponse("", "", 5, "Fail to verify you are not a bot", "");
			};
			
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add(Common.USER_AGENT, Common.USER_AGENT_PROP);
			headers.add(Common.DATATYPE, Common.JSON);
			headers.add(Common.API, Common.WITHDRAW);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			transferRequest.setSerialNo(UUID.randomUUID().toString());
			// MerchantCode must be TEST
			transferRequest.setMerchantCode("TEST");
			HttpEntity<TransferRequest> request = new HttpEntity<TransferRequest>(transferRequest, headers);
			String jsonRes = "";
			if (transferRequest.isKenoOrIlotto() == true) {
				jsonRes = restTemplate.postForObject(env.getProperty("api.dev.keno.target.url"), request, String.class);
			} else {
				jsonRes = restTemplate.postForObject(env.getProperty("api.dev.ilotto.target.url"), request,
						String.class);
			}
			ObjectMapper mapper = new ObjectMapper();
			TransferResponse transferRes = new TransferResponse();
			transferRes = mapper.readValue(jsonRes, TransferResponse.class);
			LOGGER.info("Dev withdraw response body {}", transferRes.toString());
			return transferRes;

		} catch (Exception e) {
			LOGGER.error("Error Dev withdraw: {}", e);
			return new TransferResponse();
		}

	}

	@RequestMapping(value = "/staging/deposit", method = RequestMethod.POST)
	@ResponseBody
	public TransferResponse staingDeposit(@RequestParam("token") String token, @RequestBody TransferRequest transferRequest) {
		try {
			LOGGER.info("Staging deposit post request catched {},\n token = {}", transferRequest, token);
			String response = VerifyRecaptcha.postVerifyServer(token);
			if (!VerifyRecaptcha.scanJsonNodeSuccess(response)) {
				return  new TransferResponse("", "", 5, "Fail to verify you are not a bot", "");
			};
			
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add(Common.USER_AGENT, Common.USER_AGENT_PROP);
			headers.add(Common.DATATYPE, Common.JSON);
			headers.add(Common.API, Common.DEPOSIT);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			transferRequest.setSerialNo(UUID.randomUUID().toString());
			// MerchantCode must be TEST
			transferRequest.setMerchantCode("TEST");
			HttpEntity<TransferRequest> request = new HttpEntity<TransferRequest>(transferRequest, headers);
			String jsonRes = "";
			if (transferRequest.isKenoOrIlotto() == true) {
				jsonRes = restTemplate.postForObject(env.getProperty("api.staging.keno.target.url"), request,
						String.class);
			} else {
				jsonRes = restTemplate.postForObject(env.getProperty("api.staging.ilotto.target.url"), request,
						String.class);
			}
			ObjectMapper mapper = new ObjectMapper();
			TransferResponse transferRes = new TransferResponse();
			transferRes = mapper.readValue(jsonRes, TransferResponse.class);
			LOGGER.info("Staging deposit response body {}", transferRes.toString());
			return transferRes;
		} catch (Exception e) {
			LOGGER.error("Error staging deposit: {}", e);
			return new TransferResponse();
		}

	}

	@RequestMapping(value = "/staging/withdraw", method = RequestMethod.POST)
	@ResponseBody
	public TransferResponse staingWithdraw(@RequestParam("token") String token, @RequestBody TransferRequest transferRequest) {
		try {
			LOGGER.info("Staging withdraw post request catched {},\n token = {}", transferRequest, token);
			String response = VerifyRecaptcha.postVerifyServer(token);
			if (!VerifyRecaptcha.scanJsonNodeSuccess(response)) {
				return  new TransferResponse("", "", 5, "Fail to verify you are not a bot", "");
			};
			
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add(Common.USER_AGENT, Common.USER_AGENT_PROP);
			headers.add(Common.DATATYPE, Common.JSON);
			headers.add(Common.API, Common.WITHDRAW);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			transferRequest.setSerialNo(UUID.randomUUID().toString());
			// MerchantCode must be TEST
			transferRequest.setMerchantCode("TEST");
			HttpEntity<TransferRequest> request = new HttpEntity<TransferRequest>(transferRequest, headers);
			String jsonRes = "";
			if (transferRequest.isKenoOrIlotto() == true) {
				jsonRes = restTemplate.postForObject(env.getProperty("api.staging.keno.target.url"), request,
						String.class);
			} else {
				jsonRes = restTemplate.postForObject(env.getProperty("api.staging.ilotto.target.url"), request,
						String.class);
			}
			ObjectMapper mapper = new ObjectMapper();
			TransferResponse transferRes = new TransferResponse();
			transferRes = mapper.readValue(jsonRes, TransferResponse.class);
			LOGGER.info("Staging withdraw response body {}", transferRes.toString());
			return transferRes;
		} catch (Exception e) {
			LOGGER.error("Error staging withdraw: {}", e);
			return new TransferResponse();
		}

	}

	@RequestMapping(value = "/prod/deposit", method = RequestMethod.POST)
	@ResponseBody
	public TransferResponse prodDeposit(@RequestParam("token") String token, @RequestBody TransferRequest transferRequest) {
		try {
			LOGGER.info("Prod deposit post request catched {},\n token = {}", transferRequest, token);
			String response = VerifyRecaptcha.postVerifyServer(token);
			if (!VerifyRecaptcha.scanJsonNodeSuccess(response)) {
				return  new TransferResponse("", "", 5, "Fail to verify you are not a bot", "");
			};
			
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add(Common.USER_AGENT, Common.USER_AGENT_PROP);
			headers.add(Common.DATATYPE, Common.JSON);
			headers.add(Common.API, Common.DEPOSIT);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			transferRequest.setSerialNo(UUID.randomUUID().toString());
			// MerchantCode must be TEST
			transferRequest.setMerchantCode("TEST");
			HttpEntity<TransferRequest> request = new HttpEntity<TransferRequest>(transferRequest, headers);
			String jsonRes = "";
			if (transferRequest.isKenoOrIlotto() == true) {
				jsonRes = restTemplate.postForObject(env.getProperty("api.prod.keno.target.url"), request,
						String.class);
			} else {
				jsonRes = restTemplate.postForObject(env.getProperty("api.prod.ilotto.target.url"), request,
						String.class);
			}
			ObjectMapper mapper = new ObjectMapper();
			TransferResponse transferRes = new TransferResponse();
			transferRes = mapper.readValue(jsonRes, TransferResponse.class);
			LOGGER.info("Prod deposit response body {}", transferRes.toString());
			return transferRes;
		} catch (Exception e) {
			LOGGER.error("Error prod deposit: {}", e);
			return new TransferResponse();
		}

	}

	@RequestMapping(value = "/prod/withdraw", method = RequestMethod.POST)
	@ResponseBody
	public TransferResponse prodWithdraw(@RequestParam("token") String token, @RequestBody TransferRequest transferRequest) {
		try {
			LOGGER.info("Prod withdraw post request catched {},\n token = {}", transferRequest, token);
			String response = VerifyRecaptcha.postVerifyServer(token);
			if (!VerifyRecaptcha.scanJsonNodeSuccess(response)) {
				return  new TransferResponse("", "", 5, "Fail to verify you are not a bot", "");
			};
			
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add(Common.USER_AGENT, Common.USER_AGENT_PROP);
			headers.add(Common.DATATYPE, Common.JSON);
			headers.add(Common.API, Common.WITHDRAW);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			transferRequest.setSerialNo(UUID.randomUUID().toString());
			// MerchantCode must be TEST
			transferRequest.setMerchantCode("TEST");
			HttpEntity<TransferRequest> request = new HttpEntity<TransferRequest>(transferRequest, headers);
			String jsonRes = "";
			if (transferRequest.isKenoOrIlotto() == true) {
				jsonRes = restTemplate.postForObject(env.getProperty("api.prod.keno.target.url"), request,
						String.class);
			} else {
				jsonRes = restTemplate.postForObject(env.getProperty("api.prod.ilotto.target.url"), request,
						String.class);
			}
			ObjectMapper mapper = new ObjectMapper();
			TransferResponse transferRes = new TransferResponse();
			transferRes = mapper.readValue(jsonRes, TransferResponse.class);
			LOGGER.info("Prod withdraw response body {}", transferRes.toString());
			return transferRes;
		} catch (Exception e) {
			LOGGER.error("Error prod withdraw: {}", e);
			return new TransferResponse();
		}

	}

}
