package mx.internetbrands.test;

import mx.internetbrands.spring.beana.db.entity.jpa.EmployeesEntity;
import mx.internetbrands.spring.beana.db.entity.jpa.SalariesEntity;
import mx.internetbrands.spring.beana.db.repository.jpa.EmployeeRepository;
import mx.internetbrands.spring.beana.db.repository.jpa.SalariesRepository;
import mx.internetbrands.spring.config.SpringJavaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringJavaConfig.class)
public class JpaRepositoryTest {


    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    SalariesRepository salariesRepository;




    @Test
    public void repositoryNotNull(){

        assertNotNull(employeeRepository);
        assertNotNull(salariesRepository);
    }

    @Test
    public void getEmployee(){
     EmployeesEntity employeesEntity=employeeRepository.findById(10001).orElse(null);


     assertNotNull(employeesEntity);

    }

    @Test
    public void saveEmployee(){

        EmployeesEntity employee = new EmployeesEntity();
        employee.setBirthDate(new Date(Calendar.getInstance().getTime().getTime()));
        employee.setEmpNo(600010);
        employee.setFirstName("New Data");
        employee.setLastName("old Data");
        employee.setGender("M");
        employee.setHireDate(new Date(Calendar.getInstance().getTime().getTime()));

        employeeRepository.save(employee);
        EmployeesEntity tmp = employeeRepository.findById(10001).orElse(null);


        assertNotNull(tmp);

    }

    @Test
    public void getAllEmployees(){

        List<EmployeesEntity> employeesEntities= employeeRepository.getAllEmployees();

        assertNotNull(employeesEntities);

    }

    @Test
    public void getAllSalaries(){

        List<SalariesEntity> salaries=salariesRepository.getAllSalaries(PageRequest.of(0, 50));
        List<SalariesEntity> ss=salariesRepository.findTop10BySalaryIsNotNull();

        assertNotNull(salaries);
        assertNotNull(ss);
    }



}
