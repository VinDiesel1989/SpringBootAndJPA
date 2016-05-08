/**
 * 
 */
package com.alliance.dao;

import java.util.List;

import com.alliance.dao.base.MyRepository;
import com.alliance.model.Reply;

/**
 * @author qW
 * @description <em style="color='gray'">TODO</em>
 * @date 2016年4月4日
 * @version 1.0.0
 */
public interface ReplyDao extends MyRepository<Reply, Long>{

	List<Reply> findReplyByTopicId(Long topicId);
}
