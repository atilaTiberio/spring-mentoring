package mx.internetbrands.spring.beana.db.entity.jpa;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "employees", schema = "springdb", catalog = "")
public class EmployeesEntity {
    private Integer empNo;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private Date hireDate;
    private Collection<DeptEmpEntity> deptEmpsByEmpNo;
    private Collection<DeptManagerEntity> deptManagersByEmpNo;
    private Collection<SalariesEntity> salariesByEmpNo;
    private Collection<TitlesEntity> titlesByEmpNo;

    @Id
    @Column(name = "emp_no")
    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    @Basic
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "hire_date")
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeesEntity that = (EmployeesEntity) o;
        return empNo == that.empNo &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(hireDate, that.hireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, birthDate, firstName, lastName, gender, hireDate);
    }

    @OneToMany(mappedBy = "employeesByEmpNo")
    public Collection<DeptEmpEntity> getDeptEmpsByEmpNo() {
        return deptEmpsByEmpNo;
    }

    public void setDeptEmpsByEmpNo(Collection<DeptEmpEntity> deptEmpsByEmpNo) {
        this.deptEmpsByEmpNo = deptEmpsByEmpNo;
    }

    @OneToMany(mappedBy = "employeesByEmpNo")
    public Collection<DeptManagerEntity> getDeptManagersByEmpNo() {
        return deptManagersByEmpNo;
    }

    public void setDeptManagersByEmpNo(Collection<DeptManagerEntity> deptManagersByEmpNo) {
        this.deptManagersByEmpNo = deptManagersByEmpNo;
    }

    @OneToMany(mappedBy = "employeesByEmpNo",fetch = FetchType.EAGER)
    public Collection<SalariesEntity> getSalariesByEmpNo() {
        return salariesByEmpNo;
    }

    public void setSalariesByEmpNo(Collection<SalariesEntity> salariesByEmpNo) {
        this.salariesByEmpNo = salariesByEmpNo;
    }

    @OneToMany(mappedBy = "employeesByEmpNo")
    public Collection<TitlesEntity> getTitlesByEmpNo() {
        return titlesByEmpNo;
    }

    public void setTitlesByEmpNo(Collection<TitlesEntity> titlesByEmpNo) {
        this.titlesByEmpNo = titlesByEmpNo;
    }

    @Override
    public String toString() {
        return "EmployeesEntity{" +
                "empNo=" + empNo +
                ", birthDate=" + birthDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", hireDate=" + hireDate +
                ", salariesByEmpNo=" + salariesByEmpNo +
                '}';
    }
}
