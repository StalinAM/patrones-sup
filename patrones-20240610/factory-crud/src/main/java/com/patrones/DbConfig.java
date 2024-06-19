package com.patrones;
import java.sql.Connection;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import com.patrones.factory.anotaciones.MiComponente;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@MiComponente(name="dbConfig", singleton=true)
public class DbConfig {
	HikariConfig config = new HikariConfig();
	HikariDataSource dataSource;
	{
		config.setJdbcUrl("jdbc:sqlite:patrones.db");
		config.setUsername("sa");
		config.setPassword("");
		
		dataSource = new HikariDataSource(config);
	}
	
	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
