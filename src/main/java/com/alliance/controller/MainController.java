/**
 * 
 */
package com.alliance.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alliance.model.Topic;
import com.alliance.service.TopicService;

/**
 * @author qW
 * @description <em style="color='gray'">主页</em>
 * @date 2016年3月6日
 * @version 1.0.0
 */
@RestController
@RequestMapping(value = "/")
public class MainController implements WebBindingInitializer {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value = "/home" , method = {RequestMethod.GET})
	public ModelAndView home(){
		ModelAndView view =new ModelAndView("index");
		List<Topic> topics = topicService.findAllTopics();
		view.addObject("topics", topics);
		return view;
	}
	
	@RequestMapping(value = "topics" , method ={RequestMethod.GET} , produces="application/json; charset=UTF-8")
	public HttpEntity<PagedResources<Resource<Topic>>> topics(Pageable pageable,PagedResourcesAssembler<Topic> assembler){
		Page<Topic> topics = topicService.findTopicByPage(pageable);
		PagedResources<Resource<Topic>> resouces =  assembler.toResource(topics);
		return new ResponseEntity<>( resouces, HttpStatus.OK) ;
	}
	
	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor dateEditor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	
}
