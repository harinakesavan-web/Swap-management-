package Swap.service;

import Swap.repository.SwapRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Swap.entity.Employee;
import Swap.repository.EmployeeRepository;

import java.time.LocalDate;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String addEmployee(Employee employee) {

        if(employee.getEmpId() == null || employee.getEmpName() == null || employee.getEmpName().isBlank()) {
            return "Employee-id and Employee-name are Mandatory";
            //         throw new RuntimeException("emp_id and emp_name are mandatory");
        }

        // Check if employee already exists
        if(employeeRepository.existsById(employee.getEmpId())){
            return "Employee already exists";
        }


        employeeRepository.save(employee);
        return "Employee added successfully";
    }

    public String deleteEmployee(String empId){

        if(!employeeRepository.existsById(empId)){
            return "Employee not found";
        }

        employeeRepository.deleteById(empId);
        return "Employee deleted successfully";
    }


}
