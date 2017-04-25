package by.netcracker.bsuir.pz2.connectionPool;

import by.netcracker.bsuir.pz2.enumeration.MySqlPropertyKey;
import org.apache.tomcat.jdbc.pool.DataSource;

import java.sql.*;

public enum  ConnectionPool {

    INSTANCE;

    private DataSource dataSource = new DataSource();

    private ConnectionPool() {
        MySqlPropertyManager propertyManager = MySqlPropertyManager.INSTANCE;
        dataSource.setDriverClassName(propertyManager.getDbProperty(MySqlPropertyKey.SQL_DB_DRIVER));
        dataSource.setUrl(propertyManager.getDbProperty(MySqlPropertyKey.SQL_DB_URL));
        dataSource.setUsername(propertyManager.getDbProperty(MySqlPropertyKey.SQL_DB_USERNAME));
        dataSource.setPassword(propertyManager.getDbProperty(MySqlPropertyKey.SQL_DB_PASSWORD));
        dataSource.setInitialSize(Integer.parseInt(propertyManager.getDbProperty(MySqlPropertyKey.SQL_DB_POOL_SIZE)));
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection =  dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
