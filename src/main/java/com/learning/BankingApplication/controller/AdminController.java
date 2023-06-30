package com.learning.BankingApplication.controller;

import com.learning.BankingApplication.entity.ERole;
import com.learning.BankingApplication.entity.Role;
import com.learning.BankingApplication.entity.Status;
import com.learning.BankingApplication.entity.User;
import com.learning.BankingApplication.model.CustomerInformation;
import com.learning.BankingApplication.payload.request.SignupRequest;
import com.learning.BankingApplication.payload.response.MessageResponse;
import com.learning.BankingApplication.repo.RoleRepository;
import com.learning.BankingApplication.request.ChangeStaffStatusRequest;
import com.learning.BankingApplication.request.CreateStaffRequest;
import com.learning.BankingApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/createstaff")
    public ResponseEntity<?> registerUser(@Valid @RequestBody CreateStaffRequest createStaffRequest) {
        if (userService.existsByUsername(createStaffRequest.getStaffUserName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }



        // Create new user's account
        User user = new User(createStaffRequest.getStaffUserName(),
                createStaffRequest.getStaffFullName(),createStaffRequest.getEmail(),
                encoder.encode(createStaffRequest.getStaffPassword()));

        //Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        Role staffRole = roleRepository.findByName(ERole.ROLE_STAFF)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(staffRole);

        user.setStaffStatus(Status.Disable);

        user.setRoles(roles);
        userService.save(user);

        return ResponseEntity.ok(new MessageResponse("staff create successfully!"));
    }

    @GetMapping("/listAllStaff")
    public ResponseEntity<List<CustomerInformation>> listAllCustomer() {
        return new ResponseEntity<List<CustomerInformation>>(userService.listAllStaffByAdmin(), HttpStatus.OK);
    }
    @PutMapping("/EnableOrDisableStaff")
    public ResponseEntity<List<CustomerInformation>> EnableOrDisableStaff(@RequestBody ChangeStaffStatusRequest changeStaffStatusRequest) {
        String result=userService.enableOrDisableStaff(changeStaffStatusRequest);

        if(result.equals("staff status not changed")||result.equals("staff not find")){
            return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("enable or disable staff success", HttpStatus.OK);
    }

}
