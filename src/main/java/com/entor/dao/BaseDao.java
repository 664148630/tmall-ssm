package com.entor.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

	/**
	 * ����
	 * @param t
	 */
	public void add(T t);
	/**
	 * �޸�
	 * @param t
	 */
	public void update(T t);
	/**
	 * ��������ɾ��
	 * @param cls
	 * @param id
	 */
	public void deleteById(Class<?> cls,Serializable id);
	/**
	 * ����������ѯ
	 * @param cls
	 * @param id
	 * @return
	 */
	public T queryById(Class<?> cls,Serializable id);
	/**
	 * ��ҳ��ѯ
	 * @param cls
	 * @param map
	 * @return
	 */
	public List<T> queryByPage(Class<?> cls,Map<String,Integer> map);
	/**
	 * ��ѯ�ܼ�¼��
	 * @param cls
	 * @return
	 */
	public int getTotals(Class<?> cls);
	
	/**
	 * ��ѯȫ����Ϣ
	 * @param cls
	 * @return
	 */
	public List<T> queryAll(Class<?> cls);
}
