import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;


public class PostApi {
	private static final Logger LOGGER = LoggerFactory.getLogger(PostApi.class);
	
	public static void main(String[] args)  {
		// RestTemplate restTemplate = new RestTemplate();
		// JasonTest jasonTest =
		// restTemplate.postForObject("http://localhost:8091/Web_Platform/jasonTest.do",
		// null, JasonTest.class);
		// System.out.println(jasonTest.getData1());

//		HttpClient httpclient = new DefaultHttpClient();
//		HttpPost httppost = new HttpPost("http://localhost:8091/Web_Platform/jasonTest.do");
//
//		// Request parameters and other properties.
//		List<NameValuePair> params = new ArrayList<NameValuePair>();
//		try {
//			httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
//
//			// Execute and get the response.
//			HttpResponse response = httpclient.execute(httppost);
//			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//			String line = "";
//			if ((line = rd.readLine()) != null) {
//
//				try {
//					LOGGER.info("Return code after update [draw]: {}", line);
//					ObjectMapper mapper = new ObjectMapper();
//					AuthorizeResponse uthorizeResponse = mapper.readValue(line, AuthorizeResponse.class);
//					LOGGER.info("Return code after update [draw]: {}", uthorizeResponse);
//					EntityUtils.consume(response.getEntity());
//				} finally {
//					rd.close();
//				}
//			}
//
//		} catch (Exception e) {
//			LOGGER.error( "call self api error! {}", e );
//		}
		
		RestTemplate restTemplate = new RestTemplate();
		String str = restTemplate.postForObject(
				"http://api.ilotto.qqcp518.com/-/auth?targetUrl=http://10.10.2.120:8090/webplatform/accountAuth.do", null,
				String.class);
		str = str.substring(18);
		System.out.println(str);
//		restTemplate.postForLocation(
//				"http://api.ilotto.qqcp518.com/-/auth",
//				String.class);

	}

}
