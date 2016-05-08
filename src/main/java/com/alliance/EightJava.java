/**
 * 
 */
package com.alliance;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


/**
 * @author qW
 * @description <em style="color='gray'">TODO</em>
 * @date 2016年1月27日
 * @version 1.0.0
 */
public class EightJava {

	static Map<String, Object> MM = new 	HashMap<String, Object>();
	
	public void  initMM(String key , Object val){
		MM.put(key, val);
	}
	
	public static void main(String[] args) {
		EightJava eightJava = new EightJava();
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("a", "a11");
		parameters.put("b", "b11");
		parameters.put("x", "x33");
		
		parameters.forEach((k,v) -> eightJava.initMM(k , v));
		
		for(Entry<String, Object> en : MM.entrySet()){
			System.out.println(en.getKey() + ":" + en.getValue());
		}
	}
}
