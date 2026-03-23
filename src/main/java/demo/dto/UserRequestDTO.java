package demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class UserRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotEmpty(message = "Orders list cannot be empty")
    private List<OrderRequestDTO> orders;
    // getters & setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<OrderRequestDTO> getOrders() {
        return orders;
    }
    public void setOrders(List<OrderRequestDTO> orders) {
        this.orders = orders;
    }
}
