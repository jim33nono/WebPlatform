import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.ct.lk.result.generator.mark6.ChineseCalendar;

public class Test {

	
	
	public String result(List<Integer> resultList) {
		  Map<Integer, int[]> zodiacMap = ChineseCalendar.getZodiacMap();
		String result = "";
		for (int r : resultList) {
			for (int i = 0; i < 12; i++) {
				int[] array = zodiacMap.get(i);
//				System.out.println(Arrays.asList(array).contains(r));
				if (Arrays.asList(array).contains(r)) {
					result += i + ",";
				}
			}
		}
		if (result.length() > 0)
			return result;
		else
			return null;
	}
	
	public static void main(String args[]) {
	
		
			String url = "http://www.penghu-nsa.gov.tw/FileDownload/Album/Big/20161012162551758864338.jpg";  
			String fullName = "/Users/lynnchen";  
			File targetFile = new File(fullName);  
			int connectionTimeout = 10000;  
			int readTimeout = 15000;  
			try {
				FileUtils.copyURLToFile(new URL(url), targetFile, connectionTimeout, readTimeout);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}  
	}

}
