package mx.internetbrands.spring.beana.db.repository.jpa;

import mx.internetbrands.spring.beana.db.entity.jpa.EmployeesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface EmployeeRepository<E> extends CrudRepository<EmployeesEntity,Integer> {


    @Query(value = "SELECT * FROM employees e LIMIT 1000",nativeQuery = true)
    List<EmployeesEntity> getAllEmployees();
}
