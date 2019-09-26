package com.entor.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.PropertyDao;
import com.entor.entity.Property;
@Repository("propertyDao")
public class PropertyDaoImpl extends BaseDaoImpl<Property> implements PropertyDao {

	@Override
	public List<Property> queryPropertysByCid(int currentPage, int pageSize, int cid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage", (currentPage-1)*pageSize);
		map.put("pageSize", currentPage*pageSize);
		map.put("cid", cid);
		return getSqlSession().selectList(Property.class.getSimpleName()+".queryPropertysByCid",map);
	}

	@Override
	public int getTotalsByCid(int cid) {
		return getSqlSession().selectOne(Property.class.getSimpleName()+".getTotalsByCid",cid);
	}

}
