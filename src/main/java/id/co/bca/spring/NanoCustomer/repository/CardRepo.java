package id.co.bca.spring.NanoCustomer.repository;

import id.co.bca.spring.NanoCustomer.model.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepo extends JpaRepository<CardModel, Integer> {
    CardModel findCardById(Integer cid);
    List<CardModel> findAllByCustId(Integer cid);
}
