package mx.internetbrands.spring.beana.db.entity.jpa;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "salaries", schema = "springdb", catalog = "")
@IdClass(SalariesEntityPK.class)
public class SalariesEntity {
    private int empNo;
    private int salary;
    private Date fromDate;
    private Date toDate;
    private EmployeesEntity employeesByEmpNo;

    @Id
    @Column(name = "emp_no")
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    @Basic
    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Id
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
        SalariesEntity that = (SalariesEntity) o;
        return empNo == that.empNo &&
                salary == that.salary &&
                Objects.equals(fromDate, that.fromDate) &&
                Objects.equals(toDate, that.toDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, salary, fromDate, toDate);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", nullable = false)
    public EmployeesEntity getEmployeesByEmpNo() {
        return employeesByEmpNo;
    }

    public void setEmployeesByEmpNo(EmployeesEntity employeesByEmpNo) {
        this.employeesByEmpNo = employeesByEmpNo;
    }


    @Override
    public String toString() {
        return "SalariesEntity{" +
                "empNo=" + empNo +
                ", salary=" + salary +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
