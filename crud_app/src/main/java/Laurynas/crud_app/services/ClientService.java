package Laurynas.crud_app.services;

import Laurynas.crud_app.entities.Client;
import Laurynas.crud_app.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository clientRepository;


    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients(){return this.clientRepository.findAll();}

    public Client getClientById (Long id){
        Optional <Client> client = this.clientRepository.findById(id);
        if(client.isPresent()){
            return client.get();
        }else
            return null;
    }

    public void deleteClientById(Long id) {this.clientRepository.deleteById(id);}

    public void saveClient (Client client){this.clientRepository.save(client);}


    public int calculateClientAge(LocalDate clientDateOfBirth){
        return  Period.between(clientDateOfBirth, LocalDate.now()).getYears();
    }


}
