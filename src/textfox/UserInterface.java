package textfox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class UserInterface {
	
	public static ArrayList<String> linkList = new ArrayList<String>();
	public static ArrayList<String> nameList = new ArrayList<String>();
	public static Stack<String> urlStack = new Stack<String>();
	
	
	public static void main(String args[]) throws IOException {
		
		InputStreamReader inp = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(inp);
		String input = "";
		
		while (true) {
			input = br.readLine();
			if (input.compareTo("B") == 0) { 
				System.out.println("Going back");	//handles going back
				getHtml(urlStack.pop());
			} else if (input.compareTo("Q")==0) {
				System.out.println("Quitting");		//handles quitting
				return;
			} else {
				try {
					int linkNumber = Integer.parseInt(input);	//looks up integer inputs
					System.out.println("Going to " + linkList.get(linkNumber));
					getHtml(linkList.get(linkNumber).substring(1, ( linkList.get(linkNumber).length()-1) ));	
				} catch (NumberFormatException notInt) {
					getHtml(input);						//deals with url inputs
				}
			}
		}
	}
	
	public static void getHtml(String Url) throws IOException {
		urlStack.push(Url);
		UrlParser getter = new UrlParser(Url);
		RegexHtmlParser links = new RegexHtmlParser(getter.getHtml());
		linkList = links.getLink();
		nameList = links.getNames();
		System.out.println("Title: " + links.getTitle());
		printNames(nameList);
	}
	
	public static void printNames(ArrayList<String> nameList) {
		int counter = 0;
		for (String name : nameList) {
			System.out.println(counter + ". " + name);
			counter += 1;
		}
	}

}
