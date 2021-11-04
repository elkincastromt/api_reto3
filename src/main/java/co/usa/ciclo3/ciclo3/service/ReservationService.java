package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.reports.CountClient;
import co.usa.ciclo3.ciclo3.reports.ReservationStatus;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> paux=reservationRepository.getReservation(r.getIdReservation());
            if(paux.isEmpty()){
                return reservationRepository.save(r);
            }else{
                return r;
            }
        }
    }

    public Reservation update(Reservation r) {
        if (r.getIdReservation() != null) {
            Optional<Reservation> paux = reservationRepository.getReservation(r.getIdReservation());
            if (!paux.isEmpty()) {
                if (r.getStartDate() != null) {
                    paux.get().setStartDate(r.getStartDate());
                }
                if (r.getDevolutionDate() != null) {
                    paux.get().setDevolutionDate(r.getDevolutionDate());
                }
                if (r.getStatus() != null) {
                    paux.get().setStatus(r.getStatus());
                }
                return reservationRepository.save(paux.get());
            }
        }
        return r;
    }

    public boolean deleteReservation(int id) {
        Optional<Reservation> paux=getReservation(id);
        if(!paux.isEmpty()){
            reservationRepository.deleteReservation(paux.get());
            return true;
        }
        return false;
    }

    public ReservationStatus getReservationStatusReport(){
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
        return new ReservationStatus(completed.size(), cancelled.size());
    }

    public List<Reservation> getReservationPeriod(String dateOne, String dateTwo){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date startDate = dateFormat.parse(dateOne);
            Date endDate = dateFormat.parse(dateTwo);
            if (startDate.before(endDate)){
                return reservationRepository.getReservationPeriod(startDate, endDate);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<CountClient> getTopClient(){
        return reservationRepository.getTopClient();
    }

}




