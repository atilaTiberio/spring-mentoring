package mx.internetbrands.spring.beana.db.entity.jpa;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "departments", schema = "springdb", catalog = "")
public class DepartmentsEntity {
    private String deptNo;
    private String deptName;
    private Collection<DeptEmpEntity> deptEmpsByDeptNo;
    private Collection<DeptManagerEntity> deptManagersByDeptNo;

    @Id
    @Column(name = "dept_no")
    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    @Basic
    @Column(name = "dept_name")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentsEntity that = (DepartmentsEntity) o;
        return Objects.equals(deptNo, that.deptNo) &&
                Objects.equals(deptName, that.deptName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptNo, deptName);
    }

    @OneToMany(mappedBy = "departmentsByDeptNo")
    public Collection<DeptEmpEntity> getDeptEmpsByDeptNo() {
        return deptEmpsByDeptNo;
    }

    public void setDeptEmpsByDeptNo(Collection<DeptEmpEntity> deptEmpsByDeptNo) {
        this.deptEmpsByDeptNo = deptEmpsByDeptNo;
    }

    @OneToMany(mappedBy = "departmentsByDeptNo")
    public Collection<DeptManagerEntity> getDeptManagersByDeptNo() {
        return deptManagersByDeptNo;
    }

    public void setDeptManagersByDeptNo(Collection<DeptManagerEntity> deptManagersByDeptNo) {
        this.deptManagersByDeptNo = deptManagersByDeptNo;
    }
}
