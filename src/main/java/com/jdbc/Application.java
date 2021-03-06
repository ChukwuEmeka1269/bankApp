package com.jdbc;

import com.jdbc.app_constants.AppConstant;
import com.zaxxer.hikari.HikariDataSource;


import javax.sql.DataSource;
import java.sql.*;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Application {

    public static final String INSERT_INTO_USERS = "insert into" +
            " users (first_name, last_name, registration_date) " +
            "values (?,?,?)";

    public static void main(String[] args) throws SQLException {

        DataSource dataSource = createDataSource();


        try(Connection connection = dataSource.getConnection()){
            try(PreparedStatement statement = connection.prepareStatement(INSERT_INTO_USERS, Statement.RETURN_GENERATED_KEYS)){
                statement.setString(1, "Michael");
                statement.setString(2, "Emecheta");
                statement.setObject(3, LocalDateTime.now());

                statement.addBatch();


                statement.setString(1, "Ralph");
                statement.setString(2, "Ludo");
                statement.setObject(3, LocalDateTime.now());

                statement.addBatch();

//                statement.clearParameters(); Ensures the values of the setters are cleared before setting another

                statement.setString(1, "Eddie");
                statement.setString(2, "Hart");
                statement.setObject(3, LocalDateTime.now());

                statement.addBatch();

                int[] batchCount = statement.executeBatch();
                int sumOfRows = 0;
                for(int row : batchCount){
                    sumOfRows += row;
                }

                System.out.println("Inserted " + sumOfRows + " rows");

            }
        }

    }

    private static DataSource createDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(AppConstant.CONNECTION_URL);
        dataSource.setUsername(AppConstant.DB_NAME);
        dataSource.setPassword(AppConstant.DB_PASSWORD);

        return dataSource;
    }


}
