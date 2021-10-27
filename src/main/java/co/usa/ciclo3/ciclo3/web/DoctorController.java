package co.usa.ciclo3.ciclo3.web;


import co.usa.ciclo3.ciclo3.model.Doctor;
import co.usa.ciclo3.ciclo3.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Doctor")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/all")
    public List<Doctor> getDoctors(){
        return doctorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctor(@PathVariable("id") int id){
        return doctorService.getDoctor(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor save(@RequestBody Doctor d){
        return doctorService.save(d);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor update(@RequestBody Doctor d){
        return doctorService.update(d);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteDoctor(@PathVariable("id") int id){
        return doctorService.deleteDoctor(id);
    }

}
