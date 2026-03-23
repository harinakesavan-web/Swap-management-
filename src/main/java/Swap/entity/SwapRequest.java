package Swap.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "swap_requests")
public class SwapRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_id")
    private String empId;

    @Column(name = "reason", nullable = false)
    private String reason;

    @Column(name = "status")
    private String status = "Accepted";

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    // Default constructor
    public SwapRequest() {
    }

    // Parameterized constructor
    public SwapRequest(String empId, String reason, String status) {
        this.empId = empId;
        this.reason = reason;
        this.status = status;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}