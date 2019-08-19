package com.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookshop.common.ConfigManager;


/**
 * 操作数据库的基类
 * @author liyang
 *
 */
public class BaseDao {
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		//数据库驱动
		String driver = ConfigManager.getInstance().getString("jdbc.driver_class");
		//数据库url
		String url = ConfigManager.getInstance().getString("jdbc.connection.url");
		//数据库用户名
		String username = ConfigManager.getInstance().getString("jdbc.connection.username");
		//数据库密码
		String password = ConfigManager.getInstance().getString("jdbc.connection.password");
		Connection conn = null;
		try {
			//加载数据库驱动
			Class.forName(driver);
			//获得数据库连接
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 查询操作
	 * @param sql
	 * @param conn
	 * @param pstm
	 * @param rs
	 * @param params
	 * @return
	 */
	public static ResultSet execute(String sql,Connection conn,PreparedStatement pstm,
			ResultSet rs,Object...params) throws Exception{
		pstm = conn.prepareStatement(sql);
		for(int i=0;i<params.length;i++){
			pstm.setObject((i+1), params[i]);
		}
		rs = pstm.executeQuery();
		return rs;
	}
	
	/**
	 * 更新操作
	 * @param conn
	 * @param pstm
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static int execute(Connection conn,PreparedStatement pstm,
			String sql,Object...params) throws Exception{
		int updateRows = 0;
		pstm = conn.prepareStatement(sql);
		for(int i=0;i<params.length;i++){
			pstm.setObject((i+1), params[i]);
		}
		updateRows = pstm.executeUpdate();
		return updateRows;
	}
	
	/**
	 * 释放资源
	 * @param connection
	 * @param pstm
	 * @param rs
	 * @return
	 */
	public static void closeResource(Connection conn,PreparedStatement pstm,ResultSet rs){
		if(rs!=null){
			try {
				//关闭rs
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//GC回收
				rs = null;
			}
		}
		if(pstm!=null){
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//GC回收
				pstm = null;
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//GC回收
				conn = null;
			}
		}
	}
}
