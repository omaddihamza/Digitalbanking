package org.sid.endPoint;

import jakarta.mail.MessagingException;
import org.sid.dto.AuthResponseDTO;
import org.sid.dto.LoginDTO;
import org.sid.dto.RegisterDTO;
import org.sid.enumeration.Role;
import org.sid.entities.UserEntity;
import org.sid.repository.UserRepository;
import org.sid.security.JWTGenerator;
import org.sid.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTGenerator tokenGenerator;

    @Autowired
    private EmailService emailService;


    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenGenerator.generatorToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token),HttpStatus.OK);
    }
    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) throws MessagingException {
      /* if(userRepository.existsByEmail(registerDTO.getEmail())){
           return new ResponseEntity<>("email is taken", HttpStatus.BAD_REQUEST);
        }*/

        UserEntity user = new UserEntity();
        user.setUsername(registerDTO.getUserName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setRole(Role.USER);
        Context context = new Context();
        context.setVariable("name", registerDTO.getUserName());
        emailService.sendEmail(registerDTO.getEmail(), "Create account","registration",context);
        userRepository.save(user);
        return new ResponseEntity<>("user Register success", HttpStatus.OK);
    }
}
