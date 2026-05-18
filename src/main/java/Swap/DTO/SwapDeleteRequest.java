package Swap.DTO;

public class SwapDeleteRequest {

    private String empId;
    private String date;
    private String password;

    // Getter for empId.
    //Testing the Branch functionality
    public String getEmpId() {
        return empId;
    }

    // Setter for empId
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    // Getter for date
    public String getDate() {
        return date;
    }

    // Setter for date
    public void setDate(String date) {
        this.date = date;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}