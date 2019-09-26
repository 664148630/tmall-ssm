package com.entor.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {

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
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List<T> queryByPage(Class<?> cls,int currentPage,int pageSize);
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
