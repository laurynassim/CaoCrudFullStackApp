package Laurynas.crud_app.controllers;

import Laurynas.crud_app.dto.CreateClientRequestDTO;
import Laurynas.crud_app.entities.Client;
import Laurynas.crud_app.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static Laurynas.crud_app.converter.ClientConverter.convertCreateClientRequestDtoToClient;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients(){return clientService.getAllClients();}

    @PostMapping
    public void createClient(@RequestBody CreateClientRequestDTO createClientRequestDTO){
        Client client = convertCreateClientRequestDtoToClient (createClientRequestDTO);
        this.clientService.saveClient(client);
    }

}
