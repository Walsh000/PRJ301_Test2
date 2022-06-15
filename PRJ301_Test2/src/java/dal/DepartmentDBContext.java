/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.Department;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class DepartmentDBContext extends DBContext<Department> {

    @Override
    public ArrayList<Department> list() {
        ArrayList<Department> deptList = new ArrayList<>();
        try {
            String sql = "SELECT did, dname from Department";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Department dept = new Department();
                dept.setId(resultSet.getInt("dId"));
                dept.setName(resultSet.getString("dName"));
                deptList.add(dept);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deptList;
    }

    @Override
    public Department get(Department entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Department entity) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO [dbo].[Department]\n" +
                    "           ([dID]\n" +
                    "           ,[dName])\n" +
                    "     VALUES\n" +
                    "           (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getName());
            
            EmployeeDBContext stdDBC = new EmployeeDBContext();
            stdDBC.insert(entity.getEmpList());
            
            statement.executeUpdate();
            
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DepartmentDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

    }

    @Override
    public void update(Department entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Department entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Department get(int id) {
        Department dept = null;
        try {
            String sql = "select did, dname from Department where dID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                dept = new Department();
                dept.setId(id);
                dept.setName(result.getString("dName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dept;
    }

}
