package mx.internetbrands.test;

import com.mysql.jdbc.MySQLConnection;
import mx.internetbrands.spring.beana.db.entity.plain.Employee;
import mx.internetbrands.spring.beana.db.repository.jdbc.dao.EmployeeDAO;
import mx.internetbrands.spring.config.SpringJavaConfig;
import mx.internetbrands.util.dbconnection.DBConnection;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringJavaConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDAOTest {

    Logger log = Logger.getLogger(EmployeeDAOTest.class);

    @Autowired
    EmployeeDAO employeeDAO;

    Employee employee;

    @Before
    public void initialize() {
        employee = new Employee();
        employee.setEmpNo(700000L);
        employee.setBirthDate(new Date(Calendar.getInstance().getTime().getTime()));
        employee.setFirstName("New Employee");
        employee.setLastName("Employee");
        employee.setGender("F");
        employee.setHireDate(new Date(Calendar.getInstance().getTime().getTime()));
    }



    @Test
    public void addEmployee() {


        employeeDAO.addEmployee(employee);

        assertNotNull(employeeDAO.find(employee.getEmpNo()));
    }

    @Test
    public void addEmployeeSimpleJdbc() {


        employee.setEmpNo(700001);
        employeeDAO.addEmployeeSimpleJdbcInsert(employee);

        assertNotNull(employeeDAO.find(employee.getEmpNo()));
    }


    @Test
    public void addEmployeeNamedParameter() {

        employee.setEmpNo(700002);
        employeeDAO.addEmployeeNamedJdbcTemplate(employee);

        assertNotNull(employeeDAO.find(employee.getEmpNo()));
    }

    @Test
    public void addEmployeeSimpleJdbcWithMap() {


        employee.setEmpNo(700003);
        employeeDAO.addEmployeeSimpleJdbcInsertWithMap(employee);

        assertNotNull(employeeDAO.find(employee.getEmpNo()));
    }

    @Test
    public void editEmployee() {
        employee.setEmpNo(10001);
        employee.setFirstName("firstName changed");
        employeeDAO.editEmployee(employee);
        employee= employeeDAO.find(employee.getEmpNo());

        assertEquals("firstName changed", employee.getFirstName());
    }

    @Test
    public void deleteEmployee() {

        employee.setEmpNo(700005);
        employeeDAO.addEmployee(employee);
        employeeDAO.deleteEmployee(700005);

        assertNull(employeeDAO.find(700005));
    }

    @Test
    public void findAll() {

        List<Employee> employees = employeeDAO.findAll();
        Employee e=employeeDAO.find(10001);
        assertThat(employees,hasItems(e));

    }

    @Test
    public void deleteTestedEmployees() {

        employeeDAO.deleteEmployee(700000);
        employeeDAO.deleteEmployee(700001);
        employeeDAO.deleteEmployee(700002);
        employeeDAO.deleteEmployee(700003);
        assertNull(employeeDAO.find(700000));

    }




}
