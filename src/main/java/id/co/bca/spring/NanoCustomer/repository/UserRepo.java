package id.co.bca.spring.NanoCustomer.repository;

import id.co.bca.spring.NanoCustomer.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserModel, Integer> {
    UserModel findByUsername(String username);
}
