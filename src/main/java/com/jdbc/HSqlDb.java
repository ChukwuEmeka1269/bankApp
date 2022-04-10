package com.jdbc;

import com.jdbc.app_constants.AppConstant;
import org.h2.jdbcx.JdbcDataSource;
import org.vibur.dbcp.ViburDBCPDataSource;
import org.vibur.dbcp.ViburDataSource;

import javax.sql.DataSource;
import java.sql.Connection;


public class HSqlDb {
    public static void main(String[] args) throws Exception{
        DataSource source = createDataSource();
        try(Connection connection = source.getConnection()){
            System.out.println("connection.isValid = " + connection.isValid(0));
        }
    }

    private static DataSource createDataSource(){
        JdbcDataSource dataSource = new JdbcDataSource();
//        ViburDBCPDataSource dataSource = new ViburDBCPDataSource();
        dataSource.setUrl(AppConstant.HSQL_CONNECTION_URL);
        dataSource.setUser(AppConstant.HSQL_DB_NAME);
        dataSource.setPassword(AppConstant.HSQL_DB_PASSWORD);

        return dataSource;
    }
}
