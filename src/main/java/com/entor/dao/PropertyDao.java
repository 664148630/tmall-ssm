package com.entor.dao;

import java.util.List;

import com.entor.entity.Property;

public interface PropertyDao extends BaseDao<Property> {

	/**
	 * ���ݲ�Ʒ����Ų�ѯ����
	 * @param currentPage	��ǰҳ��
	 * @param pageSize		ÿҳ��¼��
	 * @param cid			��Ʒ�����
	 * @return
	 */
	public List<Property> queryPropertysByCid(int currentPage, int pageSize,int cid);
	/**
	 * ��ȡָ����������������ܼ�¼��
	 * @param cid	��Ʒ�����
	 * @return
	 */
	public int getTotalsByCid(int cid);
}
