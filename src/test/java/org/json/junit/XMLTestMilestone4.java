package org.json.junit;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;

public class XMLTestMilestone4 {
	/*
{"Books": {"book": [
    {
        "author": "ASmith",
        "title": "AAA"
    },
    {
        "author": "BSmith",
        "title": "BBB"
    }
]}}

	 */

	@Test
	public void test1() {
		System.out.println("TEST 1 : PRINT OUT ALL NODES\n");
		JSONObject obj = XML.toJSONObject("<Books><book><title>AAA</title><author>ASmith</author></book><book><title>BBB</title><author>BSmith</author></book></Books>");
		obj.toStream().forEach(node -> System.out.println(node));
	}
	
	@Test
	public void test2() {
		System.out.println("--------------------------------------");
		System.out.println("\nTEST 2 : PRINT OUT ALL KEY(PATH) FROM NODES \n");
		JSONObject obj = XML.toJSONObject("<Books><book><title>AAA</title><author>ASmith</author></book><book><title>BBB</title><author>BSmith</author></book></Books>");
		List<Object> list = obj.toStream().map(node -> ((HashMap<?, ?>) node).keySet()).collect(Collectors.toList());
		System.out.println(list);
	}
	
	@Test
	public void test3() {
		System.out.println("--------------------------------------");
		System.out.println("\nTEST 3 : PRINT OUT ALL NODES WITH VALUE 'AAA' \n");
		JSONObject obj = XML.toJSONObject("<Books><book><title>AAA</title><author>ASmith</author></book><book><title>BBB</title><author>BSmith</author></book></Books>");
		obj.toStream().forEach(node -> {
			if (((HashMap<?,?>) node).containsValue("AAA"))
				System.out.println(node);
		});
	}
	
	@Test
	public void test4() {
		System.out.println("--------------------------------------");
		System.out.println("\nTEST 4 : PRINT OUT NODE FOR PATH 'Books/book/1/title' \n");
		JSONObject obj = XML.toJSONObject("<Books><book><title>AAA</title><author>ASmith</author></book><book><title>BBB</title><author>BSmith</author></book></Books>");
		List<Object> list = obj.toStream().filter(node -> ((HashMap<?,?>) node).keySet().contains("Books/book/1/title")).collect(Collectors.toList());
		System.out.println(list);
	}

}
