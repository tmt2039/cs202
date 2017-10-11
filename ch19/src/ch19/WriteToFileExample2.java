package ch19;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileExample2 {

	private static final String FILENAME = "E:\\test\\filename.txt";

	public static void main(String[] args) {

		try (BufferedWriter buffW = new BufferedWriter(new FileWriter(FILENAME))) {

			String content = "This is the content to write into file\n";

			buffW.write(content);

			// no need to close it.
			//bw.close();

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}