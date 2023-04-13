package id.co.bca.spring.NanoCustomer.repository;

import id.co.bca.spring.NanoCustomer.model.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepoSpringDataJPA extends JpaRepository<CardModel, Integer> {
    CardModel findCardById(Integer cid);
//    CardModel findCardByCustId(Integer cid);
}
