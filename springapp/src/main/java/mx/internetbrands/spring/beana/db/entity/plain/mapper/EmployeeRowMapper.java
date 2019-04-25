package mx.internetbrands.spring.beana.db.entity.plain.mapper;

import mx.internetbrands.spring.beana.db.entity.plain.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee(
                resultSet.getInt("emp_no"),
                resultSet.getDate("birth_date"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("gender"),
                resultSet.getDate("hire_date")
                );
        return employee;
    }
}
