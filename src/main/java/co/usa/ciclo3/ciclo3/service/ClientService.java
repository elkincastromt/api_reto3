package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client c){
        if(c.getIdClient()==null){
            return clientRepository.save(c);
        }else{
            Optional<Client> paux=clientRepository.getClient(c.getIdClient());
            if(paux.isEmpty()){
                return clientRepository.save(c);
            }else{
                return c;
            }
        }
    }

    public Client update(Client c) {
        if (c.getIdClient() != null) {
            Optional<Client> paux = clientRepository.getClient(c.getIdClient());
            if (!paux.isEmpty()) {
                if (c.getName() != null) {
                    paux.get().setName(c.getName());
                }
                if (c.getEmail() != null) {
                    paux.get().setEmail(c.getEmail());
                }
                if (c.getAge() != null) {
                    paux.get().setAge(c.getAge());
                }
                if (c.getPassword() != null) {
                    paux.get().setPassword(c.getPassword());
                }
                return clientRepository.save(paux.get());
            }
        }
        return c;
    }

    public boolean deleteClient(int id) {
        Optional<Client> paux=getClient(id);
        if(!paux.isEmpty()){
            clientRepository.deleteClient(paux.get());
            return true;
        }
        return false;
    }

}



