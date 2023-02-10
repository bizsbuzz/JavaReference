package com.ip.file;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileComparison {

	private static void printFile(String filePath) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

		String string;
		while ((string = bufferedReader.readLine()) != null)
			System.out.println(string);

	}

	private static void wrapper(String path1, String path2) throws IOException {
		File file1 = new File(path1);
		File file2 = new File(path2);
//        System.out.println("The contents of " + path1 + " is as follows:");
//        printFile(path1);
//        System.out.println("The contents of " + path2 + " is as follows:");
//        printFile(path2);
		System.out.println(String.format("The output of FileUtils.contentEquals(%s, %s) - ", file1.getName(),
				file2.getName()) + FileUtils.contentEquals(file1, file2));
		System.out.println(String.format("The output of FileUtils.contentEqualsIgnoreEOL(%s, %s) - ",
				file1.getName(), file2.getName()) + FileUtils.contentEqualsIgnoreEOL(file1, file2, null));

	}

	public static void main(String[] args) throws IOException {
		// Example 1
		String filePath1 = "src/main/resources/expected_log_win";
		String filePath2 = "src/main/resources/expected_log_linux";
		wrapper(filePath1, filePath2);

		System.out.println("-------");
		// Example 2
		wrapper(filePath1, filePath1);
		wrapper(filePath2, filePath2);

		System.out.println("-------");
		// Example 3
		filePath2 = "src/main/resources/expected_log_win2";
		wrapper(filePath1, filePath2);
	}
}