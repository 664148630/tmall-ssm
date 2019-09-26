package com.entor.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.PropertyDao;
import com.entor.entity.Property;
import com.entor.service.PropertyService;

@Service("propertyService")
public class PropertyServiceImpl extends BaseServiceImpl<Property> implements PropertyService {

	@Resource
	private PropertyDao propertyDao;
	@Override
	public List<Property> queryPropertysByCid(int currentPage, int pageSize, int cid) {

		return propertyDao.queryPropertysByCid(currentPage, pageSize, cid);
	}

	@Override
	public int getTotalsByCid(int cid) {
		return propertyDao.getTotalsByCid(cid);
	}

}
