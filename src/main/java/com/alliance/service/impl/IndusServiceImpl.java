/**
 * 
 */
package com.alliance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alliance.dao.IndustryDao;
import com.alliance.model.Indus;
import com.alliance.service.IndusService;

/**
 * @author qW
 * @description <em style="color='gray'">行业分类</em>
 * @date 2016年4月1日
 * @version 1.0.0
 */
@Service("IndusService")
@Transactional(readOnly = true , transactionManager = "transactionManagerMaster")
public class IndusServiceImpl implements IndusService{

	@Autowired
	private IndustryDao industryDao;
	
	@Override
	public List<Indus> findParenIndus() {
		List<Indus> indusList = industryDao.findIndusByIndexAndAvailable(1, true);
		return indusList;
	}

}
