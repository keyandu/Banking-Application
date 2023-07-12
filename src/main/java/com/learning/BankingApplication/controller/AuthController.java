package com.learning.BankingApplication.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.BankingApplication.entity.ERole;
import com.learning.BankingApplication.entity.PasswordResetToken;
import com.learning.BankingApplication.entity.Role;
import com.learning.BankingApplication.entity.User;
import com.learning.BankingApplication.exception.UserNotFoundException;
import com.learning.BankingApplication.payload.request.LoginRequest;
import com.learning.BankingApplication.payload.request.PasswordDto;
import com.learning.BankingApplication.payload.request.SignupRequest;
import com.learning.BankingApplication.payload.response.JwtResponse;
import com.learning.BankingApplication.payload.response.MessageResponse;
import com.learning.BankingApplication.repo.PasswordTokenRepo;
import com.learning.BankingApplication.repo.RoleRepository;
import com.learning.BankingApplication.repo.UserRepository;
import com.learning.BankingApplication.security.jwt.JwtUtils;
import com.learning.BankingApplication.security.service.SecurityUserService;
import com.learning.BankingApplication.security.service.UserDetailsImpl;
import com.learning.BankingApplication.service.UserService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api") //root url
public class AuthController {
	
	@Autowired
	PasswordTokenRepo passwordTokenRepository;
  @Autowired
  private AuthenticationManager authenticationManager;
  
  @Autowired
  private SecurityUserService securityUserService;
  
  @Autowired
  private MessageSource messages;
  
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder encoder;

  @Autowired
  private JwtUtils jwtUtils;
  
  @Autowired
  private UserService userService;
  
  @Autowired
  private JavaMailSender mailSender;
  
  @Autowired
  private Environment env;
  
  @PostMapping("/customer/authenticate")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    System.out.println("JWT Token="+jwt);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());
    if(!roles.contains("ROLE_CUSTOMER"))return ResponseEntity.ok(new MessageResponse("You are not a customer"));
    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getFullname(), 
                         roles));
  }
  @PostMapping("/staff/authenticate")
  public ResponseEntity<?> authenticateStaff(@Valid @RequestBody LoginRequest loginRequest) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    System.out.println("JWT Token="+jwt);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());
    if(!roles.contains("ROLE_STAFF"))return ResponseEntity.ok(new MessageResponse("You are not a staff"));
    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getFullname(), 
                         roles));
  }
  @PostMapping("/admin/authenticate")
  public ResponseEntity<?> authenticateAdmin(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    System.out.println("JWT Token="+jwt);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());
    if(!roles.contains("ROLE_ADMIN"))return ResponseEntity.ok(new MessageResponse("You are not an admin"));
    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getFullname(), 
                         roles));
  }

  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }
    
    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }
    
 

    // Create new user's account
    User user = new User(signUpRequest.getUsername(), 
               signUpRequest.getFullname(),signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "staff":
          Role modRole = roleRepository.findByName(ERole.ROLE_STAFF)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);

          break;
        case "customer":
          Role userRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.saveAndFlush(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
  @PostMapping("/user/resetPassword/{email}")
  public ResponseEntity<?> resetPassword(HttpServletRequest request, @PathVariable("email") String userEmail) throws UserNotFoundException {
      User user = userRepository.findUserByEmail(userEmail);
      if (user == null) {
          throw new UserNotFoundException("User is not found");
      }
      String token = UUID.randomUUID().toString();
      userService.createPasswordResetTokenForUser(user, token);
      mailSender.send(constructResetTokenEmail(getAppUrl(request), 
        request.getLocale(), token, user));
      return ResponseEntity.ok(new MessageResponse(
    	       "reset email sent"));
  }
  private String getAppUrl(HttpServletRequest request) {
      return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
  }
  
  private SimpleMailMessage constructResetTokenEmail(
		  String contextPath, Locale locale, String token, User user) {
		    String url = contextPath + "/user/changePassword?token=" + token;
		    String message = "Your reset link is: ";
		    return constructEmail("Reset Password", message + " \r\n" + url, user);
		}

	private SimpleMailMessage constructEmail(String subject, String body, 
	  User user) {
	    SimpleMailMessage email = new SimpleMailMessage();
	    email.setSubject(subject);
	    email.setText(body);
	    email.setTo(user.getEmail());
	    email.setFrom("keyandu4@gmail.com");
	    return email;
	}	
	@PostMapping("/user/savePassword")
	public ResponseEntity<?> savePassword(final Locale locale, @Valid @RequestBody PasswordDto passwordDto) {
		System.out.println(passwordDto.getToken());
		final PasswordResetToken passToken = passwordTokenRepository.findByToken(passwordDto.getToken());
		
	    String result = securityUserService.validatePasswordResetToken(passToken);
	    
	    if(result != null) {
	        return ResponseEntity.ok(new MessageResponse("Invalid link or link is expired"));
	    }

	    User user = userService.getUserByPasswordResetToken(passToken);
	    if(user!=null) {
	        userService.changeUserPassword(user, passwordDto.getNewPassword());
	        return ResponseEntity.ok(new MessageResponse("Password updated successfully!"));
	    } else {
	        return ResponseEntity.ok(new MessageResponse("User not found"));
	    }
	}
}
