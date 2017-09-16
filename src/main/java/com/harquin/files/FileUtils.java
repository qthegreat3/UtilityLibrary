package com.harquin.files;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	public static List<String> readInTextFile(String fileName)
	{
		if(fileName == null)
		{
			throw new IllegalArgumentException("File Name: " + fileName + " Cannot Be Null");
		}
		
		if (fileName.isEmpty())
		{
			throw new IllegalArgumentException("File Name: " + fileName + " Cannot Be Empty");
		}
		
		List<String> linesOfFiles = new ArrayList<String>();
		
		BufferedReader read = null;
		
		try {
			 read = new BufferedReader(new FileReader(fileName));
			String line;
			
			while ((line = read.readLine()) != null)
			{
				linesOfFiles.add(line);				
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}
		finally
		{
			if(read != null)
			{
				try {
					read.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return linesOfFiles;
	}

	public static void writeTextToFile(String fileName, List<String> text)
	{
		writeTextToFile(fileName, text, false);
	}

	public static void writeTextToFile(String fileName, List<String> text, boolean isAppend)
	{
		try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName, isAppend);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
			for ( String line : text)
			{
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
	}
	
	public static void appendTextToFile(String fileName, List<String> text)
	{
		writeTextToFile(fileName, text, true);
	}
}