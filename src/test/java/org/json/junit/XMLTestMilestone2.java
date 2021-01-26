package org.json.junit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONPointer;
import org.json.XML;
import org.junit.Test;

public class XMLTestMilestone2 {
	
	/*
	 * Part 1 : toJSONObject(File file, JSONPointer pointer);
	 * 		- created toJSONObject1 and parse1, which is a revised version of the original methods
	 * 		- Once it finds the object, it does not read through the rest of the xml file
	 * 
	 * PERFORMANCE GAINS
	 * - In milestone1, I used a queryFrom with JSONPointer, which reads through the whole json object to find the path.
	 * However, by using the libraries, I am able to stop once I find the path, instead of reading through the whole json object.
	 * 
	 */

	@Test
	public void part1test1() throws FileNotFoundException {
		
		FileReader file = new FileReader("src/test/java/org/json/junit/test.xml");
		String query = "/catalog";
		JSONPointer pointer = new JSONPointer(query);
		
		
		JSONObject json = XML.toJSONObject(file, pointer);
		
		System.out.println("\n\nTesting : " + query + "\n\n" + json.toString(4));
		
	}
	
	@Test
	public void part1test2() throws FileNotFoundException {
		
		FileReader file = new FileReader("src/test/java/org/json/junit/test.xml");
		String query = "/test/book/1";
		JSONPointer pointer = new JSONPointer(query);
		
		
		JSONObject json = XML.toJSONObject(file, pointer);
		
		System.out.println("\n\nTesting : " + query + "\n\n" + json.toString(4));
		
	}
	
	/*
	 * Part 2 : toJSONObject(File file, JSONPointer pointer, JSONObject replacement);
	 * 		- modified toJSONObject1 and parse1 from previous methods to toJSONObject2 and parse2
	 * 		- Just like the previous method, it reads the XML until the query is found
	 * 		- instead of returning the object found in the query, it replaces it with the custom object that user provided
	 * 		- After the replacement is finished, it reads through the file normally.
	 * 
	 * PERFORMANCE GAINS
	 * - In Milestone 1, I read the whole xml file into a json object, turned it into a string, and manually replaced the original string and new string 
	 * by using a queryFrom method. I had to read the file 2 times and then do the replacement. However, in this library, I only still read the file once, 
	 * since I replace the new object as I read through the file(once the query is found).
	 */
	
	@Test
	public void part2test1() throws FileNotFoundException {
		
		FileReader file = new FileReader("src/test/java/org/json/junit/test.xml");
		String query = "/test";
		JSONPointer pointer = new JSONPointer(query);
		
		String customObject = "{\"name\":\"test_name\",\"test\":\"working\",\"age\":\"1234\"}";
		JSONObject replacement = new JSONObject(customObject);
		
		
		JSONObject json = XML.toJSONObject(file, pointer, replacement);
		
		System.out.println("\n\nReplacing : " + query + "\n\n" + json.toString(4));
		
	}
	
	@Test
	public void part2test2() throws FileNotFoundException {
		
		FileReader file = new FileReader("src/test/java/org/json/junit/test.xml");
		String query = "/catalog/book/3";
		JSONPointer pointer = new JSONPointer(query);
		
		String customObject = "{\"name\":\"test_name\",\"test\":\"working\",\"age\":\"1234\"}";
		JSONObject replacement = new JSONObject(customObject);
		
		
		JSONObject json = XML.toJSONObject(file, pointer, replacement);
		
		System.out.println("\n\nReplacing : " + query + "\n\n" + json.toString(4));
		
	}

}
