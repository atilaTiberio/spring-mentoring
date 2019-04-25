package mx.internetbrands.spring.beana.db.repository.jdbc.dao;

import mx.internetbrands.spring.beana.db.entity.plain.Employee;

import java.util.List;

public interface EmployeeDAO {

    String INSERT_EMPLOYEE = "INSERT INTO employees(emp_no,birth_date,first_name,last_name,gender,hire_date) VALUES(?,?,?,?,?,?)";

    String INSERT_EMPLOYEE_NAMED_PARAMETER ="INSERT INTO employees(emp_no,birth_date,first_name,last_name,gender,hire_date) VALUES(:empNo,:birthDate,:firstName,:lastName,:gender,:hireDate)";

    String SELECT_EMPLOYEE_BY_ID="SELECT * FROM employees WHERE emp_no= ?";

    String UPDATE_EMPLOYEE_NAMED_PARAMETER ="UPDATE employees SET emp_no=:empNo, birth_date=:birthDate, first_name=:firstName, last_name=:lastName, hire_date=:hireDate WHERE emp_no=:empNo";

    String DELETE_EMPLOYEE = "DELETE FROM employees WHERE emp_no=?";

    String SELECT_ALL_EMPLOYEES="SELECT * FROM employees limit 100";

    void addEmployee(Employee employee);

    void addEmployeeSimpleJdbcInsert(Employee employee);

    void addEmployeeSimpleJdbcInsertWithMap(Employee employee);

    void addEmployeeNamedJdbcTemplate(Employee employee);


    void editEmployee(Employee employee);

    void deleteEmployee(long employeeId);

    Employee find(long employeeId);

    List< Employee > findAll();
}
