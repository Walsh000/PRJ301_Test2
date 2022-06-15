/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package object;

import java.sql.Date;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class Employee {
    private int ID;
    private String name;
    private Date dob;
    private boolean gender;
    private Department dept;

    public Employee() {
    }

    public Employee(int ID, String name, Date dob, boolean gender, Department dept) {
        this.ID = ID;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.dept = dept;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
    
    
}
