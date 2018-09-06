package com.isscollege.gdce.common.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.isscollege.util.ConnectionPool;

public abstract class BasicDao
{
	private ConnectionPool cp = null;
	private QueryRunner qr = null;
	
	protected BasicDao()
	{
		init();
	}
	
	private void init()
	{
		cp = ConnectionPool.getInstance();
		qr = new QueryRunner();
	}
	
	/**
	 * ����һ�����ݵ����ݿ�
	 * @param sql   �������ݵ�sqlָ�����insert into person(id, name, age) values(?, ?, ?)��
	 * @param paras sql�����Ԥ�����������ֶ����ݣ�����new Object[]{001, "����", 28}��
	 * @return      ���ض����ݿ��ʵ��Ӱ��������0-δ����һ������  n-ʵ�ʲ��������������
	 * @throws SQLException 
	 */
	protected int insert(String sql, Object[] param) throws SQLException
	{
		Connection conn = cp.getConnection();
		int result = qr.update(conn, sql, param);
		release(conn);
		return result;
	}
	
	/**
	 * ɾ��ָ������
	 * @param sql ɾ�����ݵ�sqlָ�����delete from users where id=? and name=?��
	 * @param     sql�����Ԥ�����������ֶ����ݣ�new Object[]{1, "����"}��
	 * @return    ���ض����ݿ��ʵ��Ӱ��������0-δɾ��һ������  n-ɾ���ľ��������� 
	 * @throws SQLException 
	 */
	protected int delete(String sql, Object[] param) throws SQLException
	{
		Connection conn = cp.getConnection();
		int result = qr.update(conn, sql, param); 
		release(conn);
		return result;
	}
	
	/**
	 * �������ݿ�
	 * @param sql �������ݵ�sqlָ�����update users set email=? where id=?��
	 * @param     sql�����Ԥ�����������ֶ����ݣ�new Object[]{"xxx@xxx.com", 1}��
	 * @return    ���ض����ݿ��ʵ��Ӱ��������0-δ����һ������  n-���µľ��������� 
	 * @throws SQLException 
	 */
	protected int update(String sql, Object[] param) throws SQLException
	{
		Connection conn = cp.getConnection();
		int result = qr.update(conn, sql, param); 
		release(conn);
		return result;
	}
	
	/**
	 * ��ѯһ������е�ĳ���ֶε�ֵ
	 * @param name  ���ݿ��ֶ�����
	 * @param sql   ��ѯ���ݵ�sqlָ��
	 * @return      ����һ�������е�һ���ֶ�
	 * 
	 * ע�⣺ȷ����ѯ��sqlֻ����һ������
	 * @throws SQLException 
	 */
	protected Object query(String name,String sql) throws SQLException
	{
		Map<String, Object> result = null;
		Connection conn = cp.getConnection();
		result = qr.query(conn, sql, new MapListHandler()).get(0);
		release(conn);
		return result.get(name);
	}
	
	/**
	 * ��ѯ��������
	 * @param sql       ��ѯ���ݵ�sqlָ��
	 * @param beanClass ��װһ�����ݵ�Bean����
	 * @return          ����һ��Bean���͵�List
	 * @throws SQLException 
	 */
	protected List query(String sql, Class beanClass) throws SQLException
	{
		List result = new ArrayList();
		Connection conn = cp.getConnection();
		result = (List) qr.query(conn, sql, new BeanListHandler(beanClass));
		release(conn);
		return result;
	}
	
	/**
	 * ��ʹ�ý������������·Ż����ӳ�
	 */
	private void release(Connection conn)
	{
		cp.release(conn);
	}
}
