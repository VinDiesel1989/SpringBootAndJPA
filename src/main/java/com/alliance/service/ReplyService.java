/**
 * 
 */
package com.alliance.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alliance.model.Reply;

/**
 * @author qW
 * @description <em style="color='gray'">TODO</em>
 * @date 2016年4月4日
 * @version 1.0.0
 */
public interface ReplyService {

	Reply  replyByTopic(Reply reply);
	
	Page<Reply> findReplyByPageAndParameters(Map<String, Object> parameters,Pageable pageable);
	
	/**
	 * 点赞
	 * 
	 * @param replyId
	 * @return
	 */
	Reply  clickLike(Long replyId);
}
