package mx.internetbrands.test;

import mx.internetbrands.spring.config.SpringJavaConfig;
import mx.internetbrands.util.FindContentType;
import mx.internetbrands.util.dbconnection.DBConnection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringJavaConfig.class)
public class SpringBeanTest {



    @Autowired
    FindContentType findContentType;

    @Autowired
    DBConnection mysqlConnection;





    @Test
    public void testContentTypeFromURL(){
        String contentType=findContentType.getContentType("https://images.pexels.com/photos/433301/pexels-photo-433301.jpeg?cs=srgb&dl=clouds-engine-iron-433301.jpg&fm=jpg");
        // String contentType=findContentType.getContentType("https://pepa.holla.cz/wp-content/uploads/2016/10/Docker-in-Action.pdf");

        assertEquals(String.format("El tipo de contenido no es igual al esperado [%s] actual [%s]", MediaType.IMAGE_JPEG_VALUE,contentType),MediaType.IMAGE_JPEG_VALUE,contentType);
    }

    @Test
    public  void testMysqlConnection(){
        assertNotNull(mysqlConnection.getConnection());
    }








}
