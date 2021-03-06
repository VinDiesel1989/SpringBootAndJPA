/**
 * 
 */
package com.alliance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alliance.model.Indus;
import com.alliance.service.IndusService;
import com.alliance.service.TopicService;

/**
 * @author qW
 * @description <em style="color='gray'">TODO</em>
 * @date 2016年4月1日
 * @version 1.0.0
 */
@RestController
@RequestMapping(value = "/indus")
public class IndusController {

	@Autowired
	private IndusService indusService;
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value = "/list" , method = {RequestMethod.GET} , produces = "application/json; charset=UTF-8")
	public HttpEntity<List<Indus>> list(){
		List<Indus> induss = indusService.findParenIndus();
		return new ResponseEntity<List<Indus>>(induss, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public HttpEntity<Indus> detail(@RequestParam(value = "id")Long id){
		Indus  indus = new Indus();
		indus.setId(911L);
		return new ResponseEntity<Indus>(indus , HttpStatus.OK);

	}
	
	/** JSON转换
	 * 
	 * @param object
	 */
	public void converBeanToJson(Object object){
		if(object instanceof  JSONObject){
			
		}else if(object  instanceof JSONArray){
			
		}
		JSONObject.parseObject("", Indus.class);
	}
	
	public String gitConfictTest(){
		return "这里是CC修改的喔 ,已经提交了.";
	}
}
