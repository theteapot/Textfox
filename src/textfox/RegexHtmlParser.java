package textfox;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.spi.LocaleNameProvider;

public class RegexHtmlParser {
	
	private String html;
	private String title;
	private ArrayList<String> links = new ArrayList<String>();
	private ArrayList<String> names = new ArrayList<String>();
	
	
	public RegexHtmlParser(String html) {
		this.html = html;
	}
	
	public ArrayList<String> getLink() {
		return this.links;
	}
	
	public String getTitle() {
		title = regexMatcher(this.html, "<title>[\\s\\S]*?</title>").toString();
		title = title.replaceAll("(<title>)|(</title>)", "");
		return this.title;
	}
	
	public ArrayList<String> getNames() {
		return this.names;
	}
	
	public void getLinks() {
		ArrayList<String> anchors = regexMatcher(this.html,"<a.*?/a>");
		for (String link : anchors) {
			links.add(regexMatcher(link, "\"http://(.*?)\"").toString().replaceAll("\"",""));
			names.add(regexMatcher(link, ">.*?<").toString().replaceAll("[<>]",""));
		}
	}
	
	private static ArrayList<String> regexMatcher(String searchString, String expression){

		Pattern regex = Pattern.compile(expression);
		Matcher matcher = regex.matcher(searchString);
		
		ArrayList<String> matchedString = new ArrayList<String>();
		while (matcher.find()) {
			String group = matcher.group();
			int start = matcher.start();
			int end = matcher.end();
			matchedString.add(searchString.substring(start, end));
		} 
		return matchedString;
	}
}
