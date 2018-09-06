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
	 * 插入一条数据到数据库
	 * @param sql   插入数据的sql指令（例：insert into person(id, name, age) values(?, ?, ?)）
	 * @param paras sql语句中预处理（？）的字段数据（例：new Object[]{001, "张三", 28}）
	 * @return      返回对数据库的实际影响条数（0-未插入一条数据  n-实际插入的数据条数）
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
	 * 删除指定数据
	 * @param sql 删除数据的sql指令（例：delete from users where id=? and name=?）
	 * @param     sql语句中预处理（？）的字段数据（new Object[]{1, "张三"}）
	 * @return    返回对数据库的实际影响条数（0-未删除一条数据  n-删除的具体条数） 
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
	 * 更新数据库
	 * @param sql 更新数据的sql指令（例：update users set email=? where id=?）
	 * @param     sql语句中预处理（？）的字段数据（new Object[]{"xxx@xxx.com", 1}）
	 * @return    返回对数据库的实际影响条数（0-未更新一条数据  n-更新的具体条数） 
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
	 * 查询一条结果中的某个字段的值
	 * @param name  数据库字段名称
	 * @param sql   查询数据的sql指令
	 * @return      返回一条数据中的一个字段
	 * 
	 * 注意：确保查询的sql只返回一条数据
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
	 * 查询多条数据
	 * @param sql       查询数据的sql指令
	 * @param beanClass 封装一条数据的Bean类型
	 * @return          返回一个Bean类型的List
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
	 * 将使用结束的链接重新放回链接池
	 */
	private void release(Connection conn)
	{
		cp.release(conn);
	}
}
