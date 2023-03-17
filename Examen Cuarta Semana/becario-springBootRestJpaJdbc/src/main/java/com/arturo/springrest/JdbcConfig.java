package com.arturo.springrest;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//CLASE DE DEFINICION DE CONFIGURACION PARA INYECCION DE DATASOURCE PARA JDBC
@Configuration
public class JdbcConfig {
	@Bean(name="mySqlDataSource")
	@Primary
	public DataSource mySqlDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url("jdbc:mysql://localhost:3306/spring_becario_tracker?useSSL=false&serverTimezone=UTC");
		dataSourceBuilder.username("springbecario");
		dataSourceBuilder.password("springbecario");
		return dataSourceBuilder.build();
	}
}
