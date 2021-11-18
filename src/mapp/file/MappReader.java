package mapp.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import mapp.MappMain;

public class MappReader {

    public static String readFile(String filename, String separator) {
		String line = "";

		String singleLine = "mappREADER";
		InputStream source = MappMain.getMain().getClass().getResourceAsStream(filename);
		InputStream inputStream = new BufferedInputStream(source);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		try {
            while ((singleLine = reader.readLine()) != null) {
            	if (!singleLine.equals("")) {
            		line += singleLine;
            		line += separator;
            	}

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return line;
	}
    
}
