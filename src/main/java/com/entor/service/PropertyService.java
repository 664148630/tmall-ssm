package com.entor.service;

import java.util.List;

import com.entor.entity.Property;

public interface PropertyService extends BaseService<Property> {

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
