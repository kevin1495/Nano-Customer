package id.co.bca.spring.NanoCustomer.repository;

import id.co.bca.spring.NanoCustomer.model.OccupationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupRepoSpringDataJPA extends JpaRepository<OccupationModel, Integer> {
    OccupationModel findOccupationById(Integer oid);
}