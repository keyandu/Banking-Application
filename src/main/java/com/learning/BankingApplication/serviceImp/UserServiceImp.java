package com.learning.BankingApplication.serviceImp;

import com.learning.BankingApplication.entity.ERole;
import com.learning.BankingApplication.entity.Role;
import com.learning.BankingApplication.entity.Status;
import com.learning.BankingApplication.entity.User;
import com.learning.BankingApplication.model.CustomerInformation;
import com.learning.BankingApplication.repo.UserRepo;
import com.learning.BankingApplication.repo.UserRepository;
import com.learning.BankingApplication.request.ChangeCustomerStatusRequest;
import com.learning.BankingApplication.request.GetCustomerByIdRequest;
import com.learning.BankingApplication.response.GetCustomerByIdResponse;
import com.learning.BankingApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepo userRepository;
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
    public String changeCustomerStatus(ChangeCustomerStatusRequest changeCustomerStatusRequest) {
    	System.out.println(changeCustomerStatusRequest.getCustomerId());
        User customer = userRepository.findById(changeCustomerStatusRequest.getCustomerId()).orElse(null);
        if(customer==null){
            return "customer not find";
        }
        Status newStatus = changeCustomerStatusRequest.getStatus();
 
        System.out.println(customer);
        try{
            customer.setCustomerStatus(newStatus);
            userRepository.saveAndFlush(customer);
        }catch (Exception e){
            return "Customer status not changed";
        }


        return "success";
    }



    @Override
    public GetCustomerByIdResponse getCustomerById(GetCustomerByIdRequest getCustomerByIdRequest) {
        User user = userRepository.getById(getCustomerByIdRequest.getId());
        if(user!=null){
            return new GetCustomerByIdResponse(user.getId(),user.getFullname(),user.getCustomerStatus(),user.getCreateDate());
        }
        return null;
    }
}
