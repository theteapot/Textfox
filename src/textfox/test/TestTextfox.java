package textfox.test;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import textfox.RegexHtmlParser;
import textfox.UserInterface;

public class TestTextfox {
	@Test
	public void TestRegexHtmlParser() throws IOException {
		FileStringReader fileReader = new FileStringReader("/home/tkettle/documents/openmrs-lectures/EH201 Advanced Java/Public/Exercises/04 Regular Expressions/test1.html");
		String contents = fileReader.readAll();
		fileReader.close();
		RegexHtmlParser testParser = new RegexHtmlParser(contents);
		testParser.getLinks();
		Assert.assertEquals("[[http://google.com], [http://www.yahoo.fr], [http://pih.org], [http://rita.gov.rw], [http://rita.gov.rw], [http://news.bbc.co.uk], [http://cnn.com], [http://facebook.com]]", testParser.getLink().toString() );
		Assert.assertEquals("[[Google], [Yahoo], [PIH], [RITA], [http://rita.gov.rw], [BBC News], [CNN News], [http://facebook.com]]", testParser.getNames().toString());
		Assert.assertEquals("[Test 1]", testParser.getTitle());
	}
	
	public void TestUserInterface() {
		UserInterface testUserInterface = new UserInterface();
		
	}
}

