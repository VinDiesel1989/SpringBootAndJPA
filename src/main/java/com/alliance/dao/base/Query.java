/**
 * 
 */
package com.alliance.dao.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * @author qW
 * @description <em style="color='gray'">TODO</em>
 * @date 2016年4月6日
 * @version 1.0.0
 */
public class Query<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8310575437112975075L;
	private static final Log LOGGER = LogFactory.getLog(Query.class);
	
	private final static String LIKE_SYMBOL = "%";
	
	private Class<T> clazz;
	private Root<T>  from;
	private List<Predicate> predicates;
	private CriteriaQuery<T> criteriaQuery;
	private CriteriaBuilder criteriaBuilder;
	private List<Order>  orders;
	
	private Map<String, Query<T>> subQuery;
	private Map<String, Query<T>> linkQuery;
	private String projection;
	private List<Query<T>> orQuery;
	private String groupBy;
	
	public Query(){
		
	}
	
	public Query(Class clazz , Root from , CriteriaQuery cq , CriteriaBuilder cb){
		this.clazz = clazz;
		this.from = from;
		this.criteriaQuery = cq;
		this.criteriaBuilder = cb;
		predicates = new ArrayList<Predicate>();
		orders = new ArrayList<>();
	}
	
	private void addSubQuery(String propertyName , Query query){
		if(subQuery == null){
			subQuery = new HashMap<String, Query<T>>();
		}
		if(query.projection == null){
			throw new RuntimeException("子查询字段未设置");
		}
		subQuery.put(propertyName, query);
	}
	
	private void addSubQuery(Query query){
		addSubQuery(query.projection, query);
	}
	
	private void addLinkQuery(String propertyName , Query query){
		if(linkQuery == null){
			linkQuery = new HashMap<>();
		}
		linkQuery.put(propertyName, query);
	}
	
	/**
	 * 相等(=)
	 * 
	 * @param propertyName
	 * @param value
	 */
	public void eq(String propertyName , Object value){
		if(StringUtils.isEmpty(value)){
			return;
		}
		predicates.add(criteriaBuilder.equal(from.get(propertyName), value)) ; 
	}
	
	/**
	 * 或者相等
	 * 
	 * @param propertyNames
	 * @param val
	 */
	public void orEql(List<String> propertyNames , Object val){
		if(ObjectUtils.isEmpty(val)){
			return;
		}
		if(CollectionUtils.isEmpty(propertyNames)){
			return;
		}
		Predicate predicate = criteriaBuilder.or(criteriaBuilder.equal(from.get(propertyNames.get(0)), val));
		for(int i =1 ; i < propertyNames.size() ; i ++){
			predicate = criteriaBuilder.or(predicate, criteriaBuilder.equal(from.get(propertyNames.get(i)), val));
		}
		predicates.add(predicate);
	}
	
	/**
	 * 或者Like
	 * 
	 * @param propertyNames
	 * @param val
	 */
	public void orLike(List<String> propertyNames , String val){
		if(StringUtils.isEmpty(val) || CollectionUtils.isEmpty(propertyNames)){
			return;
		}
		if(val.indexOf(LIKE_SYMBOL) < 0){
			val = LIKE_SYMBOL + val + LIKE_SYMBOL;
		}
		Predicate predicate = criteriaBuilder.or(criteriaBuilder.like(from.get(propertyNames.get(0)), val));
		for(int i = 1;  i < propertyNames.size(); i ++){
			predicate = criteriaBuilder.or(predicate , criteriaBuilder.like(from.get(propertyNames.get(0)), val));
		}
		predicates.add(predicate);
	}
	
	

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	public Root<T> getFrom() {
		return from;
	}

	public void setFrom(Root<T> from) {
		this.from = from;
	}

	public List<Predicate> getPredicates() {
		return predicates;
	}

	public void setPredicates(List<Predicate> predicates) {
		this.predicates = predicates;
	}

	public CriteriaQuery<T> getCriteriaQuery() {
		return criteriaQuery;
	}

	public void setCriteriaQuery(CriteriaQuery<T> criteriaQuery) {
		this.criteriaQuery = criteriaQuery;
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return criteriaBuilder;
	}

	public void setCriteriaBuilder(CriteriaBuilder criteriaBuilder) {
		this.criteriaBuilder = criteriaBuilder;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Map<String, Query<T>> getSubQuery() {
		return subQuery;
	}

	public void setSubQuery(Map<String, Query<T>> subQuery) {
		this.subQuery = subQuery;
	}

	public Map<String, Query<T>> getLinkQuery() {
		return linkQuery;
	}

	public void setLinkQuery(Map<String, Query<T>> linkQuery) {
		this.linkQuery = linkQuery;
	}

	public String getProjection() {
		return projection;
	}

	public void setProjection(String projection) {
		this.projection = projection;
	}

	public List<Query<T>> getOrQuery() {
		return orQuery;
	}

	public void setOrQuery(List<Query<T>> orQuery) {
		this.orQuery = orQuery;
	}

	public String getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}
	
	
}
