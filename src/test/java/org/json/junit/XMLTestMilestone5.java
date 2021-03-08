package org.json.junit;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.json.JSONObject;
import org.json.XML;
import org.json.XML.FUNCTION1;
import org.json.XML.FUNCTION2;
import org.junit.Test;

public class XMLTestMilestone5 {

	@Test
	public void test1() throws IOException {
		
		System.out.println("Test 1 : Correct output with no exception \n");
		
		FileReader inputFile= new FileReader("src/test/java/org/json/junit/test.xml");
		Writer outputFile = new FileWriter("src/test/java/org/json/junit/result.json");
		
		JSONObject test = XML.toJSONObject(inputFile, (FUNCTION1) (JSONObject jo) -> {jo.write(outputFile);}, (FUNCTION2) (Exception e) -> {System.out.println("Exception is " + e); });
		
		outputFile.close();
	}
	
	@Test
	public void test2() throws IOException {
		
		System.out.println("\n\nTest 2 : Incorrect output with exception \n");
		
		FileReader inputFile= new FileReader("src/test/java/org/json/junit/test2.xml");
		FileWriter outputFile = new FileWriter("src/test/java/org/json/junit/result2.json");
		
		XML.toJSONObject(inputFile, (FUNCTION1) (JSONObject jo) -> {jo.write(outputFile);}, (FUNCTION2) (Exception e) -> {System.out.println("Exception is " + e); });

		outputFile.close();
	}

}
