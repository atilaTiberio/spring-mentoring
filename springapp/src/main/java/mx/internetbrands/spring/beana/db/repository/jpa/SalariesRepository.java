package mx.internetbrands.spring.beana.db.repository.jpa;

import mx.internetbrands.spring.beana.db.entity.jpa.SalariesEntity;
import mx.internetbrands.spring.beana.db.entity.jpa.SalariesEntityPK;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SalariesRepository extends CrudRepository<SalariesEntity, SalariesEntityPK> {

    @Query(value = "SELECT s FROM SalariesEntity s LEFT JOIN FETCH s.employeesByEmpNo")
    List<SalariesEntity> getAllSalaries(Pageable pageable);

    List<SalariesEntity> findTop10BySalaryIsNotNull();




}
