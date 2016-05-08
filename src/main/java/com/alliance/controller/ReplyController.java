/**
 * 
 */
package com.alliance.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alliance.model.Reply;
import com.alliance.service.ReplyService;
import com.alliance.service.UserService;

/**
 * @author qW
 * @description <em style="color='gray'">回帖</em>
 * @date 2016年4月4日
 * @version 1.0.0
 */
@RestController
@RequestMapping(value = "/reply")
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private UserService userSerivce;
	
	/**
	 * 回复主贴
	 * 
	 * @param userId
	 * @param topicId
	 * @param replyContext
	 * @return
	 */
	@RequestMapping(value = "/commit" , method = {RequestMethod.GET} , produces="application/json; charset=UTF-8")
	public HttpEntity<Reply> reply(@RequestParam(value = "userId")Long userId , @RequestParam("topicId")Long topicId ,
			@RequestParam("replyContext")String replyContext){
		Reply reply  = new Reply();
		reply.setReplyUser(userSerivce.findUserById(userId));
		reply.setReplyContext(replyContext);
		reply.setTopicId(topicId);
		Reply result = replyService.replyByTopic(reply);
		return new ResponseEntity<Reply>(result, HttpStatus.OK);
	}
	
	/**
	 * 回复列表
	 * 
	 * @param topicId
	 * @param pageable
	 * @param assembler
	 * @return
	 */
	@RequestMapping(value = "/{topicid}/list" , method = {RequestMethod.POST} , produces = "application/json; charset=UTF-8")
	public HttpEntity<PagedResources<Resource<Reply>>> replys(@PathVariable(value = "topicid")Long topicId,
			Pageable pageable,PagedResourcesAssembler<Reply> assembler){
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("topicId", topicId);
		Page<Reply> pageReply = replyService.findReplyByPageAndParameters(parameters, pageable);
		PagedResources<Resource<Reply>> resources = assembler.toResource(pageReply);
		return new ResponseEntity<PagedResources<Resource<Reply>>>(resources, HttpStatus.OK);
	}
	
	/**
	 * 点赞
	 * 
	 * @param replyId
	 * @return
	 */
	@RequestMapping(value = "/like" , method = {RequestMethod.POST} , produces = "application/json;charset=UTF-8")
	public HttpEntity<Reply> like(@RequestParam("replyId")Long replyId){
		Reply  reply = replyService.clickLike(replyId);
		return new ResponseEntity<Reply>(reply , HttpStatus.OK);
	}
	
}
