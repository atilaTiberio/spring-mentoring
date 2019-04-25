package mx.internetbrands.spring.beana.db.entity.plain;


import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Employee implements Serializable {

  private long empNo;
  private java.sql.Date birthDate;
  private String firstName;
  private String lastName;
  private String gender;
  private java.sql.Date hireDate;

  public Employee(){

  }

  public Employee(long empNo, Date birthDate, String firstName, String lastName, String gender, Date hireDate) {
    this.empNo = empNo;
    this.birthDate = birthDate;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.hireDate = hireDate;
  }

  public long getEmpNo() {
    return empNo;
  }

  public void setEmpNo(long empNo) {
    this.empNo = empNo;
  }


  public java.sql.Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(java.sql.Date birthDate) {
    this.birthDate = birthDate;
  }


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public java.sql.Date getHireDate() {
    return hireDate;
  }

  public void setHireDate(java.sql.Date hireDate) {
    this.hireDate = hireDate;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "empNo=" + empNo +
            ", birthDate=" + birthDate +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", gender='" + gender + '\'' +
            ", hireDate=" + hireDate +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return getEmpNo() == employee.getEmpNo() &&
            Objects.equals(getBirthDate(), employee.getBirthDate()) &&
            Objects.equals(getFirstName(), employee.getFirstName()) &&
            Objects.equals(getLastName(), employee.getLastName()) &&
            Objects.equals(getGender(), employee.getGender()) &&
            Objects.equals(getHireDate(), employee.getHireDate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getEmpNo(), getBirthDate(), getFirstName(), getLastName(), getGender(), getHireDate());
  }
}
