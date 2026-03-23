package Auth.controller;

import Auth.dto.RegisterRequest;
import Auth.dto.LoginResponse;
import Auth.dto.LoginRequest;
import Auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
   public class controller {

      private final AuthService authService;

     public controller(AuthService authService) {
         this.authService = authService;
        }

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request) {
        System.out.println("starting service class" );
        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @GetMapping("/{id}")
    public String getUser(
            @PathVariable Long id
    ) {
        return "Successfully retrieved";
    }
}
