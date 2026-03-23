package Swap.repository;

import Swap.entity.SwapRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface SwapRequestRepository extends JpaRepository<SwapRequest, Long> {

    // Find swap requests by employee id and date
    // Check if record exists
    @Query(value = "SELECT EXISTS (SELECT 1 FROM swap_requests WHERE emp_id = :empId AND DATE(created_at) = :date)",
            nativeQuery = true)
    boolean existsByEmpIdAndDate(@Param("empId") String empId,
                                 @Param("date") LocalDate date);

    // Delete swap request using empId and created_at date
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM swap_requests WHERE emp_id = :empId AND DATE(created_at) = :date",
            nativeQuery = true)
    void deleteByEmpIdAndDate(String empId, LocalDate date);

}