package textfox.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * File reader class for reading entire contents of file into a string
 * @author Rowan
 */
public class FileStringReader extends FileReader {

	/**
	 * Constructs this file string reader from a file name
	 * @param fileName the file name to open
	 * @throws FileNotFoundException
	 */
	public FileStringReader(String fileName) throws FileNotFoundException {
		super(fileName);
	}

	/**
	 * Reads the entire contents of a file into a string
	 * @return A string
	 * @throws IOException
	 */
	public String readAll() throws IOException {
		StringBuilder contents = new StringBuilder();

		BufferedReader input = new BufferedReader(this);
		try {
			String line = null;
			while ((line = input.readLine()) != null) {
				contents.append(line);
				contents.append(System.getProperty("line.separator"));
			}
		} finally {
			input.close();
		}

		return contents.toString();
	}
}