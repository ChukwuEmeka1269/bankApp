package com.jdbc;

import com.jdbc.app_constants.AppConstant;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDb {
    public static void main(String[] args) throws SQLException {
        DataSource jdbcDataSource = createDataSource();
        try(Connection connection = jdbcDataSource.getConnection()){
            System.out.println("connection.isValid(0) = "+ connection.isValid(0));
        }
    }

    private static DataSource createDataSource(){
//        MysqlDataSource dataSource = new MysqlDataSource();
//        JdbcDataSource dataSource = new JdbcDataSource();
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(AppConstant.MYSQL_CONNECTION_URL);
        dataSource.setUsername(AppConstant.MYSQL_DB_NAME);
        dataSource.setPassword(AppConstant.MYSQL_DB_PASSWORD);

        return dataSource;
    }
}
