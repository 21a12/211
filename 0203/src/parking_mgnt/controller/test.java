package parking_mgnt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		
		List<Map<String, Integer>> test = new ArrayList<>();
		
		Map<String,Integer> aa = new HashMap<>();
		aa.put("a", 1);
		aa.put("b", 2);
		
		test.add(aa);
		
		System.out.println(test);
		
	}
}
