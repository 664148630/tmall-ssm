package com.entor.dao.impl;

import org.springframework.stereotype.Repository;

import com.entor.dao.OrderitemDao;
import com.entor.entity.Orderitem;
@Repository("orderitemDao")
public class OrderitemDaoImpl extends BaseDaoImpl<Orderitem> implements OrderitemDao {

}
