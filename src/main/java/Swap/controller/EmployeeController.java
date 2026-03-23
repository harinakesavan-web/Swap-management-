package Swap.controller;

import Swap.DTO.SwapDeleteRequest;
import Swap.entity.Admin;
import Swap.service.Deleteswap;
import Swap.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import Swap.entity.Employee;
import Swap.service.EmployeeService;

import java.time.LocalDate;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private final Deleteswap deleteswap;
    private final PasswordEncoder passwordEncoder;
    private final AdminRepository repository;

    public EmployeeController(Deleteswap deleteswap,
                              PasswordEncoder passwordEncoder,
                              AdminRepository repository) {
        this.deleteswap = deleteswap;
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    // Add Employee
    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee)
    {
        System.out.println("EmpId: " + employee.getEmpId());
        System.out.println("Name: " + employee.getEmpName());

        return employeeService.addEmployee(employee);
    }

    // Delete Employee
    @DeleteMapping("/delete/{empId}")
    public String deleteEmployee(@PathVariable String empId){
        return employeeService.deleteEmployee(empId);

    }



    @DeleteMapping("/swap/delete")
    public String deleteSwap(@RequestBody SwapDeleteRequest request) {

        // 🔐 Re-authenticate user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        Admin user = repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return "Invalid password ❌";
        }

        LocalDate localDate = LocalDate.parse(request.getDate());

        return deleteswap.deleteSwapRequest(request.getEmpId(), localDate);
    }

    @PostMapping("/register")
    public String register(@RequestBody Admin user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);

        return "User Registered";
    }

    }



