package com.entor.dao;

import java.util.List;

import com.entor.entity.Product;

public interface ProductDao extends BaseDao<Product> {

	/**
	 * ���ݲ�Ʒ����Ų�ѯ����
	 * @param currentPage	��ǰҳ��
	 * @param pageSize		ÿҳ��¼��
	 * @param cid			��Ʒ�����
	 * @return
	 */
	public List<Product> queryProductsByCid(int currentPage, int pageSize,int cid);
	/**
	 * ��ȡָ����������������ܼ�¼��
	 * @param cid	��Ʒ�����
	 * @return
	 */
	public int getTotalsByCid(int cid);
}
