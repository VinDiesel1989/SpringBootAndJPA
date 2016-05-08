/**
 * 
 */
package com.alliance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alliance.dao.TopicDao;
import com.alliance.model.Topic;
import com.alliance.service.TopicService;

/**
 * @author qW
 * @description <em style="color='gray'">主贴板块业务处理实现</em>
 * @date 2016年3月7日
 * @version 1.0.0
 */
@Service("topicService")
@Transactional(rollbackFor = Exception.class , transactionManager = "transactionManagerMaster")
public class TopicServiceImpl implements TopicService{

	@Autowired
	private TopicDao topicDao;
	
	@Override
	public List<Topic> findAllTopics() {
		return topicDao.findAll();
	}

	@Override
	public Page<Topic> findTopicByPage(Pageable pageable) {
		Page<Topic> pageTopic = topicDao.findAll(pageable);
		return pageTopic;
	}
	
	
}
