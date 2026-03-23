package Swap.service;

import Swap.repository.SwapRequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;


@Service
public class Deleteswap {

    private final SwapRequestRepository swapRequestRepository;

    public Deleteswap(SwapRequestRepository swapRequestRepository) {
        this.swapRequestRepository = swapRequestRepository;
    }

    public String deleteSwapRequest(String empId, LocalDate date){

            if(empId == null || empId.isBlank() || date == null ){
                return "Employee id and Date are mandatory";
            }


        // Check if record exists
        boolean exists = swapRequestRepository.existsByEmpIdAndDate(empId, date);

        if(!exists){
            return "No swap request found for this employee and date";
        }

        swapRequestRepository.deleteByEmpIdAndDate(empId, date);

        return "Swap request deleted successfully";
    }
}
