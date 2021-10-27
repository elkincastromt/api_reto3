package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message m){
        if(m.getIdMessage()==null){
            return messageRepository.save(m);
        }else{
            Optional<Message> paux=messageRepository.getMessage(m.getIdMessage());
            if(paux.isEmpty()){
                return messageRepository.save(m);
            }else{
                return m;
            }
        }
    }

    public Message update(Message m) {
        if (m.getIdMessage() != null) {
            Optional<Message> paux = messageRepository.getMessage(m.getIdMessage());
            if (!paux.isEmpty()) {
                if (m.getMessageText() != null) {
                    paux.get().setMessageText(m.getMessageText());
                }
                return messageRepository.save(paux.get());
            }
        }
        return m;
    }

    public boolean deleteMessage(int id) {
        Optional<Message> paux=getMessage(id);
        if(!paux.isEmpty()){
            messageRepository.deleteMessage(paux.get());
            return true;
        }
        return false;
    }

}



