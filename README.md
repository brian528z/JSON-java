SWE 262P Project
Tae Hyun Lee
----------------

Milestone 2
===========

Unit tests : XMLTestMilestone2.java


Milestone 3
===========

Unit tests : XMLTestMilestone3.java

- Test1 = key + _TESTING
- Test2 = swe262_ + key
- Test3 = reversed key

---------

New Functions :
- public static JSONObject toJSONObject(Reader reader, YOURTYPEHERE keyTransformer)
- public interface YOURTYPEHERE
- public static JSONObject toJSONObject3(Reader reader, config, YOURTYPEHERE keyTransformer)
- public static parse3

---------

Performance :

- For Milestone 1, the whole json was initally read to a json object, and saved all the keys to an iterator. Then, the function iterates with recursion based on whether the key is an json object or an json array. After looping through its inner contents,it goes through the remainder keys and transforms the key. 
- For Milestone 3, I do not have to read a seperate iterator of keys, but instead save the tagName to the transformed version during the parsing of the XML file. The whole process is the same as a normal parse, but instead just updating the key while it is parsing. toJSONObject3 and parse3 is just a copy of the originally implemented functions, except for adding the transformation to the tagName, and taking the YOURTYPEHERE as parameters. The rest of the code is identical to the given functions.
- In performance-wise, Milestone 3 takes the same time and efficiency as just parsing the XML file to json, while Milestone 1 takes atleast over 2 loops to iterate through the parsed JSON for keys to be updated.

Milestone4
==========

Unit tests : XMLTestMilestone4.java

- Test 1 = Print out all nodes (forEach)
- Test 2 = Print out all KEY (path) from nodes (map) 
- Test 3 = Print out all nodes with specific VALUE (forEach)
- Test 4 = Print out all nodes with specific KEY (filter)

------

New Functions :
 - addToStream 
 - toStream
 
------
Created a Stream<Object> that holds information of the path and the actual value of each JSONObject.