package id.co.bca.spring.NanoCustomer.service;

import id.co.bca.spring.NanoCustomer.model.OccupationModel;
import id.co.bca.spring.NanoCustomer.repository.OccupRepoSpringDataJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccupationService {
    @Autowired
    OccupRepoSpringDataJPA occupRepoSpringDataJPA;

    public void insert(OccupationModel occupationModel){occupRepoSpringDataJPA.save(occupationModel);}
    public void update(OccupationModel occupationModel){occupRepoSpringDataJPA.save(occupationModel);}
    public void delete(OccupationModel occupationModel){occupRepoSpringDataJPA.deleteById(occupationModel.getId());}
    public List<OccupationModel> all(){return occupRepoSpringDataJPA.findAll();}
}
