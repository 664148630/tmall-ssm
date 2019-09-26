package com.entor.dao;

import java.util.List;

import com.entor.entity.Property;

public interface PropertyDao extends BaseDao<Property> {

	/**
	 * 根据产品类别编号查询属性
	 * @param currentPage	当前页码
	 * @param pageSize		每页记录数
	 * @param cid			产品类别编号
	 * @return
	 */
	public List<Property> queryPropertysByCid(int currentPage, int pageSize,int cid);
	/**
	 * 获取指定类别下所有属性总记录数
	 * @param cid	商品类别编号
	 * @return
	 */
	public int getTotalsByCid(int cid);
}
