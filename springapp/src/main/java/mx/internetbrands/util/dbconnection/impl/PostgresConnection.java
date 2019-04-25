package mx.internetbrands.util.dbconnection.impl;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import mx.internetbrands.util.dbconnection.DBConnection;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.core.env.Environment;

import java.sql.Connection;

public class PostgresConnection implements DBConnection {


    PGSimpleDataSource pgSimpleDataSource;

    public PostgresConnection(PGSimpleDataSource pgSimpleDataSource){
        this.pgSimpleDataSource=pgSimpleDataSource;

    }

    @Override
    public Connection getConnection()  {
        Connection connection=null;

        try {

            connection = pgSimpleDataSource.getConnection();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }

}
