package mx.internetbrands.test;

import mx.internetbrands.util.FindContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class SpringBeanXMLTest {



    @Autowired
    FindContentType findContentType;

    @Autowired
    Date giveMeDate;



    @Test
    public void testContentType() throws IOException {
        String type=findContentType.getContentType(new File("notes.txt"));

        assertEquals(String.format("El tipo de contenido no es igual al esperado [%s] actual [%s]",MediaType.TEXT_PLAIN_VALUE,type),MediaType.TEXT_PLAIN_VALUE,type);
    }

    @Test
    public void testContentTypeFromURL(){
        String contentType=findContentType.getContentType("https://images.pexels.com/photos/433301/pexels-photo-433301.jpeg?cs=srgb&dl=clouds-engine-iron-433301.jpg&fm=jpg");
       // String contentType=findContentType.getContentType("https://pepa.holla.cz/wp-content/uploads/2016/10/Docker-in-Action.pdf");

        assertEquals(String.format("El tipo de contenido no es igual al esperado [%s] actual [%s]",MediaType.IMAGE_JPEG_VALUE,contentType),MediaType.IMAGE_JPEG_VALUE,contentType);
    }

    @Test
    public void testDateNotNull(){
        assertNotNull(giveMeDate);
    }



}
