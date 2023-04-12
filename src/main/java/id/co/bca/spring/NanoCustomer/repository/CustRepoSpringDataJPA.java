package id.co.bca.spring.NanoCustomer.repository;

import id.co.bca.spring.NanoCustomer.model.CustomerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustRepoSpringDataJPA extends JpaRepository<CustomerModel,Integer> {
    CustomerModel findCustomerById(Integer id);
    List<CustomerModel> findAllByOrderByCustName();
    Page<CustomerModel> findAllByOrderByCustEmail(Pageable pageable);
}
