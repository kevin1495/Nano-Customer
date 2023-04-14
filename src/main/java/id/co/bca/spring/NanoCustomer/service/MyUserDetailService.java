package id.co.bca.spring.NanoCustomer.service;

import id.co.bca.spring.NanoCustomer.model.MyUserDetail;
import id.co.bca.spring.NanoCustomer.model.User;
import id.co.bca.spring.NanoCustomer.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("No User Found");
        }
        return new MyUserDetail(user);
    }
}
