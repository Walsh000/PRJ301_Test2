/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package object;

import java.util.ArrayList;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class Department {
    private int id;
    private String name;
    ArrayList<Employee> empList;

    public Department() {
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(ArrayList<Employee> stdList) {
        this.empList = stdList;
    }

    @Override
    public String toString() {
        return id + ", " + name + "\n";
    }
    
    
}
