package Auth.service;

import Auth.dto.RegisterRequest;
import Auth.dto.LoginRequest;
import Auth.dto.LoginResponse;
import Auth.service.JwtService;
import Auth.entity.User;
import Auth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String register(RegisterRequest request) {

        // 1️⃣ Check username
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        // 2️⃣ Check email
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // 3️⃣ Create user
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        // 🔐 Hash password
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // default role
        user.setRole(
                request.getRole() == null ? "USER" : request.getRole()
        );

        userRepository.save(user);

        return "User registered successfully";
    }
    public LoginResponse login(LoginRequest request) {

        // 1️⃣ Find user
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        // 2️⃣ Validate password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        // 3️⃣ Generate JWT
        String token = jwtService.generateToken(user.getUsername());

        // 4️⃣ Return token
        return new LoginResponse(token);
    }
}
