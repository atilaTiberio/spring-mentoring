package mx.internetbrands.spring.beana.db.repository.jdbc.dao;


import mx.internetbrands.spring.beana.db.entity.jpa.DepartmentsEntity;
import mx.internetbrands.util.dbconnection.DBConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MysqlSimpleJDBC {

    @Autowired
    DBConnection mysqlConnection;

    public List<DepartmentsEntity> getDepartments() {
        List<DepartmentsEntity> departments= new ArrayList<>();

        try {
            Statement stmt = mysqlConnection.getConnection().createStatement();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT * FROM departments");
            while (rs.next()) {
                DepartmentsEntity d= new DepartmentsEntity();
                d.setDeptNo(rs.getString("dept_no"));
                d.setDeptName(rs.getString("dept_name"));
             departments.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departments;
    }

    public Integer countDepartments(){
        Integer total=0;
        try {
            Statement stmt = mysqlConnection.getConnection().createStatement();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT count(*) as total FROM departments");
            while (rs.next()) {
                total=rs.getInt("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
}
