/**
 * 
 */
package com.alliance.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alliance.model.Topic;

/**
 * @author qW
 * @description <em style="color='gray'">TODO</em>
 * @date 2016年2月29日
 * @version 1.0.0
 */
public interface TopicService {

	List<Topic> findAllTopics();
	
	Page<Topic> findTopicByPage(Pageable pageable);
}
