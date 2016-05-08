/**
 * 
 */
package com.alliance.dao;

import com.alliance.dao.base.MyRepository;
import com.alliance.model.WeiXin;

/**
 * @author qW
 * @description <em style="color='gray'">微信数据DAO</em>
 * @date 2016年2月23日
 * @version 1.0.0
 */
public interface WeiXinDao extends MyRepository<WeiXin, Long>{

	WeiXin  findWeiXinById(Long id);
}
