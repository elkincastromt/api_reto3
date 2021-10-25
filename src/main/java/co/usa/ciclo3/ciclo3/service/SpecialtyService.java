package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Specialty;
import co.usa.ciclo3.ciclo3.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<Specialty> getAll(){
        return specialtyRepository.getAll();
    }

    public Optional<Specialty> getSpecialty(int id){
        return specialtyRepository.getSpecialty(id);
    }

    public Specialty save(Specialty s){
        if(s.getId()==null){
            return specialtyRepository.save(s);
        }else{
            Optional<Specialty> paux=specialtyRepository.getSpecialty(s.getId());
            if(paux.isEmpty()){
                return specialtyRepository.save(s);
            }else{
                return s;
            }
        }
    }

}