package textfox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlParser {
	private URL url;
	
	public UrlParser(String url) {
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			System.out.println("Malformed URL\n");
			e.printStackTrace();
		}
	}
	
	public String getHtml() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null)
		sb.append(line);
		return sb.toString();
	}
	
	

}
