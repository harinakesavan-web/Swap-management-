package Swap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Swap.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}

