package mx.internetbrands.util.dbconnection.impl;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import mx.internetbrands.util.dbconnection.DBConnection;

import java.sql.Connection;

public class MysqlConnection implements DBConnection {

    MysqlDataSource mysqlDataSource;

    public MysqlConnection(MysqlDataSource mysqlDataSource){
        this.mysqlDataSource=mysqlDataSource;
    }

    @Override
    public Connection getConnection()  {
        Connection connection=null;

        try {
            connection = this.mysqlDataSource.getConnection();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }

}
