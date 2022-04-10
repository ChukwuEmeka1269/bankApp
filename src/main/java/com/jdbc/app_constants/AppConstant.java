package com.jdbc.app_constants;

public class AppConstant {
    public static final String CONNECTION_URL = "jdbc:h2:/Users/user/Desktop/jdbc-book/src/main/resources/banking;INIT=RUNSCRIPT FROM 'classpath:schema.sql'";
    public static final String DB_NAME = "sa";
    public static final String DB_PASSWORD = "password123";

    public static final String HSQL_CONNECTION_URL = "jdbc:h2:\\tmp\\banking.xxx";
    public static final String HSQL_DB_NAME = "hxxx";
    public static final String HSQL_DB_PASSWORD = "passwordHxxx";

    public static final String MYSQL_CONNECTION_URL ="jdbc:mysql://localhost:3306/javabrainsdb";
    public static final String MYSQL_DB_NAME = "root";
    public static final String MYSQL_DB_PASSWORD = "Password1269";
//
//    public static final String HSQL_DB_NAME = "hsql";
//    public static final String HSQL_DB_PASSWORD = "passwordHsql123";
}
