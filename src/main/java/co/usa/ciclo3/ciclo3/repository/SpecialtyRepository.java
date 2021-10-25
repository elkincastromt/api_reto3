package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Specialty;
import co.usa.ciclo3.ciclo3.repository.crud.SpecialtyCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SpecialtyRepository {

    @Autowired
    private SpecialtyCrudRepository specialtyCrudRepository;

    public List<Specialty> getAll(){
        return (List<Specialty>) specialtyCrudRepository.findAll();
    }

    public Optional<Specialty> getSpecialty(int id){
        return specialtyCrudRepository.findById(id);
    }

    public Specialty save(Specialty s){
        return specialtyCrudRepository.save(s);
    }
}
