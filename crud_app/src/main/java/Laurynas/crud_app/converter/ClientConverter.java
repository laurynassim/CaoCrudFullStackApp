package Laurynas.crud_app.converter;

import Laurynas.crud_app.dto.CreateClientRequestDTO;
import Laurynas.crud_app.dto.GetClientResponseDTO;
import Laurynas.crud_app.entities.Client;

public class ClientConverter {

    public static GetClientResponseDTO convertClientToGetClientResponseDTO(Client client) {
        GetClientResponseDTO clientDTO = null;
        if (client != null) {
            clientDTO = new GetClientResponseDTO();
            clientDTO.setEmail(client.getEmail());
            clientDTO.setId(client.getId());
            clientDTO.setDateOfBirth(client.getDateOfBirth());
            clientDTO.setName(client.getName());
            clientDTO.setSurname(client.getSurname());
        }
        return clientDTO;
    }

    public static Client convertCreateClientRequestDtoToClient(CreateClientRequestDTO requestDTO) {
        Client client = null;
        if (requestDTO != null){
            client.setEmail(requestDTO.getEmail());
            client.setName(requestDTO.getName());
            client.setSurname(requestDTO.getSurname());

        }
        return client;
    }
}
