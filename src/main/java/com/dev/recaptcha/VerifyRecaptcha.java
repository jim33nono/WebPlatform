package com.dev.recaptcha;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.dev.api.request.Common;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VerifyRecaptcha {
	private final static Logger LOGGER = LoggerFactory.getLogger(VerifyRecaptcha.class);

	public static final String URL = "https://www.google.com/recaptcha/api/siteverify";
	public static final String SECRET_KEY = "6LeoBE0UAAAAAHt4N7v90t1nrLXW35pxNSmC0y_G";
	public static final String ACCEPT_LANGUAGE = "Accept-Language";
	public static final String ACCEPT_LANGUAGE_PROP = "en-US,en;q=0.5";
	public static final String TOKEN = "03ANcjosoon6oLQf_ZLRepzPXhn4snjhD55oL0DEFWPV7G_tacVGZCIVNxrBvr-qgCI0xDDCmU13rI71PidMmUHUAWPR74DgF_eoWLK48IgVMpcTPpPOYnPK0X-CSLFIKXxakuOVlvHjosc9Gj9y9fq_YouzpExlRXudCYD3feoVDOiggZ8ZPHJ8c8ymyzHZReZEaGcagVGgt_87C4ruj26b8Au0z5LQ_zqwjEmnU4rCcRdnSMZHj1m9nVCKD17zix_qPjQEhXC9v4ykVvkIK3XcC2AX_2emDCY9mZ-lCBDq7Xn13jhUXoyTKN4k-nkR55vPyGcAY43UNT";
	
	public static String postVerifyServer(String token) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> request = new HttpEntity<Object>(initReqBody(SECRET_KEY, token), initHeaders());
		String jsonRes = "";
		jsonRes = restTemplate.postForObject(URL, request, String.class);
		return jsonRes;
	}

	public static MultiValueMap<String, String> initHeaders() {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add(Common.USER_AGENT, Common.USER_AGENT_PROP);
		headers.add(ACCEPT_LANGUAGE, ACCEPT_LANGUAGE_PROP);
		return headers;
	}

	public static MultiValueMap<String, String> initReqBody(String secretKey, String responseToken) {
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("secret", secretKey);
		body.add("response", responseToken);
		return body;
	}
	
	public static boolean scanJsonNodeSuccess(String response) {
		try {
			JsonNode rootNode = new ObjectMapper().readTree(response);
			JsonNode successField = rootNode.get("success");
			boolean successBoolean = successField.asBoolean();
			return successBoolean;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

	public static void main(String[] args) {
		String response = VerifyRecaptcha.postVerifyServer(TOKEN);
		LOGGER.info(response);
		System.out.println(VerifyRecaptcha.scanJsonNodeSuccess(response));

	}

}
