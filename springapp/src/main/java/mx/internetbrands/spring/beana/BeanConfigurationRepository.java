package mx.internetbrands.spring.beana;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import mx.internetbrands.util.FindContentType;
import mx.internetbrands.util.dbconnection.DBConnection;
import mx.internetbrands.util.dbconnection.impl.MysqlConnection;
import mx.internetbrands.util.dbconnection.impl.PostgresConnection;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
public class BeanConfigurationRepository {

    @Autowired
    Environment environment;

    @Value("${some.env.var}")
    String someEnv;

    @Bean
    public Date giveMeDate(){
        return new Date();

    }

    @Bean
    public MysqlDataSource mysqlDataSource(){
        MysqlDataSource mysqlDataSource= new MysqlDataSource();
        mysqlDataSource.setURL(environment.getProperty("mysql.jdbc.url"));
        mysqlDataSource.setUser(environment.getProperty("mysql.jdbc.user"));
        mysqlDataSource.setPassword(environment.getProperty("mysql.jdbc.password"));
        BeanPropertyRowMapper<FindContentType> d;
        return mysqlDataSource;
    }

    @Bean
    public DBConnection mysqlConnection(MysqlDataSource mysqlDataSource){

        return new MysqlConnection(mysqlDataSource);
    }

    @Bean
    public PGSimpleDataSource pgSimpleDataSource(){
        PGSimpleDataSource pgSimpleDataSource= new PGSimpleDataSource();
        pgSimpleDataSource.setUrl(environment.getProperty("postgres.jdbc.url"));
        pgSimpleDataSource.setUser(environment.getProperty("postgres.jdbc.user"));
        pgSimpleDataSource.setPassword(environment.getProperty("postgres.jdbc.password"));
        return pgSimpleDataSource;
    }

    @Bean
    public DBConnection postgresConnection(PGSimpleDataSource pgSimpleDataSource){
        return new PostgresConnection(pgSimpleDataSource);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(MysqlDataSource mysqlDataSource){
        return new JdbcTemplate(mysqlDataSource);

    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
        return new NamedParameterJdbcTemplate(mysqlDataSource());
    }




}
