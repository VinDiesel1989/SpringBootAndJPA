/**
 * 
 */
package com.alliance.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alliance.dao.ReplyDao;
import com.alliance.model.Reply;
import com.alliance.service.ReplyService;

/**
 * @author qW
 * @description <em style="color='gray'">TODO</em>
 * @date 2016年4月4日
 * @version 1.0.0
 */
@Service("replyService")
@Transactional(rollbackFor=Exception.class,transactionManager = "transactionManagerMaster")
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyDao replyDao;
	
	@Override
	public Reply replyByTopic(Reply reply) {
		if(reply != null){
			reply.setReplyTime(new Date());
			Reply r = replyDao.save(reply);
			return r;
		}
		return null;
	}

	@Override
	public Page<Reply> findReplyByPageAndParameters(Map<String, Object> parameters, Pageable pageable) {
		Page<Reply> pageReply = replyDao.findPageByParameters(parameters, pageable);
		return pageReply;
	}

	@Override
	public Reply clickLike(Long replyId) {
		Reply reply = replyDao.getOne(replyId);
		if(reply != null){
			reply.setPraise(reply.getPraise() + 1);
			replyDao.saveOrUpdate(reply);
			return reply;
		}
		return null;
	}

}
