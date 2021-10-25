package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Doctor;
import co.usa.ciclo3.ciclo3.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAll(){
        return doctorRepository.getAll();
    }

    public Optional<Doctor> getDoctor(int id){
        return doctorRepository.getDoctor(id);
    }

    public Doctor save(Doctor d){
        if(d.getId()==null){
            return doctorRepository.save(d);
        }else{
            Optional<Doctor> paux=doctorRepository.getDoctor(d.getId());
            if(paux.isEmpty()){
                return doctorRepository.save(d);
            }else{
                return d;
            }
        }
    }

}


