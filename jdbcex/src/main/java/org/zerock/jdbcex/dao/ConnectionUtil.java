package org.zerock.jdbcex.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public enum ConnectionUtil {

    INSTANCE;

    private HikariDataSource ds;

    ConnectionUtil(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("4260");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setMaximumPoolSize(50);

        ds = new HikariDataSource(config);
        //HikariDataSource 클래스는 데이터베이스 커넥션 풀을 구현한 클래스.
    }

    public Connection getConnection() throws Exception {
        return ds.getConnection();
        /*
        HikariDataSource (객체 : ds)에서 getConnection() 메소드를 호출하 커넥션 풀에서 커넥션을 가져옴.
        이 메서드는 java.sql.Connection 인터페이스를 구현한 객체를 반환.
        이 후에는 이 커넥션 객체를 사용하여 SQL 쿼리를 실행하거나 다른 DB 작업 수행.
        */
    }

}
