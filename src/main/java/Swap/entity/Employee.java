package Swap.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_master")
public class Employee {

    @Id
    private String empId;

    private String empName;

   // public Employee() {}

   // public Employee(String empId, String empName) {
   //     this.empId = empId;
   //     this.empName = empName;
   // }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}