package mx.internetbrands.spring.beana.db.repository.jdbc.dao.impl;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import mx.internetbrands.spring.beana.db.entity.plain.Employee;
import mx.internetbrands.spring.beana.db.entity.plain.mapper.EmployeeRowMapper;
import mx.internetbrands.spring.beana.db.repository.jdbc.dao.EmployeeDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Qualifier("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

    Logger log = Logger.getLogger(EmployeeDAOImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    MysqlDataSource mysqlDataSource;

    @Override
    public void addEmployee(Employee employee) {

        jdbcTemplate.update(INSERT_EMPLOYEE,
                employee.getEmpNo(),
                employee.getBirthDate(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getGender(),
                employee.getHireDate());


        log.info("Employee added");
    }


    @Override
    public void addEmployeeSimpleJdbcInsert(Employee employee) {

        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(mysqlDataSource).withTableName("employees");
        simpleJdbcInsert.execute(new BeanPropertySqlParameterSource(employee));
        log.info("Employee added");
    }

    @Override
    public void addEmployeeSimpleJdbcInsertWithMap(Employee employee) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(mysqlDataSource).withTableName("employees");

        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("emp_no", employee.getEmpNo());
        parameters.put("birth_date", employee.getBirthDate());
        parameters.put("first_name", employee.getFirstName());
        parameters.put("last_name", employee.getLastName());
        parameters.put("gender", employee.getGender());
        parameters.put("hire_date", employee.getHireDate());

        simpleJdbcInsert.execute(parameters);

    }

    @Override
    public void addEmployeeNamedJdbcTemplate(Employee employee) {


        namedParameterJdbcTemplate.update(INSERT_EMPLOYEE_NAMED_PARAMETER, new BeanPropertySqlParameterSource(employee));
        log.info("Employee added");
    }

    @Override
    public Employee find(long employeeId) {

        /*
        if we don't want to catch EmptyResultDataAccessException

        List<Employee> employees=jdbcTemplate.query(SELECT_EMPLOYEE_BY_ID,new Object[]{employeeId},new BeanPropertyRowMapper(Employee.class));
        return employees.isEmpty()? null: employees.get(0);
        */
        try {
            return (Employee) jdbcTemplate.queryForObject(SELECT_EMPLOYEE_BY_ID, new Object[]{employeeId}, new EmployeeRowMapper());
        } catch (EmptyResultDataAccessException ersa) {
            log.error(ersa);
        }

        return null;
    }

    @Override
    public void editEmployee(Employee employee) {
        namedParameterJdbcTemplate.update(UPDATE_EMPLOYEE_NAMED_PARAMETER, new BeanPropertySqlParameterSource(employee));
    }

    @Override
    public void deleteEmployee(long employeeId) {
        jdbcTemplate.update(DELETE_EMPLOYEE, employeeId);
    }


    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query(SELECT_ALL_EMPLOYEES, new BeanPropertyRowMapper(Employee.class));
    }
}
