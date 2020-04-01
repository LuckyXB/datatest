package com.example.datatest.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class SqlExecutor implements AutoCloseable {

	private HikariDataSource dataSource;

	@Override
	public void close() throws Exception {
		this.dataSource.close();
	}

	// 配置数据源
	public SqlExecutor(String url, String username, String pwd) {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(pwd);
		config.setAutoCommit(true);
		this.dataSource = new HikariDataSource(config);
	}

	// 获取连接
	public Connection openConnnect() throws SQLException {
		return this.dataSource.getConnection();
	}

	/*
	 * 使用PreparedStatement 可以有效的防止sql注入，底层通过反斜杠\，将单引号转义
	 */
	// 查询全部数据
	public List<List<Object>> select(String sql, Object... args) throws SQLException {

		try (Connection conn = openConnnect()) {
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i + 1, args[i]);
				}
				try (ResultSet rs = ps.executeQuery(sql)) {
					System.out.println(ps);
					List<List<Object>> result = new ArrayList<>();
					int colcount = rs.getMetaData().getColumnCount();
					while (rs.next()) {
						List<Object> cols = new ArrayList<>();
						for (int i = 1; i <= colcount; i++) {
							cols.add(rs.getObject(i));
						}
						result.add(cols);
					}
					return result;
				}
			}
		}
	}

	// 查某一个对象的数据
	public <T> List<T> select(Class<T> clazz, String sql, Object... args) throws SQLException {
		try (Connection conn = openConnnect()) {
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i + 1, args[i]);
				}
				try (ResultSet rs = ps.executeQuery(sql)) {
					List<T> result = new ArrayList<>();
					ResultSetMetaData meta = rs.getMetaData();
					List<String> columns = new ArrayList<>();
					for (int i = 1; i <= meta.getColumnCount(); i++) {
						columns.add(meta.getColumnLabel(i));
					}
					while (rs.next()) {
						result.add(instanceOf(clazz, columns, rs));
					}
					return result;
				}
			}
		}
	}

	// 映射对象字段
	private <T> T instanceOf(Class<T> clazz, List<String> columns, ResultSet rs) {
		try {
			T bean = clazz.newInstance();
			int index = 0;
			for (String col : columns) {
				index++;
				Field f = clazz.getField(col);
				// 设置值
				f.set(bean, rs.getObject(index, f.getType()));
			}
			return bean;
		} catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException
				| IllegalArgumentException | SQLException e) {

			throw new RuntimeException(e.getMessage());
		}
	}

	// 插入数据
	public int insert(String perparedSql, Object... args) throws SQLException {
		try (Connection conn = openConnnect()) {
			try (PreparedStatement ps = conn.prepareStatement(perparedSql)) {
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i + 1, args[i]);
				}
				return ps.executeUpdate();
			}
		}
	}
	// 更新数据
	public int update(String perparedSql, Object... args) throws SQLException {
		return this.insert(perparedSql, args);
	}
	// 删除数据
	public int delete(String perparedSql, Object... args) throws SQLException {
		return this.insert(perparedSql, args);
	}
}
