/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.Department;
import object.Employee;
import object.RandomNameGenerator;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class EmployeeDBContext extends DBContext<Employee> {

    public ArrayList<Employee> list(int deptId) {
        ArrayList<Employee> empList = new ArrayList<>();
        try {
            String sql = "SELECT eID, ename, dob, gender, d.did, dName "
                    + "from Dept d inner join Emp e on (d.dID = e.dID) "
                    + "where d.did = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, deptId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employee emp = new Employee();
                emp.setID(resultSet.getInt("EmpID"));
                emp.setName(resultSet.getString("eName"));
                emp.setDob(resultSet.getDate("dob"));
                emp.setGender(resultSet.getBoolean("gender"));

                Department dept = new Department();
                dept.setId(resultSet.getInt("did"));
                dept.setName(resultSet.getString("dName"));
                emp.setDept(dept);

                empList.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empList;
    }

    @Override
    public ArrayList<Employee> list() {
         ArrayList<Employee> empList = new ArrayList<>();
        try {
            String sql = "SELECT eid, ename, gender, dob, did from emp";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employee emp = new Employee();
                emp.setID(resultSet.getInt("eID"));
                emp.setName(resultSet.getString("eName"));
                emp.setDob(resultSet.getDate("dob"));
                emp.setGender(resultSet.getBoolean("gender"));
                emp.setDept(new Department());
                emp.getDept().setId(resultSet.getInt("did"));
                empList.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empList;
    }

    @Override
    public Employee get(Employee entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Employee entity) {
        try {
            String sql = "INSERT INTO Emp\n"
                    + "           ([eName]\n"
                    + "           ,[dob]\n"
                    + "           ,[gender]\n"
                    + "           ,[dID])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getName());
            statement.setDate(2, entity.getDob());
            statement.setBoolean(3, entity.isGender());
            statement.setInt(4, entity.getDept().getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert(ArrayList<Employee> empList) {
        try {
            connection.setAutoCommit(false);
            for (Employee emp : empList) {
                String sql = "INSERT INTO Emp\n"
                        + "           ([eName]\n"
                        + "           ,[dob]\n"
                        + "           ,[gender]\n"
                        + "           ,[dID])\n"
                        + "     VALUES\n"
                        + "           (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, emp.getName());
                statement.setDate(2, emp.getDob());
                statement.setBoolean(3, emp.isGender());
                statement.setInt(4, emp.getDept().getId());
                statement.executeUpdate();
            }
            connection.commit();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public void update(Employee entity) {
        try {
            String sql = "UPDATE Emp\n"
                    + "   SET [eName] = ?\n"
                    + "      ,[dob] = ?\n"
                    + "      ,[gender] = ?\n"
                    + "      ,[dID] = ?\n"
                    + " WHERE eID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getName());
            statement.setDate(2, entity.getDob());
            statement.setBoolean(3, entity.isGender());
            statement.setInt(4, entity.getDept().getId());
            statement.setInt(5, entity.getID());
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Employee entity) {
        try {
            String sql = "DELETE FROM Emp\n"
                    + "      WHERE EID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, entity.getID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Employee get(int id) {
        Employee emp = null;
        try {
            String sql = "select EID, ename, dob, gender, d.did, d.dName from Dept d inner join Emp e on (d.dID = e.dID) where EmployeeId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                emp = new Employee();
                emp.setID(id);
                emp.setName(result.getString("eName"));
                emp.setDob(result.getDate("dob"));
                emp.setGender(result.getBoolean("gender"));

                Department dept = new Department();
                dept.setId(result.getInt("did"));
                dept.setName(result.getString("dName"));
                emp.setDept(dept);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emp;
    }
//
//    public void generateData() {
//        Employee newEmp;
//        for (int i = 1; i <= 10; i++) {
//            int dept_No;
//            newEmp = new Employee();
//            newEmp.setDept(new Department());
//
//            dept_No = (int) (Math.random() * 5);
//            switch (dept_No) {
//                case 0:
//                    newEmp.getDept().setId(101);
//                    break;
//                case 1:
//                    newEmp.getDept().setId(102);
//                    break;
//                case 2:
//                    newEmp.getDept().setId(103);
//                    break;
//                case 3:
//                    newEmp.getDept().setId(205);
//                    break;
//                case 4:
//                    newEmp.getDept().setId(300);
//                    break;
//            }
//
//            String name = "";
//            RandomNameGenerator nameGen = new RandomNameGenerator();
//            int firstNameIndex = (int) (Math.random() * nameGen.getFirstName().size());
//            int lastNameIndex = (int) (Math.random() * nameGen.getLastName().size());
//            name += nameGen.getFirstName().get(firstNameIndex) + " "
//                    + nameGen.getLastName().get(lastNameIndex);
//            boolean gender = (int) (Math.random() * 2) == 0;
//
//            //Starting year of specified random date (including)
//            int startYear = 1980;
//            int endYear = 1995;
//            long start = Timestamp.valueOf(startYear + 1 + "-1-1 0:0:0").getTime();
//            long end = Timestamp.valueOf(endYear + "-1-1 0:0:0").getTime();
//            //The qualified number of 13-bit milliseconds is obtained.
//            long ms = (long) ((end - start) * Math.random() + start);
//            Date dob = new Date(ms);
//
//            newEmp.setName(name);
//            newEmp.setDob(dob);
//            newEmp.setGender(gender);
//            insert(newEmp);
//        }
//
//    }
}
