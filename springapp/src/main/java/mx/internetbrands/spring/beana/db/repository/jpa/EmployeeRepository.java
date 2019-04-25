package mx.internetbrands.spring.beana.db.repository.jpa;

import mx.internetbrands.spring.beana.db.entity.jpa.EmployeesEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository<E> extends CrudRepository<EmployeesEntity,Integer> {


}
