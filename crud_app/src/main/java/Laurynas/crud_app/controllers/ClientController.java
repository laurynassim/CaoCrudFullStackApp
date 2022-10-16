package Laurynas.crud_app.controllers;

import Laurynas.crud_app.dto.CreateClientRequestDTO;
import Laurynas.crud_app.dto.GetClientResponseDTO;
import Laurynas.crud_app.entities.Client;
import Laurynas.crud_app.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static Laurynas.crud_app.converter.ClientConverter.*;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    public void createClient(@RequestBody CreateClientRequestDTO createClientRequestDTO) {
        Client client = convertCreateClientRequestDtoToClient(createClientRequestDTO);
        this.clientService.saveClient(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putClientById(@PathVariable(name = "id") Long id, @RequestBody CreateClientRequestDTO requestDTO) {
        Client client = this.clientService.getClientById(id);

        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Client newClient = convertCreateClientRequestDtoToClient(requestDTO);
        newClient.setId(client.getId());
        this.clientService.saveClient(newClient);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<Void> patchClientById(@PathVariable(name = "id") Long id, @RequestBody CreateClientRequestDTO requestDTO){
        Client client = this.clientService.getClientById(id);

        if (client == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        patchClientFromCreateClientRequestDTO(client, requestDTO);
        this.clientService.saveClient(client);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetClientResponseDTO> getClientById(@PathVariable(name = "id")Long id){
        Client client = this.clientService.getClientById(id);

        if(client == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(convertClientToGetClientResponseDTO(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwnerById(@PathVariable(name ="id") Long id){
        this.clientService.deleteClientById(id);
        return ResponseEntity.ok().build();
    }
}
