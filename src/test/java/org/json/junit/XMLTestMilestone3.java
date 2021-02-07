package org.json.junit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONPointer;
import org.json.XML;
import org.json.XML.YOURTYPEHERE;
import org.junit.Test;

public class XMLTestMilestone3 {

	@Test
	public void test1() throws FileNotFoundException {
		
		System.out.println("TEST 1 \nTransform key + _TESTING\n");
		
		FileReader file = new FileReader("src/test/java/org/json/junit/test.xml");
		
		YOURTYPEHERE keyTransformer = (String s) -> s.concat("_TESTING");
		
		JSONObject json = XML.toJSONObject(file, keyTransformer);
		
		System.out.println(json.toString(4));
		
	}
	
	@Test
	public void test2() throws FileNotFoundException {
		
		System.out.println("TEST 2 \nTransform swe262_ + Key\n");
		
		FileReader file = new FileReader("src/test/java/org/json/junit/test.xml");
		
		YOURTYPEHERE keyTransformer = (String s) -> "swe262_".concat(s);
		
		JSONObject json = XML.toJSONObject(file, keyTransformer);
		
		System.out.println(json.toString(4));
		
	}
	
	@Test
	public void test3() throws FileNotFoundException {
		
		System.out.println("TEST 3 \nReverse characters of Key \n ex) foo -> oof\n");
		
		FileReader file = new FileReader("src/test/java/org/json/junit/test.xml");
		
		YOURTYPEHERE keyTransformer = (String s) -> new StringBuilder(s).reverse().toString();
		
		JSONObject json = XML.toJSONObject(file, keyTransformer);
		
		System.out.println(json.toString(4));
		
	}

}
