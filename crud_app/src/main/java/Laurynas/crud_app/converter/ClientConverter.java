package Laurynas.crud_app.converter;

import Laurynas.crud_app.dto.CreateClientRequestDTO;
import Laurynas.crud_app.dto.GetClientResponseDTO;
import Laurynas.crud_app.entities.Client;

import java.time.LocalDate;

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
            clientDTO.setAge(client.getAge());
        }
        return clientDTO;
    }

    public static Client convertCreateClientRequestDtoToClient(CreateClientRequestDTO requestDTO) {
        Client client = null;
        if (requestDTO != null){
            client = new Client();
            client.setEmail(requestDTO.getEmail());
            client.setName(requestDTO.getName());
            client.setSurname(requestDTO.getSurname());
            client.setAge(requestDTO.getAge());

        }
        return client;
    }

    public static Client patchClientFromCreateClientRequestDTO(Client client, CreateClientRequestDTO requestDTO){
        if (isNewStringValueEmptyNullOrSameAsOld(requestDTO.getName(), client.getName())){
            client.setName(requestDTO.getName());
        }
        if (isNewStringValueEmptyNullOrSameAsOld(requestDTO.getSurname(), client.getSurname())){
            client.setSurname(requestDTO.getSurname());
        }

        if (isNewStringValueEmptyNullOrSameAsOld(requestDTO.getEmail(), client.getEmail())){
            client.setEmail(requestDTO.getEmail());
        }
        if (isNewStringValueEmptyNullOrSameAsOldForDate(requestDTO.getDateOfBirth(), client.getDateOfBirth())){
            client.setDateOfBirth(requestDTO.getDateOfBirth());
        }
        return client;
    }

    private static boolean isNewStringValueEmptyNullOrSameAsOld(String newValue, String oldValue){
        return newValue != null && !newValue.isEmpty() && !newValue.equals(oldValue);
    }

    private static boolean isNewStringValueEmptyNullOrSameAsOldForDate(LocalDate newValue, LocalDate oldValue){
        return newValue != null  && !newValue.equals(oldValue);
    }
}
