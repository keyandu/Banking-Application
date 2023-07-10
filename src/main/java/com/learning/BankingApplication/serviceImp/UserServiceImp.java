package com.learning.BankingApplication.serviceImp;


import com.learning.BankingApplication.entity.ERole;
import com.learning.BankingApplication.entity.PasswordResetToken;
import com.learning.BankingApplication.entity.Role;
import com.learning.BankingApplication.entity.Status;
import com.learning.BankingApplication.entity.User;
import com.learning.BankingApplication.model.CustomerInformation;
import com.learning.BankingApplication.payload.request.UpdateCustomerReq;
import com.learning.BankingApplication.payload.response.MessageResponse;
import com.learning.BankingApplication.payload.response.UserProfileResponse;
import com.learning.BankingApplication.repo.PasswordTokenRepo;
import com.learning.BankingApplication.repo.UserRepo;
import com.learning.BankingApplication.repo.UserRepository;
import com.learning.BankingApplication.request.ChangeCustomerStatusRequest;
import com.learning.BankingApplication.request.ChangeStaffStatusRequest;
import com.learning.BankingApplication.request.GetCustomerByIdRequest;
import com.learning.BankingApplication.response.GetCustomerByIdResponse;
import com.learning.BankingApplication.service.UserService;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	PasswordEncoder passwordEncoder;
    @Autowired
    UserRepo userRepository;
    @Autowired
    PasswordTokenRepo passwordTokenRepository;
    @Override
    public List<CustomerInformation> listAllCustomerByStaff() {
        List<User> users = userRepository.findAll();
        List<CustomerInformation> result = new ArrayList<CustomerInformation>();
        if(users!=null){
            for(User user : users){
                for(Role role : user.getRoles()){
                    if(role.getName().equals(ERole.ROLE_CUSTOMER)){
                        CustomerInformation customerInformation = new CustomerInformation();
                        customerInformation.setId(user.getId());
                        customerInformation.setName(user.getFullname());
                        customerInformation.setStatus(user.getCustomerStatus());
                        result.add(customerInformation);
                    }
                }
            }
        }
        return result;
    }

    @Override

    public String changeCustomerStatus(@Valid @RequestBody ChangeCustomerStatusRequest changeCustomerStatusRequest) {
        User customer = userRepository.findById(changeCustomerStatusRequest.getCustomerId()).orElse(null);

        if(customer==null){
            return "customer not find";
        }
        Status newStatus = changeCustomerStatusRequest.getStatus();
        if(newStatus==null) return "Instruction is null";
                try{
                    customer.setCustomerStatus(newStatus);
                    userRepository.save(customer);
                }catch (Exception e){
                    return "Customer status not changed";
                }
        return "success";
    }



    @Override
    public GetCustomerByIdResponse getCustomerById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        List role = user.getRoles().stream().map(x->x.getName()).collect(Collectors.toList());
       
        if(user!=null&&role.contains(ERole.ROLE_CUSTOMER)){
            return new GetCustomerByIdResponse(user.getId(),user.getFullname(),user.getCustomerStatus(),user.getCreateDate());
        }
        return null;
    }

	@Override
	public void createPasswordResetTokenForUser(User user, String token) {
		// TODO Auto-generated method stub
		PasswordResetToken myToken = new PasswordResetToken(token, user);
	    
		passwordTokenRepository.save(myToken);
		user.setPasswordResetToken(myToken);
		userRepository.save(user);
		
	}

	@Override
	public User getUserByPasswordResetToken(PasswordResetToken token) {
		return userRepository.getUserByPasswordResetToken(token);
	}

	@Override
	public void changeUserPassword(User user, String newPassword) {
		user.setPassword(passwordEncoder.encode(newPassword));
		userRepository.save(user);
		
	}

	@Override
	public ResponseEntity<?> updateById(Long id, UpdateCustomerReq c) {
		// TODO Auto-generated method stub
		User res = userRepository.findById(id).orElse(null);
		if(res!=null) {
			if(c.getEmail()!=null) res.setEmail(c.getEmail());
			res.setAddress(c.getAddress());
			res.setMobileNo(c.getMobileNo());
		}
		else return ResponseEntity.ok(new MessageResponse("Customer not exist."));
		userRepository.save(res);
		return ResponseEntity.ok(new MessageResponse("Customer Updated"));
	}

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<CustomerInformation> listAllStaffByAdmin() {
        List<User> users = userRepository.findAll();
        List<CustomerInformation> result = new ArrayList<CustomerInformation>();
        if(users!=null){
            for(User user : users){
                for(Role role : user.getRoles()){
                    if(role.getName().equals(ERole.ROLE_STAFF)){
                        CustomerInformation customerInformation = new CustomerInformation();
                        customerInformation.setId(user.getId());
                        customerInformation.setName(user.getFullname());
                        customerInformation.setStatus(user.getStaffStatus());
                        result.add(customerInformation);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public String enableOrDisableStaff(ChangeStaffStatusRequest changeStaffStatusRequest) {
    	System.out.println(changeStaffStatusRequest.getStaffId());
        User staff = userRepository.getById(changeStaffStatusRequest.getStaffId());
        System.out.println(staff.getRoles().contains(ERole.ROLE_STAFF));
        if(staff==null){
            return "staff not find";
        }
        Status newStatus = changeStaffStatusRequest.getStatus();
        System.out.println(newStatus);
        try{
            staff.setStaffStatus(newStatus);
            userRepository.save(staff);
        }catch (Exception e){
            return "staff status not changed";
        }
        return "success";
    }

	@Override
	public ResponseEntity<?> getUserProfile(Long id) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id).orElse(null);
		if(user==null) return ResponseEntity.ok(new MessageResponse("user not found"));
		UserProfileResponse userProfile = new UserProfileResponse(user.getId(), user.getFullname(), user.getUsername(), user.getEmail(), user.getMobileNo(), user.getAddress());
		return ResponseEntity.ok(userProfile);
	}
}
