package mx.internetbrands.spring.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "mx.internetbrands.spring.beana")
@ImportResource(locations = "classpath:spring-context.xml")
public class SpringJavaConfig {





}
