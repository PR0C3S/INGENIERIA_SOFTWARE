/*
package com.thunderteam.logico.services;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

public class JpaConfig {

    private static final String user = "sa";
    private static final String password = "1234";

    @Bean( name = "MsSqlServer")
    @Primary

    public DataSource localSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //remota
        dataSourceBuilder.url("jdbc:sqlserver://192.168.100.216:1433;");
        //dataSourceBuilder.url("jdbc:sqlserver://LAPAMPARA/SQLEXPRESS;databaseName=dealer");
        // local
        //dataSourceBuilder.url("jdbc:sqlserver://LAPAMPARA/SQLEXPRESS:1433;databaseName=dealer");
        dataSourceBuilder.username(user);
        dataSourceBuilder.password(password);
        DataSource dataSource = dataSourceBuilder.build();
        return dataSource;
    }
}
*/
