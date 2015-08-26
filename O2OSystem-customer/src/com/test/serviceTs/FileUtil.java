package com.test.serviceTs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class FileUtil {
	public static byte[] converPathTobyteArr(String path) throws Exception {
		String filePath = path;
		File inFile = new File(filePath);
		InputStream fis = new FileInputStream(inFile);
		byte[] bytes = null;
		try {
		bytes = new byte[fis.available()];
		fis.read(bytes);
		fis.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		return bytes;
		}
}
