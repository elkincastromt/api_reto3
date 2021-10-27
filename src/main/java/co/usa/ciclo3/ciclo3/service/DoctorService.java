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

    public Doctor update(Doctor d) {
        if (d.getId() != null) {
            Optional<Doctor> paux = doctorRepository.getDoctor(d.getId());
            if (!paux.isEmpty()) {
                if (d.getName() != null) {
                    paux.get().setName(d.getName());
                }
                if (d.getDescription() != null) {
                    paux.get().setDescription(d.getDescription());
                }
                if (d.getDepartment() != null) {
                    paux.get().setDepartment(d.getDepartment());
                }
                if (d.getYear() != null) {
                    paux.get().setYear(d.getYear());
                }
                if (d.getSpecialty() != null) {
                    paux.get().setSpecialty(d.getSpecialty());
                }
                return doctorRepository.save(paux.get());
            }
        }
        return d;
    }

    public boolean deleteDoctor(int id) {
        Optional<Doctor> paux=getDoctor(id);
        if(!paux.isEmpty()){
            doctorRepository.deleteDoctor(paux.get());
            return true;
        }
        return false;
    }

}


