package Swap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SwapApplication {

    public static void main(String[] args) {

        SpringApplication.run(Swap.SwapApplication.class, args);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        System.out.println(
                passwordEncoder.encode("password123")
        );

    }
}
