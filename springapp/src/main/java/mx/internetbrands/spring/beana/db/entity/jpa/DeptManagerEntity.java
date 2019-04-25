package mx.internetbrands.spring.beana.db.entity.jpa;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "dept_manager", schema = "springdb", catalog = "")
@IdClass(DeptManagerEntityPK.class)
public class DeptManagerEntity {
    private int empNo;
    private String deptNo;
    private Date fromDate;
    private Date toDate;
    private EmployeesEntity employeesByEmpNo;
    private DepartmentsEntity departmentsByDeptNo;

    @Id
    @Column(name = "emp_no")
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    @Id
    @Column(name = "dept_no")
    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    @Basic
    @Column(name = "from_date")
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Basic
    @Column(name = "to_date")
    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeptManagerEntity that = (DeptManagerEntity) o;
        return empNo == that.empNo &&
                Objects.equals(deptNo, that.deptNo) &&
                Objects.equals(fromDate, that.fromDate) &&
                Objects.equals(toDate, that.toDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, deptNo, fromDate, toDate);
    }

    @ManyToOne
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", nullable = false)
    public EmployeesEntity getEmployeesByEmpNo() {
        return employeesByEmpNo;
    }

    public void setEmployeesByEmpNo(EmployeesEntity employeesByEmpNo) {
        this.employeesByEmpNo = employeesByEmpNo;
    }

    @ManyToOne
    @JoinColumn(name = "dept_no", referencedColumnName = "dept_no", nullable = false)
    public DepartmentsEntity getDepartmentsByDeptNo() {
        return departmentsByDeptNo;
    }

    public void setDepartmentsByDeptNo(DepartmentsEntity departmentsByDeptNo) {
        this.departmentsByDeptNo = departmentsByDeptNo;
    }
}
