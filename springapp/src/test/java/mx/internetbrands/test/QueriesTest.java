package mx.internetbrands.test;

import mx.internetbrands.spring.config.SpringJavaConfig;
import mx.internetbrands.spring.beana.db.repository.jdbc.dao.MysqlSimpleJDBC;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringJavaConfig.class)
public class QueriesTest {


    @Autowired
    MysqlSimpleJDBC mysqlSimpleJDBC;

    @Test
    public void departments(){
        assertTrue(mysqlSimpleJDBC.getDepartments().size()>0);

    }
    @Test
    public void count(){
        assertTrue(mysqlSimpleJDBC.countDepartments()>0);

    }






}
